package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.req.TUserListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TSelectOptionResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TUserUpdateInfoResVO;

import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/9 - 9:21
 * @file : UserListService.java
 * @ide : IntelliJ IDEA
 */
public interface TUserListService {
    List<TSelectOptionResVO> getGradeOptions(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    List<TSelectOptionResVO> getClassOptions(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    Map<String, Object> getList(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    TUserUpdateInfoResVO getInfoById(Long userId);

    void updateInfoById(Long userId, TUserUpdateInfoResVO tUserUpdateInfoResVO);
}
