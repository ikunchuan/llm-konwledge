package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //修改（更新）比赛信息
    @PutMapping("compe")
    public Integer UpdateCompe(@RequestBody Competition competition) {return competitionService.updateCompe(competition);}

    //分页查询
    @GetMapping("v1")
    public Page<Competition> compePage( Integer pageNum, Integer pageSize) {
        return competitionService.compePage(pageNum, pageSize);
    }



}
