package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Competition;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompetitionServicempl implements CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;
    @Override
    public List<Competition> allCompe() {return competitionMapper.selectList(null);}

    @Override
    public Competition compeById(Integer compeid) {return competitionMapper.selectById(compeid);}

    @Override
    public Integer addCompe(Competition competition) {return competitionMapper.insert(competition);}

    @Override
    public Integer delCompe(Integer compeid) {return competitionMapper.deleteById(compeid);}

    @Override
    public Integer updateCompe(Competition competition) {return competitionMapper.updateById(competition);}


}
