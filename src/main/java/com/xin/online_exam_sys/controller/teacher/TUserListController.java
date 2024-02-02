package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TUserListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TUserUpdateInfoResVO;
import com.xin.online_exam_sys.service.teacher.TUserListService;
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
public class TUserListController {
    @Autowired
    private TUserListService tUserListService;

    @PostMapping("/user/list/gradeOption")
    public ResultVO getGradeOption(@RequestBody TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Object data = tUserListService.getGradeOptions(teacherUserListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PostMapping("/user/list/classOption")
    public ResultVO getClassOption(@RequestBody TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Object data = tUserListService.getClassOptions(teacherUserListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PostMapping("/user/list")
    public ResultVO getList(@RequestBody TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Map<String, Object> data = tUserListService.getList(teacherUserListQueryInfoReqVO);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @GetMapping("/user/list/userInfo/{id}")
    public ResultVO getUserInfo(@PathVariable("id") Long userId) {
        Object data = tUserListService.getInfoById(userId);
        return ResultVO.success(HttpStatusCode.OK, data);
    }

    @PutMapping("/user/list/userInfo/{id}")
    public ResultVO updateUserInfo(@PathVariable("id") Long userId, @RequestBody TUserUpdateInfoResVO tUserUpdateInfoResVO) {
        tUserListService.updateInfoById(userId, tUserUpdateInfoResVO);
        return ResultVO.success(HttpStatusCode.CREATED);
    }
}
