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
    
    
    
    /**用户新增帖子*/
    @PostMapping("add/postwithscore")
    public Integer insertPostAndUpdateScore(@RequestBody Post post) throws Exception {
        return postService.insertPostAndUpdateScore(post);
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
    @PostMapping("post/favorite")
    public Integer postFavorite(@RequestParam Integer userId,
                                @RequestParam Integer postId){
        return postService.postFavorite(userId,postId);
    }
    
    /**帖子浏览记录,点击一次帖子会加一条数据,点击同一个帖子会增加帖子浏览次数*/
    @PostMapping("post/view")
    public Integer postView(@RequestParam Integer userId,
                            @RequestParam Integer postId){
        return postService.postView(userId,postId);
    }
    
    
    /**帖子点赞,点击点赞会增加一条数据*/
    @PostMapping("post/like")
    public Integer postLike(@RequestParam Integer userId,
                            @RequestParam Integer postId){
        return postService.postLike(userId,postId);
    }
    

    
    /**最热门的帖子 根据点赞数来排名*/
    @GetMapping("post/mostlike")
    public List<PostDTO> postMostLike(){
        return postService.postMostLike();
    }
    
    
    /**最新的帖子 根据创建时间来排序*/
    @GetMapping("post/earlytime")
    public List<PostDTO> postEarlyTime(){
        return postService.postEarlyLike();
    }
    
    
    /**推荐帖子 根据每个用户来推荐 暂时写死*/
    @GetMapping("post/recommend")
    public List<PostDTO> postRecommend(){
        return postService.postRecommend();
    }
    
    
    /**某个用户的所有帖子加起来的浏览数*/
    @GetMapping("post/allview/{userId}")
    public Integer getUserPostViewCount(@PathVariable Integer userId){
        return postService.getUserPostViewCount(userId);
    }
    
    /**某个用户的所有帖子加起来的点赞数*/
    @GetMapping("post/alllike/{userId}")
    public Integer getUserPostLikeCount(@PathVariable Integer userId){
        return postService.getUserPostLikeCount(userId);
    }
    
    /**某个用户的所有帖子加起来的收藏数*/
    @GetMapping("post/allfavorite/{userId}")
    public Integer getUserPostFavoriteCount(@PathVariable Integer userId){
        return postService.getUserPostFavoriteCount(userId);
    }
    
    /**某个用户的所有帖子加起来的评论总数*/
    @GetMapping("post/allcomment/{userId}")
    public Integer getUserPostCommentCount(@PathVariable Integer userId){
        return postService.getUserPostCommentCount(userId);
    }
    
    /**传入帖子的id,查询这个帖子的浏览数,点赞数,收藏数,评论数
     * 注意 : 查到的是这个帖子过往的所有喜欢,收藏和评论, 取消过的也算*/
    @GetMapping("post/allcount/{postId}")
    public PostDTO getPostAllCount(@PathVariable Integer postId){
        return postService.getPostAllCount(postId);
    }
    
    
    /**帖子评论 传入用户ID 帖子ID 评论内容*/
    @PostMapping("post/usercomment")
    public Integer addPostComment(@RequestParam Integer postId,
                                  @RequestParam Integer userId,
                                  @RequestParam String comment){
        return postService.addPostComment(postId,userId,comment
        );
    }
    
    
    /**传入用户的Id,查询这个用户发过的所有帖子*/
    @GetMapping("user/{userId}")
    public List<Post> getPostsUser(@PathVariable Integer userId){
        return postService.getPostsUser(userId);
    }
    
    
    
}
