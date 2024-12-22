package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.CompetitionDTO;
import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.service.CompetitionService;
import com.llm.llm_knowledge.vo.CompetitionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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

    @Override
    public CompetitionFavorite getCompetitionFavorite(Integer userId, Integer competitionId) {
        return competitionMapper.searchCompetitionFavorite(userId, competitionId);
    }


    //竞赛收藏记录,用户点击收藏后会收藏竞赛，再次点击取消收藏（逻辑删除）
    @Override
    public Integer addCompetitionFavorite(Integer userId, Integer competitionId) {
        CompetitionFavorite compFavoriteStatus  = competitionMapper.searchCompetitionFavorite(userId, competitionId);
        Integer result = null;
        if (compFavoriteStatus == null) {
            result = competitionMapper.addCompetitionFavorite(userId, competitionId);
        } else{
            // 执行更新操作
            competitionMapper.updateFavoriteStatus(userId, competitionId);
            // 根据当前状态决定返回值，执行更新操作
            if (compFavoriteStatus.getDeleted()== 0) {
                // 如果当前是收藏状态（deleted=0），则取消收藏（updated deleted=1）
                result = 2;  // 返回2表示取消收藏
            } else if (compFavoriteStatus.getDeleted()== 1) {
                // 如果当前是取消收藏状态（deleted=1），则恢复收藏（updated deleted=0）
                result = 3;  // 返回3表示恢复收藏
            }
        }
        return result;
    }
    
    
    //根据传过来的父id查所有的Competition
    @Override
    public List<Competition> getCompByParentId(Integer parentId) {
        // listComp 用来返回查到的数据
        List<Competition> listComp = new ArrayList<>();
        
        // 先查到传来的父id的所有子id
        List<Integer> childCategoryIds = competitionMapper.getChildByParent(parentId);
        System.out.println(childCategoryIds);
        
        // 如果没有childCategoryIds，或者childCategoryIds为空，则直接根据父id查询竞赛
        if (childCategoryIds == null || childCategoryIds.isEmpty()) {
            List<Competition> compeByIds = competitionMapper.getCompeByIds(parentId);
            listComp.addAll(compeByIds);
        } else {
            // 然后根据所有的子id来查找这些竞赛，把竞赛放到listComp里面
            for (Integer childId : childCategoryIds) {
                List<Competition> compeByIds = competitionMapper.getCompeByIds(childId);
                listComp.addAll(compeByIds);
            }
        }
        
        return listComp;
    }
    
    
}
