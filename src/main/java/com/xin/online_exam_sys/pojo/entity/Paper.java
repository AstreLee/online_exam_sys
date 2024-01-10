package com.xin.online_exam_sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

/**
 * @author : AstreLee
 * @date : 2024/1/3 - 22:01
 * @file : Paper.java
 * @ide : IntelliJ IDEA
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("paper")
@TableName("paper")
public class Paper {
    @TableId("p_id")
    private Long paperId;

    @TableField("p_name")
    private String paperName;

    @TableField("course_id")
    private Long courseId;

    @TableField("p_type")
    private Integer paperType;

    @TableField("p_objective_num")
    private Integer paperObjectiveNum;

    @TableField("p_subjective_num")
    private Integer paperSubjectiveNum;

    @TableField("p_sum_num")
    private Integer paperSumNum;

    @TableField("p_suggestTime")
    private Integer paperSuggestTime;

    @TableField("p_start_time")
    private String paperStartTime;

    @TableField("p_end_time")
    private String paperEndTime;

    @TableField("p_created_time")
    private String paperCreatedTime;

    @TableField("p_created_user")
    private Long paperCreatedUser;
}
