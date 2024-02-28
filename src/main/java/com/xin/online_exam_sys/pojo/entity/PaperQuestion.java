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
