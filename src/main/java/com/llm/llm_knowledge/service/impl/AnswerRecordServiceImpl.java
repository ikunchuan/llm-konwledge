package com.llm.llm_knowledge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.AnswerRecordDTO;
import com.llm.llm_knowledge.entity.AnswerRecord;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.AnswerRecordMapper;
import com.llm.llm_knowledge.mapper.QuestionMapper;
import com.llm.llm_knowledge.service.AnswerRecordService;
import com.llm.llm_knowledge.vo.AnswerRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnswerRecordServiceImpl implements AnswerRecordService {
    /**
     * 基础业务
     **/
    @Autowired
    private AnswerRecordMapper answerRecordMapper;

    @Override
    public Integer addAnswerRecord(AnswerRecord answerRecord) {
        return answerRecordMapper.insert(answerRecord);
    }

    @Override
    public Integer delAnswerRecordById(Integer id) {
        return answerRecordMapper.deleteById(id);
    }

    @Override
    public Integer delAnswerRecordByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return 0; // 如果没有传入 ids，则返回 0
        }
        int result = answerRecordMapper.deleteByIds(ids);
        System.out.println("删除的记录数: " + result);
        return result;
    }

    @Override
    public Integer updAnswerRecord(AnswerRecord answerRecord) {
        return answerRecordMapper.updateById(answerRecord);
    }

    //做成无限刷新的分页，可以根据题目和分数搜索
    @Override
    public PageInfo<AnswerRecordVO> search(AnswerRecordDTO answerRecordDTO,
                                           Integer pageNum,
                                           Integer pageSize) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, pageSize);
        List<AnswerRecordVO> answerRecordVOS = answerRecordMapper.searchAnswerDetailsWithFilters(
                answerRecordDTO.getQuestionTitle(),
                answerRecordDTO.getQuestionText(),
                answerRecordDTO.getMinScore(),
                answerRecordDTO.getMaxScore());
        return new PageInfo<>(answerRecordVOS);
    }

    //id查做题记录
    @Override
    public List<AnswerRecord> findAnswerRecordByUserId(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        return answerRecordMapper.selectList(queryWrapper);
    }

    //答题记录
    @Autowired
    private QuestionMapper questionMapper;
    // 使用 ConcurrentHashMap 存储用户答题开始时间。传入做题ID和答题开始时间
//    private final Map<Integer, Long> startTimeMap = new ConcurrentHashMap<>();

    // 答题超时时间（单位：毫秒），这里设置为 1 小时
//    private static final long TIMEOUT = 60 * 60 * 1000;

    /*
     * 开始答题，记录开始时间
     */
//    public void startAnswer(Integer answerRecordId) {
//        startTimeMap.put(answerRecordId, System.currentTimeMillis());
//    }

    /*
     * 提交答案，计算并更新答题时间
     * @param answerRecordId 做题记录ID
     * @param answerGiven 用户输入的答案
     */
//    public void submitAnswer(Integer answerRecordId, String answerGiven) {
//
//        // 1. 查询题目详情
//        Long startTime = startTimeMap.get(answerRecordId);
//        if (startTime == null) {
//            throw new IllegalStateException("未找到开始答题的时间记录或已超时");
//        }
//
//        long endTime = System.currentTimeMillis();
//        int timeSpent = (int) ((endTime - startTime) / 1000); // 转换为秒
//
//        // 更新数据库
//        AnswerRecord answerRecord = new AnswerRecord();
//        answerRecord.setAnswerRecordId(answerRecordId);
//        answerRecord.setAnswerGiven(answerGiven);
//        answerRecord.setTimeSpent(timeSpent);
//        answerRecordMapper.updateById(answerRecord);
//
//        // 清理内存中的记录
//        startTimeMap.remove(answerRecordId);
//    }

    /*
     * 清理超时未提交的记录
     */
//    @Scheduled(fixedRate = 60000) // 每分钟（60*1000）执行一次
//    public void cleanExpiredRecords() {
//        long now = System.currentTimeMillis();
//        startTimeMap.entrySet().removeIf(entry -> now - entry.getValue() > TIMEOUT);
//    }

    /**
     * 判断题目的正确性并保存答题记录
     * @param answerRecordDTO 用户答题信息
     * @return result
     */
    public AnswerRecordVO judgeAndSaveAnswer(AnswerRecordDTO answerRecordDTO) {
        Integer userId = answerRecordDTO.getUserId();
        Integer questionId = answerRecordDTO.getQuestionId();
        String answerGiven = answerRecordDTO.getAnswerGiven();

        // 1. 查询题目详情
        Question question = questionMapper.selectById(questionId);
        System.out.println(question);
        if (question == null) {

            throw new RuntimeException("题目不存在！");
        }

        // 2. 判断答案是否正确
        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answerGiven);

        // 3. 计算得分
        int score = isCorrect ? 1 : 0; // 示例规则：正确得 1 分，错误得 0 分

        // 4. 保存做题记录
        AnswerRecord answerRecord = new AnswerRecord();
        answerRecord.setUserId(userId);
        answerRecord.setQuestionId(questionId);
        answerRecord.setAnswerGiven(answerGiven);
        answerRecord.setScore(score);
        answerRecord.setTimeSpent(30); // 示例：假设答题时间 30 秒就差时间
        answerRecordMapper.insert(answerRecord);

// 5. 直接使用已插入的 answerRecord 获取最新的 ID
        Integer answerRecordId = answerRecord.getAnswerRecordId();  // 获取自增 ID

//        //查询最新插入的答题记录
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("user_id", userId);
//        queryWrapper.eq("question_id", questionId);
//        queryWrapper.orderByDesc("created_time"); // 按照创建时间降序排列
//        AnswerRecord latestAnswerRecord = answerRecordMapper.selectOne(queryWrapper);

        // 5. 封装返回 VO
        AnswerRecordVO result = new AnswerRecordVO();
        result.setAnswerRecordId(answerRecordId);
        result.setUserId(userId);
        result.setQuestionId(questionId);
        result.setQuestionTitle(question.getQuestionTitle());
        result.setQuestionText(question.getQuestionText());
        result.setCorrectAnswer(question.getCorrectAnswer());
        result.setAnswerGiven(answerGiven);
        result.setScore(score);
        result.setQuestionLevel(question.getQuestionLevel());
        result.setTimeSpent(answerRecord.getTimeSpent());

        return result;
    }




}
