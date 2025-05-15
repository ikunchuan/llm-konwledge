package com.llm.llm_knowledge.controller;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.service.CompFavoriteService;
import com.llm.llm_knowledge.vo.CompFavoriteSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("comp/v1")
public class CompFavoriteController {

    @Autowired
    private CompFavoriteService compFavoriteService;

    //取消收藏
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

    //比赛名分页查询
    @PostMapping("favorite/search")
    public PageInfo<CompFavoriteDTO> search(
            @RequestBody CompFavoriteSearch compFavoriteSearch,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) throws BizException {
        return compFavoriteService.search(compFavoriteSearch, pageNum, pageSize);
    }

    //根据userId查询这个用户收藏的帖子
    @GetMapping("favorite/{userId}")
    public List<CompFavoriteDTO> getCompFavoriteByUserId(@PathVariable Integer userId) {
        return compFavoriteService.getCompFavoriteByUserId(userId);
    }

    //处理是否收藏
    @PostMapping("toggleFavorite")
    public Integer toggleFavorite(@RequestBody Map<String, Object> params) {
        Integer userId = Integer.valueOf(params.get("userId").toString());
        Integer compId = Integer.valueOf(params.get("compId").toString());
        return compFavoriteService.updateCompFavorite(userId, compId);
    }

    @GetMapping("favorite/isCollected")
    public boolean isCollected(@RequestParam Integer userId, @RequestParam Integer compId) {
        return compFavoriteService.isCollected(userId, compId);
    }
}
