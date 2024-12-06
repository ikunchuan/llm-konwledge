package com.llm.llm_knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llm.llm_knowledge.dto.CategoryDTO;
import com.llm.llm_knowledge.entity.Category;
import com.llm.llm_knowledge.vo.CategorySearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    List<CategoryDTO> selectCategoryWithFilters(CategorySearch categorySearch);
}
