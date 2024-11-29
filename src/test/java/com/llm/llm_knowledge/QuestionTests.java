package com.llm.llm_knowledge;

import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.QuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QuestionTests {

    @Autowired
    private QuestionMapper questionMapper;

    @Test
    void contextLoads() {
        List<Question> questionList = questionMapper.selectList(null);
        questionList.forEach(System.out::println);
    }//测试插入功能

    @Test
    public void testInsert() {
        Question question = new Question();
        question.setCategoryId(1);
        question.setQuestionTitle("两数之和");
        question.setQuestionText("给定一个整数数组 nums 和一个目标值 target，请你在数组中找出和为 target 的那 两个 数字，并返回它们的数组下标。你可以假设每个输入只对应 一个 答案，且你不能重复使用数组中同样的元素。");
        question.setCorrectAnswer("""
                输入：nums = [2, 7, 11, 15], target = 9
                输出：[0, 1]
                解释：因为 nums[0] + nums[1] == 9，所以返回 [0, 1]。""");
        int result = questionMapper.insert(question);//会自动插入ID
        System.out.println(result);
        System.out.println(question);
    }
}
