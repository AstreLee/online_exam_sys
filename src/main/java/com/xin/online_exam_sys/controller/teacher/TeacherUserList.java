package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQueryInfoVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOption;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserListInfo;
import com.xin.online_exam_sys.service.teacher.TeacherUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/9 - 10:25
 * @file : UserList.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher")
public class TeacherUserList {
    @Autowired
    private TeacherUserListService teacherUserListService;

    @PostMapping("/user/list/gradeOption")
    public ResultVO getGradeOption(@RequestBody TeacherQueryInfoVO teacherQueryInfoVO) {
        Object data = teacherUserListService.getGradeOptions(teacherQueryInfoVO);
        return new ResultVO(HttpStatusCode.OK.getCode(),
                HttpStatusCode.OK.getEnMsg(),
                data);
    }

    @PostMapping("/user/list/classOption")
    public ResultVO getClassOption(@RequestBody TeacherQueryInfoVO teacherQueryInfoVO) {
        Object data = teacherUserListService.getClassOptions(teacherQueryInfoVO);
        return new ResultVO(HttpStatusCode.OK.getCode(),
                HttpStatusCode.OK.getEnMsg(),
                data);
    }

    @PostMapping("/user/list")
    public ResultVO getList(@RequestBody TeacherQueryInfoVO teacherQueryInfoVO) {
        Map<String, Object> data = teacherUserListService.getList(teacherQueryInfoVO);
        return new ResultVO(HttpStatusCode.OK.getCode(),
                HttpStatusCode.OK.getEnMsg(),
                data);
    }
}
