package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Post;

import java.util.List;

public interface PostService {
    
    List<Post> allPost();
    
    List<Post> searchPost(String postTitle);
    
    Integer delPost(Integer postId);
    
    Integer addPost(Post post);
    
    Integer update(Post post);
}
