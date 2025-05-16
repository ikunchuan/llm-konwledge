package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.PostFavoriteDTO;
import com.llm.llm_knowledge.entity.PostFavorite;

import java.util.List;

public interface PostFavoriteMapper extends BaseMapper<PostFavorite> {
    //根据用户查询出用户收藏的帖子
    List<PostFavoriteDTO> getPostFavoriteByUserId(Integer userId);
}
