package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerInfoResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerListResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerQuestionItemResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TAnswerMapper {
    // 根据当前用户Id查询所有提交答卷的学生id
    List<Long> selectStuIdsByTeacherId(Long tId);

    // 查询学生答卷
    List<TAnswerListResVO> selectRecordListByIds(List<Long> stuIds, Long courseId, Integer state);

    // 查询答卷信息
    TAnswerInfoResVO selectAnswerInfo(Long paId);

    // 获取答卷详细信息
    List<TAnswerQuestionItemResVO> selectAnswerQuestionItem(Long paId, Integer questionType);

    // 查询试题是否正确
    Integer selectIsRight(Long qId, Double score);

    // 更新答卷题目信息
    void updateAnswerQuestion(Long paId, Long qId, Integer isRight, Double score);

    // 查询是否所有题目都已经批阅完成
    Integer selectIsAllRead(Long paId);

    // 更新答卷状态
    void updateAnswerRecord(Long paId, Integer addRightNum, Double addScore, Integer paState);
}
