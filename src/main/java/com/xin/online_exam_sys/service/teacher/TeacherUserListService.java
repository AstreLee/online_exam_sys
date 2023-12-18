package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.request.teacher.TeacherUserListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOptionResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserUpdateInfoResVO;

import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/9 - 9:21
 * @file : UserListService.java
 * @ide : IntelliJ IDEA
 */
public interface TeacherUserListService {
    List<TeacherSelectOptionResVO> getGradeOptions(TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    List<TeacherSelectOptionResVO> getClassOptions(TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    Map<String, Object> getList(TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    TeacherUserUpdateInfoResVO getInfoById(Long userId);

    void updateInfoById(Long userId, TeacherUserUpdateInfoResVO teacherUserUpdateInfoResVO);
}
