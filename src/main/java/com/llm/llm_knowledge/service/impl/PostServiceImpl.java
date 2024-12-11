package com.llm.llm_knowledge.service.impl;

//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.github.pagehelper.PageHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.entity.Post;
//import com.llm.llm_knowledge.entity.PostComment;
import com.llm.llm_knowledge.entity.PostFavorite;
import com.llm.llm_knowledge.entity.PostLike;
import com.llm.llm_knowledge.mapper.PostMapper;
import com.llm.llm_knowledge.service.PostService;
import com.llm.llm_knowledge.vo.PostSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
//import java.util.stream.Collectors;

@Transactional
@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostMapper postMapper;
    
    //查询所有帖子
    @Override
    public IPage<Post> allPost(Integer pageNum,Integer pageSize) {
        Page<Post> page = new Page<>(pageNum,pageSize);
        return postMapper.selectPage(page,null);
    }
    
    
    
    //条件查询帖子 可以根据社区名,帖子名
    @Override
    public PageInfo<PostDTO> searchPost(@RequestBody PostSearch postSearch, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
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
    
    //用户收藏帖子
    @Override
    public Integer postFavorite(Integer userId, Integer postId) {
        PostFavorite postFavorite = postMapper.searchPostFavorite(userId, postId);
        if (postFavorite == null) {
            return postMapper.addPostFavorite(userId, postId);
        } else {
            return postMapper.updateFavoriteStatus(userId,postId);
        }
    }
    
    
    
    //用户帖子喜欢
    @Override
    public Integer postLike(Integer userId, Integer postId) {
        PostLike postLike = postMapper.searchPostLike(userId, postId);
        if (postLike == null) {
            return postMapper.addPostLike(userId, postId);
        } else {
            return postMapper.updateLikeStatus(userId,postId);
        }
    }
    
    
    
    //用户帖子浏览记录
    @Override
    public Integer postView(Integer userId, Integer postId) {
        return postMapper.addPostView(userId,postId);
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
