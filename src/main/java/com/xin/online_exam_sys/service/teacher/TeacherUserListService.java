package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.request.teacher.TeacherQueryInfoVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOption;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserListInfo;

import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/9 - 9:21
 * @file : UserListService.java
 * @ide : IntelliJ IDEA
 */
public interface TeacherUserListService {
    List<TeacherSelectOption> getGradeOptions(TeacherQueryInfoVO teacherQueryInfoVO);

    List<TeacherSelectOption> getClassOptions(TeacherQueryInfoVO teacherQueryInfoVO);

    Map<String, Object> getList(TeacherQueryInfoVO teacherQueryInfoVO);
}
