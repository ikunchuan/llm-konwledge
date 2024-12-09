package com.llm.llm_knowledge.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("competition_favorite")
public class CompetitionFavorite {

    @TableId(type = IdType.AUTO)
    private Integer competitionFavoriteId;
    private Integer competitionId;
    private Integer userId;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;
}
