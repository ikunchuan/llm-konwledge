package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Post;
import com.llm.llm_knowledge.mapper.PostMapper;
import com.llm.llm_knowledge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Post> searchPost(String postTitle){
        QueryWrapper<Post> wrapper =  new QueryWrapper<Post>();
        wrapper.like("post_title",postTitle);
        return postMapper.selectList(wrapper);
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
    
    
}
