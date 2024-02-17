package com.xin.online_exam_sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias(value = "paperAnswer")
@TableName(value = "paper_answer")
public class PaperAnswer {
    @TableId("pa_id")
    private Long paId;

    @TableField("p_id")
    private Long pId;

    @TableField("stu_id")
    private Long stuId;

    @TableField("pa_sum_score")
    private Integer paSumScore;

    @TableField("pa_right_num")
    private Integer paRightNum;

    @TableField("pa_submit_time")
    private String paSubmitTime;

    @TableField("pa_do_time")
    private Integer paDoTime;

    @TableField("pa_state")
    private Integer paState;
}
