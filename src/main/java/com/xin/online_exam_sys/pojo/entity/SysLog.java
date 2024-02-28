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
@Alias("SysLog")
@TableName("sys_log")
public class SysLog {
    @TableId("log_id")
    private Long logId;

    @TableField("log_user_id")
    private Long logUserId;

    @TableField("log_content")
    private String logContent;

    @TableField("log_created_time")
    private String logCreatedTime;
}
