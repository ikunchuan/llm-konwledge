package com.llm.llm_knowledge.controller;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseFavoriteDTO;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.CourseFavorite;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.service.CourseFavoriteService;
import com.llm.llm_knowledge.vo.CourseFavoriteSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("crs/v1")
public class CourseFavoriteController {
    
    @Autowired
    private CourseFavoriteService courseFavoriteService;

    //收藏课程
    @PostMapping("favorite")
    public Integer addCourseFavorite(@RequestBody CourseFavorite courseFavorite) {
        return courseFavoriteService.addCourseFavorite(courseFavorite);
    }

    //
    @DeleteMapping("favorite/{id}")
    public Integer delCourseFavorite(@PathVariable Integer id) {
        return courseFavoriteService.delCourseFavorite(id);
    }

    @DeleteMapping("favorite")
    public Integer delCourseFavoriteByIds(@RequestBody List<Integer> ids) {
        System.out.println("Received IDs: " + ids);
        return courseFavoriteService.delCourseFavoriteByIds(ids);
    }

    @PostMapping("favorite/search")
    public PageInfo<CourseFavoriteDTO> search(
            @RequestBody CourseFavoriteSearch courseFavoriteSearch,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) throws BizException {
        return courseFavoriteService.search(courseFavoriteSearch, pageNum, pageSize);
    }

    //查看某用户收藏的所有课程  传入userId
    @GetMapping("favorite/{userId}")
    public List<Course> getCourseFavoriteByUserId(@PathVariable Integer userId) {
        return courseFavoriteService.getCourseFavoriteByUserId(userId);
    }
}
