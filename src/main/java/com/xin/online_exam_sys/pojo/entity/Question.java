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
 * @date : 2023/12/14 - 22:20
 * @file : Question.java
 * @ide : IntelliJ IDEA
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("question")
@TableName("question")
public class Question {
    @TableId("q_id")
    private Long qId;

    @TableField("q_type")
    private Integer qType;

    @TableField("q_content")
    private String qContent;

    @TableField("q_answer")
    private String qAnswer;

    @TableField("q_explanation")
    private String qExplanation;

    @TableField("q_score")
    private Integer qScore;

    @TableField("q_difficulty")
    private Integer qDifficulty;

    @TableField("q_created_time")
    private String qCreatedTime;

    @TableField("course_id")
    private Long courseId;
}
