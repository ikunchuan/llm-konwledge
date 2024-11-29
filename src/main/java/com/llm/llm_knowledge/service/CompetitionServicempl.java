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
    public List<Competition> getAllCompetitions() {return competitionMapper.selectList(null);}

    @Override
    public Competition getCompetitionById(Integer id) {return competitionMapper.selectById(id);}

    @Override
    public Integer addCompetition(Competition competition) {return competitionMapper.insert(competition);}

    @Override
    public Integer updateCompetition(Competition competition) {return competitionMapper.updateById(competition);}

    @Override
    public Integer deleteCompetition(Integer id) {return competitionMapper.deleteById(id);}
}
