package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.entity.AnswerRecord;
import com.llm.llm_knowledge.vo.AnswerRecordVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRecordMapper extends BaseMapper<AnswerRecord> {
    List<AnswerRecordVO> getAnswerDetailsByUserId(@Param("userId") Integer userId);

/*
 * 在 MyBatis 中，当你在 Mapper 接口方法中使用多个参数时，
 * 这些参数会被 MyBatis 自动映射到 SQL 查询中。
 * 然而，默认情况下，MyBatis 会将方法的参数命名为 arg0, arg1 等。
 * 如果你希望在 SQL 映射文件中引用这些参数，必须明确指定每个参数的名称。
 *  注解 @Param 就是用于指定参数名称的。
 * 在 XML 配置中，#{questionTitle}、#{questionText}、#{minScore} 和 #{maxScore}
 * 就是引用了 @Param 注解中指定的名称。
*/
    List<AnswerRecordVO> searchAnswerDetailsWithFilters(@Param("questionTitle") String questionTitle,
                                                    @Param("questionText") String questionText,
                                                    @Param("minScore") Integer minScore,
                                                    @Param("maxScore") Integer maxScore);
}
