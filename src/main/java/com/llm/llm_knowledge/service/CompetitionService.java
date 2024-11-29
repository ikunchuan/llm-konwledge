package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Competition;

import java.util.List;

public interface CompetitionService {

    public List<Competition> getAllCompetitions();

    public Competition getCompetitionById(Integer id);

    public Integer addCompetition(Competition competition);

    public Integer deleteCompetition(Integer id);

    public Integer updateCompetition(Competition competition);




}
