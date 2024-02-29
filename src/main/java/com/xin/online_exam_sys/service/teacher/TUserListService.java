package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.req.TUserListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TUserUpdateInfoResVO;

import java.util.List;
import java.util.Map;


public interface TUserListService {
    List<TSelectOptionVO> getGradeOptions(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    List<TSelectOptionVO> getClassOptions(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    Map<String, Object> getList(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO);

    TUserUpdateInfoResVO getInfoById(Long userId);

    void updateInfoById(Long userId, TUserUpdateInfoResVO tUserUpdateInfoResVO);
}
