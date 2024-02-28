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
@Alias("teacher")
@TableName("teacher")
public class Teacher {
    @TableId("t_id")
    private Long tId;

    @TableField("t_name")
    private String tName;

    @TableField("t_passwd")
    private String tPasswd;

    @TableField("t_gender")
    private Integer tGender;

    @TableField("t_age")
    private Integer tAge;

    @TableField("t_phone")
    private String tPhone;

    @TableField("t_email")
    private String tEmail;

    @TableField("t_state")
    private Integer tState;

    @TableField("t_img_url")
    private String tImgUrl;

    @TableField("t_desc")
    private String tDesc;

    @TableField("college_id")
    private Long collegeId;
}
