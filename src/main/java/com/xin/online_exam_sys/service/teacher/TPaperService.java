package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.request.teacher.TPaperAddQuestionQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.teacher.TSelectOptionResVO;

import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2024/1/2 - 10:22
 * @file : TeacherPaperService.java
 * @ide : IntelliJ IDEA
 */
public interface TPaperService {
    List<TSelectOptionResVO> getCourseOptions();

    Map<String, Object> getQuestionList(TPaperAddQuestionQueryInfoReqVO reqVO);
}
