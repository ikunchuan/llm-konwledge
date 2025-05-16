package com.llm.llm_knowledge.service;

public interface PostLikeService {
    boolean isLiked(Integer userId, Integer postId);

    Integer updatePostLike(Integer userId, Integer postId);
}
