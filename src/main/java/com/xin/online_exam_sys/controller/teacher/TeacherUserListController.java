package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherUserListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.ResultVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserUpdateInfoResVO;
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
    public ResultVO getGradeOption(@RequestBody TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Object data = teacherUserListService.getGradeOptions(teacherUserListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PostMapping("/user/list/classOption")
    public ResultVO getClassOption(@RequestBody TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Object data = teacherUserListService.getClassOptions(teacherUserListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PostMapping("/user/list")
    public ResultVO getList(@RequestBody TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Map<String, Object> data = teacherUserListService.getList(teacherUserListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @GetMapping("/user/list/userInfo/{id}")
    public ResultVO getUserInfo(@PathVariable("id") Long userId) {
        Object data = teacherUserListService.getInfoById(userId);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PutMapping("/user/list/userInfo/{id}")
    public ResultVO updateUserInfo(@PathVariable("id") Long userId, @RequestBody TeacherUserUpdateInfoResVO teacherUserUpdateInfoResVO) {
        teacherUserListService.updateInfoById(userId, teacherUserUpdateInfoResVO);
        return ResultVO.success(HttpStatusCode.CREATED);
    }
}
