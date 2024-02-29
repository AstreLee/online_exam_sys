package com.xin.online_exam_sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("mess")
@Alias("mess")
public class Message {
    @TableField("mess_id")
    private Long messId;

    @TableField("mess_send_id")
    private Long messSendId;

    @TableField("mess_recv_type")
    private Integer messRecvType;

    @TableField("mess_recv_id")
    private Long messRecvId;

    @TableField("mess_send_time")
    private String messSendTime;

    @TableField("mess_title")
    private String messTitle;

    @TableField("mess_content")
    private String messContent;
}
