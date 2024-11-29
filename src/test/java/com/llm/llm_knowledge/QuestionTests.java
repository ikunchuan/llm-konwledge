package com.llm.llm_knowledge;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.mapper.QuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class QuestionTests {

    @Autowired
    private QuestionMapper questionMapper;

    //测试插入功能
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

    //测试删除操作
    @Test
    public void testDelete() {
        Question question = new Question();
        question.setQuestionId(2); //设置删除的记录的ID
        int result = questionMapper.deleteById(question);//会自动插入ID
        System.out.println(result);
    }

    // 测试根据ID删除
    // 如果配置完逻辑删除
    // 有逻辑删除的注解‘@TableLogic(value = "0",delval = "1")’的实体变量后，使用deleteById就是逻辑删除了
    @Test
    public void testDeleteById(){
        Integer i  = questionMapper.deleteById(1);
        System.out.println(i);
    }

    //测试多选ID删除
    @Test
    public void testDeleteByIds(){
        int i = questionMapper.deleteByIds(Arrays.asList(4,5));
        System.out.println(i);
    }

    //条件删除--map
    @Test
    public void testDeleteMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("question_title","两数之和1");
        questionMapper.deleteByMap(map);
    }

    //测试更新操作
    @Test
    public void testUpdate() {
        Question question = new Question();
        question.setQuestionId(3);
        question.setQuestionTitle("两数之和1");
        question.setQuestionText("给定一个整数数组 nums 和一个目标值 target，请你在数组中找出和为 target 的那 两个 数字，并返回它们的数组下标。你可以假设每个输入只对应 一个 答案，且你不能重复使用数组中同样的元素。");
        question.setCorrectAnswer("""
                输入：nums = [2, 7, 11, 15], target = 9
                输出：[0, 1]
                解释：因为 nums[0] + nums[1] == 9，所以返回 [0, 1]。""");
        int result = questionMapper.updateById(question);//会自动插入ID
        System.out.println(result);
    }

    //测试查全功能
    @Test
    void contextLoads() {
        List<Question> questionList = questionMapper.selectList(null);
        questionList.forEach(System.out::println);
    }

    //测试根据ID查询
    @Test
    public  void testSelectById(){
        Question question = questionMapper.selectById(1L);
        System.out.println(question);
    }

    //测试批量查询
    @Test
    public  void testSelectByIds(){
        List<Question> questionList =  questionMapper.selectByIds(Arrays.asList(1,2));
        questionList.forEach(System.out::println);
    }

    //测试条件查询之一使用map
    @Test
    public void testSelectByMaps(){
        HashMap<String,Object> map = new HashMap<>();
        //自定义查询条件
        map.put("question_title","两数之和");
        List<Question> users =  questionMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void testPages(){
        //参数1：当前页
        //参数2：页面数据量
        int current = 1;
        int size = 2;
        Page<Question> questionPage = new Page<>(current,size);
        questionMapper.selectPage(questionPage,null);
        //打印出来
        questionPage.getRecords().forEach(System.out::println);
        System.out.println(questionPage.getTotal());
    }
}
