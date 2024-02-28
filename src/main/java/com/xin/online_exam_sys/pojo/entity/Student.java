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
@Alias("student")
@TableName("student")
public class Student {
    @TableId("stu_id")
    private Long stuId;

    @TableField("stu_name")
    private String stuName;

    @TableField("stu_passwd")
    private String stuPasswd;

    @TableField("stu_gender")
    private Integer stuGender;

    @TableField("stu_age")
    private Integer stuAge;

    @TableField("stu_phone")
    private String stuPhone;

    @TableField("stu_email")
    private String stuEmail;

    @TableField("stu_state")
    private Integer stuState;

    @TableField("stu_img_url")
    private String stuImgUrl;

    @TableField("stu_desc")
    private String stuDesc;

    @TableField("class_id")
    private Long classId;
}
