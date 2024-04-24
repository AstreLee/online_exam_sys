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
 * @date : 2024/4/9 - 16:30
 * @file : Task.java
 * @ide : IntelliJ IDEA
 */
@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("task")
@Alias("task")
public class Task {
    @TableId("task_id")
    private Long taskId;

    @TableField("task_type")
    private Integer taskType;

    @TableField("p_id")
    private Long pId;

    @TableField("stu_id")
    private Long stuId;

    @TableField("class_id")
    private Long classId;

    @TableField("task_created_id")
    private Long taskCreatedId;

    @TableField("task_created_time")
    private String taskCreatedTime;
}
