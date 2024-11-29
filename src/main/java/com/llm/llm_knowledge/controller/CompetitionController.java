package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comp/v1")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    @GetMapping("compe")
    public List<Competition> allCompe() {return competitionService.allCompe();}

    @GetMapping("compe/{compeid}")
    public Competition compeById(@PathVariable Integer compeid) {return competitionService.compeById(compeid);}

    @PostMapping("compe")
    public Integer addCompe( Competition competition) {return competitionService.addCompe(competition);}

    @DeleteMapping("compe/{compeid}")
    public Integer delCompe(@PathVariable Integer compeid) {return competitionService.delCompe(compeid);}

    @PutMapping("compe")
    public Integer UpdateCompe(Competition competition) {return competitionService.updateCompe(competition);}


}
