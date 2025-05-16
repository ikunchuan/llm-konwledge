package com.llm.llm_knowledge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.mapper.PostLikeMapper;
import com.llm.llm_knowledge.mapper.PostMapper;
import com.llm.llm_knowledge.service.OpenAiService;
import com.llm.llm_knowledge.service.PostService;
import com.llm.llm_knowledge.vo.PostSearch;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;

@Transactional
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private OpenAiService openAiService;
    @Autowired
    private PostLikeMapper postLikeMapper;

    //条件查询帖子 可以根据社区名,帖子名
    @Override
    public PageInfo<PostDTO> searchPost(@RequestBody PostSearch postSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostDTO> postDTOS = postMapper.selectPostsWithFilters(postSearch);
        return new PageInfo<>(postDTOS);
    }

    //根据帖子id删除帖子
    @Override
    public Integer delPost(Integer postId) {
        return postMapper.deleteById(postId);
    }

    //传来帖子的id,根据id来逻辑删除(隐藏)
    @Override
    public Integer delPostLogic(Integer postId) {
        return postMapper.delPostLogic(postId);
    }

    //传来帖子评论的id,根据id来逻辑删除(隐藏)
    @Override
    public Integer delPostCommentLogic(Integer commentId) {
        return postMapper.delPostCommentLogic(commentId);
    }

    //查找最火的几个帖子
    @Override
    public List<PostDTO> postMostLike() {
        return postMapper.getTopPosts();
    }

    //查找最新的几个帖子
    @Override
    public List<PostDTO> postEarlyLike() {
        return postMapper.getLatestPosts();
    }

    //推荐帖子
    @Override
    public List<PostDTO> postRecommend() {
        return postMapper.getRecommendPosts();
    }

    //用户发帖浏览数
    @Override
    public Integer getUserPostViewCount(Integer userId) {
        return postMapper.getUserPostViewCount(userId);
    }

    //用户发帖点赞数
    @Override
    public Integer getUserPostLikeCount(Integer userId) {
        return postMapper.getUserPostLikeCount(userId);
    }

    //用户发帖收藏数
    @Override
    public Integer getUserPostFavoriteCount(Integer userId) {
        return postMapper.getUserPostFavoriteCount(userId);
    }

    //用户发帖评论数
    @Override
    public Integer getUserPostCommentCount(Integer userId) {
        return postMapper.getUserPostCommentCount(userId);
    }

    //发帖积分
    @Override
    public Integer insertPostAndUpdateScore(Post post) throws Exception {

        try {
            postMapper.insertPost(post);
            postMapper.updateUserScoreForPost(post);
        } catch (Exception e) {
            throw new Exception("此方法执行失败,没有添加帖子,也没有增加积分");
        }
        return 1;
    }

    //传入帖子的Id,查询这个帖子的所有浏览数,点赞数....
    @Override
    public PostDTO getPostAllCount(Integer postId) {
        return postMapper.getPostAllCount(postId);
    }

    //用户评论帖子
    @Override
    public Integer addPostComment(Integer postId, Integer userId, String comment) {
        return postMapper.addPostComment(postId, userId, comment);
    }

    //查询用户的发帖
    @Override
    public List<Post> getPostsUser(Integer userId) {
        return postMapper.getPostsUser(userId);
    }

    //根据用户id查询出用户点赞的帖子
    @Override
    public List<Post> getUserPostLike(Integer userId) {
        return postMapper.getUserPostLike(userId);
    }

    @Override
    public Flux<ChatResponse> postAi(Integer postId) {
        String postContent = postMapper.selectById(postId).getPostContent();
        PromptTemplate promptTemplate = new PromptTemplate("请根据以下内容生成一段简洁的总结，在2句话之内: {query}");
        Prompt prompt = promptTemplate.create(Map.of("query", postContent));
        return openAiService.stream(prompt);
    }

    //用户帖子浏览记录
    @Override
    public Integer postView(Integer userId, Integer postId) {
        return postMapper.addPostView(userId, postId);
    }

    //新增帖子
    @Override
    public Integer addPost(Post post) {
        return postMapper.insert(post);
    }

    //更新帖子的信息
    @Override
    public Integer update(Post post) {
        return postMapper.updateById(post);
    }

    @Override
    public Post postById(Integer postId) {
        return postMapper.selectById(postId);
    }

    //查询某个帖子的所有评论
    @Override
    public List<PostCommentDTO> allPostComment(Integer postID) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("post_id",postID);
//
//        return postMapper.selectPostCommentsWithFilters(postID);

        System.out.println("查询的帖子ID：" + postID);
        List<PostCommentDTO> comments = postMapper.selectPostCommentsWithFilters(postID);
        System.out.println("查询结果：" + comments);
        return comments;
    }


}