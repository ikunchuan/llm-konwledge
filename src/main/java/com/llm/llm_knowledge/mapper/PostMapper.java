package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CommunityDTO;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.entity.PostComment;
import com.llm.llm_knowledge.entity.PostFavorite;
import com.llm.llm_knowledge.entity.PostLike;
import com.llm.llm_knowledge.vo.CommunitySearch;
import com.llm.llm_knowledge.vo.PostSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper extends BaseMapper<Post> {
    
    List<PostDTO> selectPostsWithFilters(PostSearch postSearch);
    
    
    List<PostCommentDTO> selectPostCommentsWithFilters(Integer postId);
    
    
    //根据传来的帖子id隐藏帖子
    Integer delPostLogic(Integer postId);
    
    
    Integer delPostCommentLogic(Integer commentId);
    
    

    
    Integer addPostView(Integer userId, Integer postId);
    
    
    
    PostLike searchPostLike(Integer userId, Integer postId);
    
    Integer addPostLike(Integer userId, Integer postId);
    
    Integer updateLikeStatus(Integer userId, Integer postId);
    
    
    
    Integer addPostFavorite(Integer userId,Integer postId);
    
    PostFavorite searchPostFavorite(Integer userId, Integer postId);
    
    Integer updateFavoriteStatus(Integer userId, Integer postId);
    
    List<Post> getTopPosts();
    
    List<Post> getLatestPosts();
    
    List<Post> getRecommendPosts();
}
