package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CourseFavoriteDTO;
import com.llm.llm_knowledge.entity.CourseFavorite;
import com.llm.llm_knowledge.mapper.CourseFavoriteMapper;
import com.llm.llm_knowledge.service.CourseFavoriteService;
import com.llm.llm_knowledge.vo.CourseFavoriteSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseFavoriteServiceImpl implements CourseFavoriteService {
    @Autowired
    private CourseFavoriteMapper courseFavoriteMapper;

    //单删
    @Override
    public Integer delCourseFavorite(Integer id) {
        CourseFavorite record = courseFavoriteMapper.selectById(id);
        if (record == null) {
            return 0; // 如果没有找到记录，返回 0
        }else {
            record.setIsFavorite("0");
            return courseFavoriteMapper.updateById(record);
        }
    }

    //多删
    @Override
    public Integer delCourseFavoriteByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0; // 如果没有传入 ids，则返回 0
        }
        int result = courseFavoriteMapper.deleteByIds(ids);
        System.out.println("删除的记录数: " + result);
        return result;
    }

    //分页查询
    @Override
    public PageInfo<CourseFavoriteDTO> search(CourseFavoriteSearch courseFavoriteSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CourseFavoriteDTO> compFavoriteDTOS = courseFavoriteMapper.selectFavoritesByCourseName(courseFavoriteSearch);
        return new PageInfo<>(compFavoriteDTOS);
    }

    @Override
    public List<CourseFavoriteDTO> getCourseFavoriteByUserId(Integer userId) {
        return courseFavoriteMapper.getCourseFavoriteByUserId(userId);
    }

    @Override
    public Integer updateCourseFavorite(Integer userId, Integer courseId) {
        // 先查有没有这条记录
        QueryWrapper<CourseFavorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("course_id", courseId);

        CourseFavorite record = courseFavoriteMapper.selectOne(wrapper);
        if (record == null) {
            // 没有，插入新的收藏记录
            CourseFavorite courseFavorite = new CourseFavorite();
            courseFavorite.setUserId(userId);
            courseFavorite.setCourseId(courseId);
            courseFavorite.setIsFavorite("1");
            return courseFavoriteMapper.insert(courseFavorite);
        }else {
            // 有记录，更新 isFavorite 字段（0 -> 1 / 1 -> 0）
            return courseFavoriteMapper.updateCourseFavorite(userId, courseId);
        }
    }

    public boolean isCollected(Integer userId, Integer courseId) {
        QueryWrapper<CourseFavorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("course_id", courseId)
                .eq("is_favorite", "1");
        return courseFavoriteMapper.selectCount(wrapper) > 0;
    }
}
