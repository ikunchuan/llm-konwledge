package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llm.llm_knowledge.entity.PostFavorite;
import com.llm.llm_knowledge.entity.PostLike;
import com.llm.llm_knowledge.mapper.PostLikeMapper;
import com.llm.llm_knowledge.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostLikeServiceImpl implements PostLikeService {

    @Autowired
    private PostLikeMapper postLikeMapper;

    @Override
    public boolean isLiked(Integer userId, Integer postId) {
        QueryWrapper<PostLike> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("post_id", postId)
                .eq("is_liked", "1");
        return postLikeMapper.selectCount(wrapper) > 0;
    }

    //更新点赞
    @Override
    public Integer updatePostLike(Integer userId, Integer postId) {
        // 先查有没有这条记录
        QueryWrapper<PostLike> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("post_id", postId);
        PostLike record = postLikeMapper.selectOne(wrapper);
        if (record == null) {
            PostLike postLike = new PostLike();
            postLike.setUserId(userId);
            postLike.setPostId(postId);
            postLike.setIsLiked("1");
            return postLikeMapper.insert(postLike);
            // 插入成功，返回1
        }else{
            record.setIsLiked("1".equals(record.getIsLiked()) ? "0" : "1");
            return postLikeMapper.updateById(record);
        }
    }
}
