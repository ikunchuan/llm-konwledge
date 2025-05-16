package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.dto.PostFavoriteDTO;

import java.util.List;

public interface PostFavoriteService {

    Integer updatePostFavorite(Integer userId, Integer postId);

    List<PostFavoriteDTO> getPostFavoriteByUserId(Integer userId);

    boolean isCollected(Integer userId, Integer postId);

    Integer delCompFavorite(Integer id);
}
