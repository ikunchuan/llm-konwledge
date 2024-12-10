package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.entity.PostComment;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.service.PostService;
import com.llm.llm_knowledge.vo.PostSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("v1/posts")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    /**查询所有帖子*/
    @PostMapping("/search")
    public PageInfo<PostDTO> allPost(@RequestBody PostSearch postSearch,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize) throws BizException {
        return postService.searchPost(postSearch,pageNum, pageSize);
    }
    
    
    /**根据id查看帖子,一般在点击详细之后调用这个方法*/
    @GetMapping("post/{postId}")
    public Post postById(@PathVariable Integer postId){
        return postService.postById(postId);
    }

    
    /**删除帖子*/
    @DeleteMapping("post/{postId}")
    public Integer delPost(@PathVariable Integer postId){
        return postService.delPost(postId);
    }
    
    
    /**删除帖子(逻辑删除)*/
    @PutMapping("post/logicdel/{postId}")
    public Integer delPostLogic(@PathVariable Integer postId){
        return postService.delPostLogic(postId);
    }
    
    
    /**删除评论(逻辑删除)*/
    @DeleteMapping("post/comment/logicdel/{commentId}")
    public Integer delPostCommentLogic(@PathVariable Integer commentId){
        return postService.delPostCommentLogic(commentId);
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
    
    
    /**查看帖子的评论,前端点击某一个帖子的评论,右边弹出一个抽屉,上方是帖子标题,下面是关于这条帖子所有的评论
     * @return PostCommentDTO */
    @GetMapping("post/comment/{postID}")
    public List<PostCommentDTO> allPostComment(@PathVariable Integer postID){
        return postService.allPostComment(postID);
    }
    
    /**用户收藏帖子,只要根据userId和userId就可以往表里面添加数据,因此直接用get请求*/
    @GetMapping("post/favorite")
    public Integer postFavorite(@RequestParam Integer userId,
                                @RequestParam Integer postId){
        return postService.postFavorite(userId,postId);
    }
    
    
    
}
