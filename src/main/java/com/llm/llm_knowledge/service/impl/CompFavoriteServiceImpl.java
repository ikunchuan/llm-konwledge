package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.mapper.CompFavoriteMapper;
import com.llm.llm_knowledge.service.CompFavoriteService;
import com.llm.llm_knowledge.vo.CompFavoriteSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompFavoriteServiceImpl implements CompFavoriteService {

    @Autowired
    private CompFavoriteMapper competitionFavoriteMapper;

    //插入
    @Override
    public Integer addCompFavorite(CompetitionFavorite competitionFavorite) {
        int result = competitionFavoriteMapper.insert(competitionFavorite);//会自动插入ID
        System.out.println(result);
        System.out.println(competitionFavorite);
        return result;
    }

    //单删
    @Override
    public Integer delCompFavorite(Integer id) {
        Integer i = competitionFavoriteMapper.deleteById(id);
        System.out.println(i);
        return i;
    }

    //批量删
    @Override
    public Integer delCompFavoriteByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0; // 如果没有传入 ids，则返回 0
        }
        // 调用 Mapper 层进行批量删除
        int result = competitionFavoriteMapper.deleteByIds(ids);
        System.out.println("删除的记录数: " + result);
        return result;
    }

    //更新
    @Override
    public Integer updCompFavorite(CompetitionFavorite competitionFavorite) {
        Integer i = competitionFavoriteMapper.updateById(competitionFavorite);
        System.out.println(i);
        return i;
    }

    //分页查询
    @Override
    public PageInfo<CompFavoriteDTO> search(CompFavoriteSearch compSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CompFavoriteDTO> compFavoriteDTOS = competitionFavoriteMapper.selectFavoritesByCompetitionName(compSearch);
        return new PageInfo<>(compFavoriteDTOS);
    }

    //根据用户ID查询收藏夹
    @Override
    public List<CompetitionFavorite> getCompFavoriteByUserId(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        return competitionFavoriteMapper.selectList(queryWrapper);
    }
}
