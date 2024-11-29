package com.llm.llm_knowledge.service;

import com.llm.llm_knowledge.entity.Competition;

import java.util.List;

public interface CompetitionService {

    public List<Competition> allCompe();

    public Competition compeById(Integer compeid);

    public Integer addCompe(Competition competition);

    public Integer delCompe(Integer compeid);

    public Integer updateCompe(Competition competition);




}
