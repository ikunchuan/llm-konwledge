package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llm.llm_knowledge.dto.PostFavoriteDTO;
import com.llm.llm_knowledge.entity.PostFavorite;
import com.llm.llm_knowledge.mapper.PostFavoriteMapper;
import com.llm.llm_knowledge.service.PostFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostFavoriteServiceImpl implements PostFavoriteService {

    @Autowired
    private PostFavoriteMapper postFavoriteMapper;

    //用户收藏帖子
    @Override
    public Integer updatePostFavorite(Integer userId, Integer postId) {
        // 先查有没有这条记录
        QueryWrapper<PostFavorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("post_id", postId);
        PostFavorite record = postFavoriteMapper.selectOne(wrapper);
        if (record == null) {
            PostFavorite postFavorite = new PostFavorite();
            postFavorite.setUserId(userId);
            postFavorite.setPostId(postId);
            postFavorite.setIsFavorite("1");
            return postFavoriteMapper.insert(postFavorite);
            // 插入成功，返回1
        }else{
            record.setIsFavorite("1".equals(record.getIsFavorite()) ? "0" : "1");
            return postFavoriteMapper.updateById(record);
        }
    }

    //userId查询收藏的帖子√√√
    @Override
    public List<PostFavoriteDTO> getPostFavoriteByUserId(Integer userId) {
        return postFavoriteMapper.getPostFavoriteByUserId(userId);
    }

    @Override
    public boolean isCollected(Integer userId, Integer postId) {
        QueryWrapper<PostFavorite> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("post_id", postId)
                .eq("is_favorite", "1");
        return postFavoriteMapper.selectCount(wrapper) > 0;
    }

    @Override
    public Integer delCompFavorite(Integer id) {
        PostFavorite record = postFavoriteMapper.selectById(id);
        if (record == null) {
            return 0; // 如果没有找到记录，返回 0
        }else {
            record.setIsFavorite("0");
            return postFavoriteMapper.updateById(record);
        }
    }

}
