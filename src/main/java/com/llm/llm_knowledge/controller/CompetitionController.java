package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompetitionDTO;
import com.llm.llm_knowledge.entity.Competition;

import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.service.CompetitionService;
import com.llm.llm_knowledge.util.FileUtil;
import com.llm.llm_knowledge.vo.CompetitionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("comp/v1")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

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
    public Integer delCompe(@PathVariable Integer compeid) {return competitionService.delCompe(compeid);}

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

}
