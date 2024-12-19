package com.llm.llm_knowledge.service;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.AnswerRecordDTO;
import com.llm.llm_knowledge.entity.AnswerRecord;
import com.llm.llm_knowledge.vo.AnswerRecordVO;

import java.util.List;

public interface AnswerRecordService {
    //基本业务
    Integer addAnswerRecord(AnswerRecord answerRecord);

    Integer delAnswerRecordById(Integer id);

    Integer delAnswerRecordByIds(List<Integer> ids);

    Integer updAnswerRecord(AnswerRecord answerRecord);

    PageInfo<AnswerRecordVO> search(AnswerRecordDTO answerRecordDTO,
                                    Integer pageNum,
                                    Integer pageSize);

    //做题
    //开始答题
//    void startAnswer(Integer answerRecordId);

    //提交答案
//    void submitAnswer(Integer answerRecordId, String answerGiven);

    //  判断
    AnswerRecordVO judgeAndSaveAnswer(AnswerRecordDTO answerRecordDTO);

    //用户id答题记录
    List<AnswerRecord> findAnswerRecordByUserId(Integer userId);
}
