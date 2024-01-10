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
 * @date : 2024/1/4 - 10:04
 * @file : PaperQuestion.java
 * @ide : IntelliJ IDEA
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("paperQuestion")
@TableName("paper_question")
public class PaperQuestion {
    @TableId("pq_id")
    private Long paperQuestionId;

    @TableField("p_id")
    private Long paperId;

    @TableField("q_id")
    private Long questionId;
}
