package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llm.llm_knowledge.entity.Post;

import java.util.List;

public interface PostService {
    
    IPage<Post> allPost(Integer pageNum,Integer pageSize);
    
    List<Post> searchPost(String postTitle);
    
    Integer delPost(Integer postId);
    
    Integer addPost(Post post);
    
    Integer update(Post post);
    
    Post postById(Integer postId);
}
