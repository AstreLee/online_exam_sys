package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionFormReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TQuestionListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TQuestionFormResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;

import java.util.List;
import java.util.Map;


public interface TQuestionService {
    // 获取所有课程集合
    List<TSelectOptionVO> getCourseOptions();

    // 添加题目和选项
    void saveQuestionAndOptions(TQuestionFormReqVO questionFormVO);

    // 获取试题列表
    Map<String, Object> getQuestionList(TQuestionListQueryInfoReqVO questionListQueryInfoVO);

    // 获取试题
    TQuestionFormResVO getQuestionById(Long questionId);

    // 更新试题
    void updateQuestionById(TQuestionFormReqVO questionFormReqVO);
}
