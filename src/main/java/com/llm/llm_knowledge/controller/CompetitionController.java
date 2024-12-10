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
        String oldFileName = file.getOriginalFilename();
        System.out.println(oldFileName);
        String filePath = FileUtil.getUpLoadFilePath();
        String newFilePath = System.currentTimeMillis() + oldFileName;

        try {
            FileUtil.uploadFile(file.getBytes(),filePath,newFilePath);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newFilePath;
    }

}
