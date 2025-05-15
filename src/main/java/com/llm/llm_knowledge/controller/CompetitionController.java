package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompetitionDTO;
import com.llm.llm_knowledge.entity.Competition;

import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.service.CompetitionService;
import com.llm.llm_knowledge.util.FileUtil;
import com.llm.llm_knowledge.vo.CompetitionSearch;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.neo4j.driver.Record; // 明确指定使用Neo4j的Record

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("comp/v1")
public class CompetitionController {
    
    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CompetitionMapper competitionMapper;

    private final Driver neo4jDriver;

    public CompetitionController(Driver neo4jDriver) {
        this.neo4jDriver = neo4jDriver;
    }

    //查看所有的比赛
    @GetMapping("compe")
    public List<Competition> allCompe() {return competitionService.allCompe();}
    
    //根据ID查询比赛
    @GetMapping("compe/{compeid}")
    public Competition compeById(@PathVariable Integer compeid) {return competitionService.compeById(compeid);}
    
    //添加比赛
    @PostMapping("compe")
    public Integer addCompe(@RequestBody Competition competition) {
        return competitionService.addCompe(competition);}
    
    //根据ID删除比赛
    @DeleteMapping("compe/{compeid}")
    public Integer delCompe(@PathVariable Integer compeid) {
        return competitionService.delCompe(compeid);
    }
    
    //根据ID批量删除
    @DeleteMapping("compe")
    public Integer deleteCompes(@RequestBody List<Integer> compeids) {
        System.out.println("received ids "+compeids);
        return competitionService.deleteCompes(compeids);
    }
    
    //修改（更新）比赛信息
    @PutMapping("compe")
    public Integer UpdateCompe(@RequestBody Competition competition) {return competitionService.updateCompe(competition);}
    
    //分页查询
    @GetMapping("v1")
    public Page<Competition> compePage( Integer pageNum, Integer pageSize) {
        return competitionService.compePage(pageNum, pageSize);
    }
    
    //多表联查并分页
    @PostMapping("search")
    public PageInfo<CompetitionDTO> search(@RequestBody CompetitionSearch competitionSearch,
                                           @RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "5") Integer pageSize) throws BizException {
        return competitionService.search(competitionSearch,pageNum,pageSize);
    }
    
    //图片上传
    @PostMapping ("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String oldFileName = file.getOriginalFilename();  // 获取原始文件名
        System.out.println(oldFileName);
        String typeName = oldFileName.substring(oldFileName.lastIndexOf('.'));  // 获取文件扩展名
        String filePath = FileUtil.getUpLoadFilePath();  // 获取文件保存路径
        System.out.println(typeName);
        String newFileName = System.currentTimeMillis() + oldFileName;  // 生成新文件名，防止覆盖
        
        try {
            // 保存文件到指定路径
            FileUtil.uploadFile(file.getBytes(), filePath, newFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);  // 如果上传失败，抛出运行时异常
        }
        
        return newFileName;  // 返回新文件名
    }
    
    //竞赛收藏记录,用户点击收藏后会收藏竞赛，再次点击取消收藏（逻辑删除）
    @PostMapping("compe/favorite")
    public Integer addCompetitionFavorite(@RequestParam Integer userId,
                                          @RequestParam Integer competitionId){
        return competitionService.addCompetitionFavorite(userId,competitionId);
    }


    @GetMapping("compe/favorite")
    public CompetitionFavorite getCompetitionFavorite(@RequestParam Integer userId,@RequestParam Integer competitionId){
        return competitionService.getCompetitionFavorite(userId,competitionId);
    }

    //传来一个category_id, 通过这个id找到所有的Competition
    @GetMapping("comp/byParentId")
    public List<Competition> getCompByParentId(@RequestParam Integer parentId){
        return competitionService.getCompByParentId(parentId);
    }

    
    //neo4j 根据传来的竞赛id，name查询竞赛 通过知识图谱的形式展现

    @GetMapping("/graph")
    public Map<String, Object> getCompetitionGraph(
            @RequestParam String name,
            @RequestParam(defaultValue = "2") int depth) {

        String cypher = """
            MATCH path = (c:Competition {name: $name})-[:REQUIRES_SKILL*1..%d]-(related)
            UNWIND nodes(path) as n
            UNWIND relationships(path) as r
            RETURN 
               [n in collect(DISTINCT n) | {id: id(n), label: labels(n)[0], name: n.name}] as nodes,
               [r in collect(DISTINCT r) | {source: id(startNode(r)), target: id(endNode(r)), type: type(r)}] as links
            """.formatted(depth);

        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(cypher, Values.parameters("name", name));
                Record record = result.single();

                // 显式类型转换
                List<Map<String, Object>> nodes = record.get("nodes").asList(v -> v.asMap());
                List<Map<String, Object>> links = record.get("links").asList(v -> v.asMap());

                return Map.of(
                        "nodes", nodes,
                        "links", links
                );
            });
        }
    }



    @GetMapping("comp/competitionName")
    public List<Competition> getCompByName(@RequestParam String competitionName){
        return competitionMapper.getCompByName(competitionName);
    }
    
    
    
    
    
    
}
