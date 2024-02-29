package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.TPaperAddFormVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TPaperAddQuestionQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TPaperListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;

import java.util.List;
import java.util.Map;


public interface TPaperService {
    List<TSelectOptionVO> getCourseOptions();

    Map<String, Object> getQuestionList(TPaperAddQuestionQueryInfoReqVO reqVO);

    void savePaper(TPaperAddFormVO reqVO);

    Map<String, Object> getPaperList(TPaperListQueryInfoReqVO reqVO);

    TPaperAddFormVO getPaperById(Long id);
}
