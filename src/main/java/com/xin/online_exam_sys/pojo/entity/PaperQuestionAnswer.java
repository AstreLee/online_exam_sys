package com.xin.online_exam_sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias(value = "paperQuestionAnswer")
@TableName(value = "paper_question_answer")
public class PaperQuestionAnswer {
    @TableId("paq_id")
    private Long paqId;

    @TableField("pa_id")
    private Long paId;

    @TableField("q_id")
    private Long qId;

    @TableField("pqa_answer")
    private String pqaAnswer;

    @TableField("pqa_read")
    private Integer pqaRead;

    @TableField("pqa_right")
    private Integer pqaRight;

    @TableField("pqa_score")
    private Double pqaScore;
}
