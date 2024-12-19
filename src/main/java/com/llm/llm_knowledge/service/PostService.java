package com.llm.llm_knowledge.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.entity.PostFavorite;
import com.llm.llm_knowledge.vo.PostSearch;

import java.util.List;

public interface PostService {

    IPage<Post> allPost(Integer pageNum, Integer pageSize);

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

    Integer getUserPostLikeCount(Integer userId);

    Integer getUserPostFavoriteCount(Integer userId);

    Integer getUserPostCommentCount(Integer userId);

    Integer insertPostAndUpdateScore(Post post) throws Exception;

    PostDTO getPostAllCount(Integer postId);

    Integer addPostComment(Integer postId, Integer userId, String comment);

    List<Post> getPostsUser(Integer userId);

    List<PostFavorite> getPostFavoriteByUserId(Integer userId);
    
    List<Post> getUserFavorite(Integer userId);
    
    List<Post> getUserPostLike(Integer userId);
}
