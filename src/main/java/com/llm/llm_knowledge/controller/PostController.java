package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("posts/v1")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    /**查询所有帖子*/
    @GetMapping("postall")
    public IPage<Post> allPost(@RequestParam(value = "pageNum") Integer pageNum,
                                   @RequestParam(value = "pageSize") Integer pageSize) {
        return postService.allPost(pageNum, pageSize);
    }
    
    @GetMapping("post/{postId}")
    public Post postById(@PathVariable Integer postId){
        return postService.postById(postId);
    }
    
    
    /**根据帖子标题查询帖子*/
    @GetMapping("post/search")
    public List<Post> searchPostTitle(@RequestParam String postTitle){
        return postService.searchPost(postTitle);
    }
    
    /**删除帖子*/
    @DeleteMapping("post")
    public Integer delPost(@PathVariable Integer postId){
        return postService.delPost(postId);
    }
    
    /**增加帖子*/
    @PostMapping("post")
    public Integer addPost(@RequestBody Post post){
        return postService.addPost(post);
    }
    
    /**更新帖子*/
    @PutMapping("post")
    public Integer updatePost(@RequestBody Post post){
        return postService.update(post);
    }
    
}
