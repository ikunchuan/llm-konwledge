package com.llm.llm_knowledge.service.impl;

import com.llm.llm_knowledge.entity.CompetitionFavorite;
import com.llm.llm_knowledge.entity.Course;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.mapper.CompetitionFavoriteMapper;
import com.llm.llm_knowledge.mapper.CompetitionMapper;
import com.llm.llm_knowledge.mapper.CourseMapper;
import com.llm.llm_knowledge.mapper.UserInfoMapper;
import com.llm.llm_knowledge.service.RecommendService;
import com.llm.llm_knowledge.util.UserBasedRecommender;
import com.llm.llm_knowledge.util.UserCompetitionMatrixBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private CompetitionFavoriteMapper favoriteMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CourseMapper courseMapper;

    // 根据用户ID推荐课程（标签）
    @Override
    public List<Course> recommendCoursesByUserId(Long userId) {
        UserInfo user = userInfoMapper.selectById(userId);
        List<String> userKnowledge = user.getKnowledgeNetwork();
        List<Course> allCourses = courseMapper.selectList(null);

        return allCourses.stream()
                .filter(course -> {
                    List<String> courseKnowledge = course.getKnowledgeNetwork();
                    if (courseKnowledge == null || courseKnowledge.isEmpty()) {
                        return false;
                    }
                    // 判断两个List是否有交集
                    return courseKnowledge.stream().anyMatch(userKnowledge::contains);
                })
                .collect(Collectors.toList());
    }

    public List<Integer> recommendForUser(int userId) {
        List<CompetitionFavorite> favorites = favoriteMapper.getAllFavorites();

        UserCompetitionMatrixBuilder matrixBuilder = new UserCompetitionMatrixBuilder();
        Map<Integer, Set<Integer>> matrix = matrixBuilder.build(favorites);

        UserBasedRecommender recommender = new UserBasedRecommender(matrix);
        return recommender.recommend(userId, 5); // top 5
    }
}
