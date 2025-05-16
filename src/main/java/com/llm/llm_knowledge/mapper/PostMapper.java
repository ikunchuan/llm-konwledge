package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.dto.PostFavoriteDTO;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.entity.PostFavorite;
import com.llm.llm_knowledge.entity.PostLike;
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

    List<PostDTO> getTopPosts();

    List<PostDTO> getLatestPosts();

    List<PostDTO> getRecommendPosts();

    Integer getUserPostViewCount(Integer userId);

    Integer getUserPostLikeCount(Integer userId);

    Integer getUserPostFavoriteCount(Integer userId);

    Integer getUserPostCommentCount(Integer userId);

    Integer insertPost(Post post);

    Integer updateUserScoreForPost(Post post);

    PostDTO getPostAllCount(Integer postId);

    Integer addPostComment(Integer postId, Integer userId, String comment);

    List<Post> getPostsUser(Integer userId);

    List<Post> getUserPostLike(Integer userId);
}
