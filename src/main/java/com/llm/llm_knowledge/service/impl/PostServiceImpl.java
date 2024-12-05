package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.PostCommentDTO;
import com.llm.llm_knowledge.dto.PostDTO;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.entity.PostComment;
import com.llm.llm_knowledge.mapper.PostMapper;
import com.llm.llm_knowledge.service.PostService;
import com.llm.llm_knowledge.vo.PostSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    
    @Override
    public List<PostCommentDTO> allPostComment(Integer postID) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("post_id",postID);
        return postMapper.selectPostCommentsWithFilters(postID);
    }
    
    
}
