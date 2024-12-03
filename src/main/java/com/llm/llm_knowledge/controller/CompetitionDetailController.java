package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.CompetitionDetail;

import com.llm.llm_knowledge.service.CompetitionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @CrossOrigin
    @RequestMapping("comdetail/v1")
    public  class CompetitionDetailController {
        @Autowired
        private CompetitionDetailService competitionDetailService;
        //查看所有比赛信息
        @GetMapping("detail")
        public List<CompetitionDetail> allCompeDetail() {return competitionDetailService.allCompeDetail();}

        //根据ID进行查询
        @GetMapping("detail/{compeid}")
        public CompetitionDetail compeDetailById(@PathVariable Integer compeid) {return competitionDetailService.compeDetailById(compeid);}

        //添加竞赛信息
        @PostMapping("detail")
        public Integer addCompeDetail(@RequestBody CompetitionDetail competitionDetail) {
            return competitionDetailService.addCompeDetail(competitionDetail);}

        //根据ID删除比赛
        @DeleteMapping ("detail")
        public Integer deleteCompeDetail(@PathVariable Integer compeid) {return competitionDetailService.deleteCompeDetail(compeid);}

        //修改比赛详情信息
        @PutMapping("detail")
        public Integer updateCompeDetail(@RequestBody CompetitionDetail competitionDetail) {return competitionDetailService.updateCompeDetail(competitionDetail);}

        //分页查询
        @GetMapping("v1")
        public Page<CompetitionDetail> compeDetailByPage (Integer pageNum, Integer pageSize) {
            return competitionDetailService.compeDetailByPage(pageNum, pageSize);
        }

    }

