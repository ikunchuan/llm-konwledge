package com.llm.llm_knowledge.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommunityScoreDTO {
    
    private Integer userId;
    private Integer communityId;
    private Integer score;
    private String userName;
    
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
    
}
