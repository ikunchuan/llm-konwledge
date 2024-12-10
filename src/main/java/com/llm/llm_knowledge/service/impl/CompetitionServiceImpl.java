package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompetitionDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.entity.PostFavorite;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.service.CompetitionService;
import com.llm.llm_knowledge.vo.CompetitionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@Transactional
public  class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;

    //查询
    @Override
    public List<Competition> allCompe() {return competitionMapper.selectList(null);}

    //根据ID进行查询
    @Override
    public Competition compeById(Integer compeid) {return competitionMapper.selectById(compeid);}

    //添加插入
    @Override
    public Integer addCompe(Competition competition) {
        int result = competitionMapper.insert(competition);
        System.out.println(result);
        System.out.println(competition);
        return result;
    }

    //进行删除--根据ID删除
    @Override
    public Integer delCompe(Integer compeid) {
        Integer result02 = competitionMapper.deleteById(compeid);
        System.out.println(result02);
        return result02;}

    //批量删除
    @Override
    public Integer deleteCompes(List<Integer> compeids) {
        if(compeids==null||compeids.isEmpty()){
            return 0;
        }
        //调用Mapper 层进行批量删除
        int result = competitionMapper.deleteByIds(compeids);
        System.out.println("删除的记录数：+" + result);
        return result;

    }


    //进行更新修改
    @Override
    public Integer updateCompe(Competition competition) {
        Integer result02 = competitionMapper.updateById(competition);
        System.out.println(result02);
        return result02;}

    //分页查询
    @Override
    public Page<Competition> compePage(Integer pageNum, Integer pageSize) {
        Page<Competition> page = new Page<>(pageNum, pageSize);
        Page<Competition> competitionPage = competitionMapper.selectPage(page, null);
        competitionPage.getRecords().forEach(System.out::println);
        return competitionPage;
    }

    @Override
    public PageInfo<CompetitionDTO> search(@RequestBody CompetitionSearch competitionSearch, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CompetitionDTO> competitionDTOS = competitionMapper.selectCompetitionWithFilters(competitionSearch);

        return new PageInfo<>(competitionDTOS);
    }
    
    
    //竞赛收藏记录,用户点击收藏后会收藏竞赛，再次点击取消收藏（逻辑删除）
    @Override
    public Integer addCompetitionFavorite(Integer userId, Integer competitionId) {
        CompetitionFavorite competitionFavorite = competitionMapper.searchCompetitionFavorite(userId, competitionId);
        if (competitionFavorite == null) {
            return competitionMapper.addCompetitionFavorite(userId, competitionId);
        } else {
            return competitionMapper.updateFavoriteStatus(userId,competitionId);
        }
    }
    
    
}
