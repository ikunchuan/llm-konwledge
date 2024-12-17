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

    //添加
    @Override
    public Integer addCourseFavorite(CourseFavorite courseFavorite) {
        return courseFavoriteMapper.insert(courseFavorite);
    }

    //单删
    @Override
    public Integer delCourseFavorite(Integer id) {
        return courseFavoriteMapper.deleteById(id);
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
    public List<CourseFavorite> getCourseFavoriteByUserId(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        return courseFavoriteMapper.selectList(queryWrapper);
    }
}
