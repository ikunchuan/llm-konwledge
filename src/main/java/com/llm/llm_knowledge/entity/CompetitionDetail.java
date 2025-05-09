package com.llm.llm_knowledge.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("competition_detail")
public class  CompetitionDetail {

    @TableId(type = IdType.AUTO)
    private Integer competitionId;
    private String competitionName;
private String competitionDescription;
private String competitionOrganizer;
private Date startDate;
private Date endDate;
private String competitionUrl;
private String competitionSchedule;
private Date registrationDeadline;
private String detail;

    //自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    //自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;


}
