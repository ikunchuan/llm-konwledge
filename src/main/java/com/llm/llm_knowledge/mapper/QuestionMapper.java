package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.QuestionDTO;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.vo.QuestionSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper extends BaseMapper<Question> {
    List<QuestionDTO> selectQuestionsWithFilters(QuestionSearch questionSearch);
}
