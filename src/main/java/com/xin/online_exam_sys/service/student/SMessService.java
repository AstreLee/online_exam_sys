package com.xin.online_exam_sys.service.student;

import com.xin.online_exam_sys.pojo.vo.student.res.SMessListResVO;

import java.util.List;

public interface SMessService {
    // 获取消息列表
    List<SMessListResVO> getMessList(Long stuId, Integer messType);

    // 确认消息已读
    void saveMessConfirm(Long stuId, Long messId);
}
