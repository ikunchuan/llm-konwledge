package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.entity.PostComment;
import com.llm.llm_knowledge.vo.PostSearch;

import java.util.List;

public interface PostService {
    
    IPage<Post> allPost(Integer pageNum,Integer pageSize);
    
    PageInfo<PostDTO> searchPost(PostSearch postSearch, Integer pageNum, Integer pageSize);
    
    
    Integer delPost(Integer postId);
    
    
    Integer delPostLogic(Integer postId);
    
    
    Integer addPost(Post post);
    
    
    Integer update(Post post);
    
    
    Post postById(Integer postId);
    
    
    List<PostCommentDTO> allPostComment(Integer postID);
    
    
    Integer delPostCommentLogic(Integer commentId);
    
    
    Integer postFavorite(Integer userId, Integer postId);
    
    
    Integer postView(Integer userId, Integer postId);
    
    
    Integer postLike(Integer userId, Integer postId);
    
    List<PostDTO> postMostLike();
    
    List<PostDTO> postEarlyLike();
    
    List<PostDTO> postRecommend();
    
    Integer getUserPostViewCount(Integer userId);
}
