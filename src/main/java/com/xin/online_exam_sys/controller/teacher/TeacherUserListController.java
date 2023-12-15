package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQueryInfoVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserUpdateInfo;
import com.xin.online_exam_sys.service.teacher.TeacherUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/9 - 10:25
 * @file : UserList.java
 * @ide : IntelliJ IDEA
 */
@RestController
@RequestMapping("/teacher")
public class TeacherUserListController {
    @Autowired
    private TeacherUserListService teacherUserListService;

    @PostMapping("/user/list/gradeOption")
    public ResultVO getGradeOption(@RequestBody TeacherQueryInfoVO teacherQueryInfoVO) {
        Object data = teacherUserListService.getGradeOptions(teacherQueryInfoVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PostMapping("/user/list/classOption")
    public ResultVO getClassOption(@RequestBody TeacherQueryInfoVO teacherQueryInfoVO) {
        Object data = teacherUserListService.getClassOptions(teacherQueryInfoVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PostMapping("/user/list")
    public ResultVO getList(@RequestBody TeacherQueryInfoVO teacherQueryInfoVO) {
        Map<String, Object> data = teacherUserListService.getList(teacherQueryInfoVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @GetMapping("/user/list/userInfo/{id}")
    public ResultVO getUserInfo(@PathVariable("id") Long userId) {
        Object data = teacherUserListService.getInfoById(userId);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PutMapping("/user/list/userInfo/{id}")
    public ResultVO updateUserInfo(@PathVariable("id") Long userId, @RequestBody TeacherUserUpdateInfo teacherUserUpdateInfo) {
        teacherUserListService.updateInfoById(userId, teacherUserUpdateInfo);
        return ResultVO.success(HttpStatusCode.CREATED);
    }
}
