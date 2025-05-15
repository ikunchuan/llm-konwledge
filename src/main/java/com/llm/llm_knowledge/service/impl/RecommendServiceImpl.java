package com.llm.llm_knowledge.service.impl;

import com.llm.llm_knowledge.entity.*;
import com.llm.llm_knowledge.mapper.*;
import com.llm.llm_knowledge.service.RecommendService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import static cn.dev33.satoken.SaManager.log;

@Service
@Transactional // 添加类级别注解
public class RecommendServiceImpl implements RecommendService {

    private final UserInfoMapper userInfoMapper;
    private final CourseMapper courseMapper;
    private final CompetitionMapper competitionMapper;

    public RecommendServiceImpl(UserInfoMapper userInfoMapper,
                                CourseMapper courseMapper,
                                CompetitionMapper competitionMapper) {
        this.userInfoMapper = userInfoMapper;
        this.courseMapper = courseMapper;
        this.competitionMapper = competitionMapper;
    }


    @Override
    public List<Course> recommendCoursesByKnowledge(Integer userId) {
        try {
            // 1. 检查用户是否存在
            UserInfo user = userInfoMapper.selectById(userId);
            if (user == null) {
                log.warn("用户不存在，userId: {}", userId);
                return Collections.emptyList();
            }

            // 2. 获取并检查用户知识网络
            List<String> userKeywords = Optional.ofNullable(user.getKnowledgeNetwork())
                    .orElse(Collections.emptyList());

            if (userKeywords.isEmpty()) {
                log.info("用户知识网络为空，userId: {}", userId);
                return Collections.emptyList();
            }

            // 3. 获取所有课程并计算匹配度（自动处理课程无知识网络情况）
            return courseMapper.selectList(null).stream()
                    .map(course -> {
                        double score = calculateMatchPercent(
                                userKeywords,
                                Optional.ofNullable(course.getKnowledgeNetwork())
                                        .orElse(Collections.emptyList())
                        );
                        course.setMatchScore(score);
                        return course;
                    })
                    .filter(course -> course.getMatchScore() > 0) // 可选：过滤掉匹配度为0的课程
                    .sorted((c1, c2) -> Double.compare(c2.getMatchScore(), c1.getMatchScore()))
                    .limit(5)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("课程推荐异常，userId: {}", userId, e);
            return Collections.emptyList(); // 发生任何异常返回空列表
        }
    }

    @Override
    public List<Competition> recommendCompetitionsByKnowledge(Integer userId) {
        try {
            // 1. 检查用户是否存在
            UserInfo user = userInfoMapper.selectById(userId);
            if (user == null) {
                log.warn("用户不存在，userId: {}", userId);
                return Collections.emptyList();
            }

            // 2. 获取并检查用户知识网络
            List<String> userKeywords = Optional.ofNullable(user.getKnowledgeNetwork())
                    .orElse(Collections.emptyList());

            if (userKeywords.isEmpty()) {
                log.info("用户知识网络为空，userId: {}", userId);
                return Collections.emptyList();
            }

            // 3. 获取所有竞赛并计算匹配度
            return competitionMapper.selectList(null).stream()
                    .map(competition -> {
                        double score = calculateMatchPercent(
                                userKeywords,
                                Optional.ofNullable(competition.getKnowledgeNetwork())
                                        .orElse(Collections.emptyList())
                        );
                        competition.setMatchScore(score);
                        return competition;
                    })
                    .filter(competition -> competition.getMatchScore() > 0) // 可选过滤
                    .sorted((c1, c2) -> Double.compare(c2.getMatchScore(), c1.getMatchScore()))
                    .limit(5)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("竞赛推荐异常，userId: {}", userId, e);
            return Collections.emptyList();
        }
    }

    /**
     * 计算匹配百分比（保持不变）
     * 注意：该方法已经自动处理了targetKeywords为null或空的情况
     */
    private double calculateMatchPercent(List<String> userKeywords, List<String> targetKeywords) {
        if (userKeywords.isEmpty() || targetKeywords == null || targetKeywords.isEmpty()) {
            return 0.0;
        }

        Set<String> userSet = new HashSet<>(userKeywords);
        int totalKeywords = userSet.size();

        userSet.retainAll(new HashSet<>(targetKeywords));
        return (userSet.size() * 100.0) / totalKeywords;
    }
}