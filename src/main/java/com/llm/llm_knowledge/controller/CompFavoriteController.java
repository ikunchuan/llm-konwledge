package com.llm.llm_knowledge.controller;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.exception.BizException;
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

    //用户收藏竞赛  传入竞赛Id和用户的Id
    @PostMapping("favorite")
    public Integer addCompFavorite(@RequestBody CompetitionFavorite competitionFavorite) {
        return compFavoriteService.addCompFavorite(competitionFavorite);
    }

    //删除(真删)
    @DeleteMapping("favorite/{id}")
    public Integer delCompFavorite(@PathVariable Integer id) {
        return compFavoriteService.delCompFavorite(id);
    }

    //多选删除
    @DeleteMapping("favorite")
    public Integer delCompFavoriteByIds(@RequestBody List<Integer> ids) {
        System.out.println("Received IDs: " + ids);
        return compFavoriteService.delCompFavoriteByIds(ids);
    }

    //更新
    @PutMapping("favorite")
    public Integer updCompFavorite(@RequestBody CompetitionFavorite competitionFavorite) {
        return compFavoriteService.updCompFavorite(competitionFavorite);
    }

    //分页查询
    @PostMapping("favorite/search")
    public PageInfo<CompFavoriteDTO> search(
            @RequestBody CompFavoriteSearch compFavoriteSearch,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) throws BizException {
        return compFavoriteService.search(compFavoriteSearch, pageNum, pageSize);
    }

    //userId查询
    @GetMapping("favorite/{userId}")
    public List<CompetitionFavorite> getCompFavoriteByUserId(@PathVariable Integer userId) {
        return compFavoriteService.getCompFavoriteByUserId(userId);
    }
}
