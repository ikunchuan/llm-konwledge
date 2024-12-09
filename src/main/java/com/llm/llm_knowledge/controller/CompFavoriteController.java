package com.llm.llm_knowledge.controller;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.service.CompFavoriteService;
import com.llm.llm_knowledge.vo.CompFavoriteSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("comp/v1")
public class CompFavoriteController {

    @Autowired
    private CompFavoriteService compFavoriteService;

    @PostMapping("favorite")
    public Integer addCompFavorite(CompetitionFavorite competitionFavorite) {
        return compFavoriteService.addCompFavorite(competitionFavorite);
    }

    @DeleteMapping("favorite/{id}")
    public Integer delCompFavorite(@PathVariable Integer id) {
        return compFavoriteService.delCompFavorite(id);
    }

    @DeleteMapping("favorite")
    public Integer delCompFavoriteByIds(@RequestBody List<Integer> ids) {
        System.out.println("Received IDs: " + ids);
        return compFavoriteService.delCompFavoriteByIds(ids);
    }

    @PutMapping("favorite")
    public Integer updCompFavorite(CompetitionFavorite competitionFavorite) {
        return compFavoriteService.updCompFavorite(competitionFavorite);
    }

    @PostMapping("favorite/search")
    public PageInfo<CompFavoriteDTO> search(CompFavoriteSearch compFavoriteSearch, Integer pageNum, Integer pageSize) {
        return compFavoriteService.search(compFavoriteSearch,pageNum,pageSize);
    }
}
