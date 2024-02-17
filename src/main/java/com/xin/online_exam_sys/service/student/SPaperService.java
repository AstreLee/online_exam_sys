package com.xin.online_exam_sys.service.student;

import com.xin.online_exam_sys.pojo.vo.student.req.SPaperFormReqVO;
import com.xin.online_exam_sys.pojo.vo.student.res.*;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2024/2/15 - 10:57
 * @file : SPaperService.java
 * @ide : IntelliJ IDEA
 */
public interface SPaperService {
    // 获取试卷列表
    List<SPaperListResVO> getPaperList(Integer paperType);

    // 获取试卷信息
    SPaperInfoResVO getPaperInfo(Long paperId);

    // 试题详情
    List<SPaperTitleItemResVO> getPaperTitleItem(Long paperId);

    // 试卷提交
    void savePaperAnswer(SPaperFormReqVO reqVO);

    // 答卷记录信息获取
    List<SPaperRecordListResVO> getRecordList();

    // 查询答卷信息
    SPaperRecordInfoResVO getRecordInfo(Long paId);

    // 查询答卷详细信息
    List<SPaperRecordTitleItemResVO> getRecordTitleItem(Long paId);
}
