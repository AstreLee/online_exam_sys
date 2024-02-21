package com.xin.online_exam_sys.service.teacher;


import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerCheckInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerInfoResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerTitleItemResVO;

import java.util.List;
import java.util.Map;

public interface TAnswerService {
    // 获取答卷列表信息
    Map<String, Object> getStuIdsByTeacherId(TAnswerQueryInfoReqVO vo);

    // 获取答卷信息
    TAnswerInfoResVO getAnswerInfo(Long paId);

    // 获取答卷详细信息
    List<TAnswerTitleItemResVO> getAnswerTitleItem(Long paId);

    // 提交答卷详情
    void submitCheckAnswer(TAnswerCheckInfoReqVO vo);
}
