package com.xin.online_exam_sys.service.teacher;


import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerQueryInfoReqVO;

import java.util.Map;

public interface TAnswerService {
    // 获取答卷信息
    Map<String, Object> getStuIdsByTeacherId(TAnswerQueryInfoReqVO vo);
}
