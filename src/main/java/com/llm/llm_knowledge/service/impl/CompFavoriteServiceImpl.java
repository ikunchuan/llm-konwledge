package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompFavoriteDTO;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.entity.CourseFavorite;
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
    private CompFavoriteMapper compFavoriteMapper;

    //取消收藏
    @Override
    public Integer delCompFavorite(Integer id) {
        CompetitionFavorite record = compFavoriteMapper.selectById(id);
        if (record == null) {
            return 0; // 如果没有找到记录，返回 0
        }else {
            record.setIsFavorite("0");
            return compFavoriteMapper.updateById(record);
        }
    }

    //批量删
    @Override
    public Integer delCompFavoriteByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0; // 如果没有传入 ids，则返回 0
        }
        // 调用 Mapper 层进行批量删除
        int result = compFavoriteMapper.deleteByIds(ids);
        System.out.println("删除的记录数: " + result);
        return result;
    }

    //分页查询
    @Override
    public PageInfo<CompFavoriteDTO> search(CompFavoriteSearch compSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CompFavoriteDTO> compFavoriteDTOS = compFavoriteMapper.selectFavoritesByCompetitionName(compSearch);
        return new PageInfo<>(compFavoriteDTOS);
    }

    //根据用户ID查询收藏夹
    @Override
    public List<CompFavoriteDTO> getCompFavoriteByUserId(Integer userId) {
        return compFavoriteMapper.getCompFavoriteByUserId(userId);
    }

    @Override
    public Integer updateCompFavorite(Integer userId, Integer compId) {
        // 先查有没有这条记录
        QueryWrapper<CompetitionFavorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("competition_id", compId);

        CompetitionFavorite record = compFavoriteMapper.selectOne(wrapper);
        if (record == null) {
//             没有，插入新的收藏记录
            CompetitionFavorite compFavorite = new CompetitionFavorite();
            compFavorite.setUserId(userId);
            compFavorite.setCompetitionId(compId);
            compFavorite.setIsFavorite("1");
            return compFavoriteMapper.insert(compFavorite);
        }else {
            // 有记录，更新 isFavorite 字段（0 -> 1 / 1 -> 0）
            record.setIsFavorite("1".equals(record.getIsFavorite()) ? "0" : "1");
            return compFavoriteMapper.updateById(record);
        }
    }

    @Override
    public boolean isCollected(Integer userId, Integer compId) {
        QueryWrapper<CompetitionFavorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("competition_id", compId)
                .eq("is_favorite", "1");
        return compFavoriteMapper.selectCount(wrapper) > 0;
    }
}
