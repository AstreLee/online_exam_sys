package com.xin.online_exam_sys.dao.student;

import com.xin.online_exam_sys.pojo.entity.PaperAnswer;
import com.xin.online_exam_sys.pojo.entity.PaperQuestionAnswer;
import com.xin.online_exam_sys.pojo.vo.student.res.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SPaperMapper {
    // 查找学生所属班级
    Long selectStudentClassId(Long stuId);

    // 获取当前学生用户所属所有试卷Ids(包括个人和班级试卷)
    List<Long> selectStudentPapersId(Long stuId, Long classId);

    // 获取已经完成的试卷列表
    List<Long> selectFinishedPapersId(Long stuId);

    // 获取任务试卷所属班级
    Long selectClassIdByPaperId(Long paperId);

    // 获取试卷列表
    List<SPaperListResVO> selectPaperList(Integer paperType, List<Long> paperIds, Long stuId, Long classId);

    // 获取试卷信息
    SPaperInfoResVO selectPaperInfo(Long paperId);

    // 获取试题
    List<SPaperQuestionItemResVO> selectQuestionList(Long paperId, Integer questionType);

    // 答卷保存
    void savePaperAnswer(PaperAnswer pa);

    // 查询题目答案
    String selectQuestionAnswer(Long questionId);

    // 查询题目分数
    Integer selectQuestionScore(Long questionId);

    // 保存答题信息
    void saveQuestionAnswer(PaperQuestionAnswer pqa);

    // 更新答卷信息
    void updatePaperAnswer(Long paId, Double sumScore, Integer sumRight, Integer paState);


    // 查询答卷记录信息
    List<SPaperRecordListResVO> selectPaperRecordList(Long stuId);

    // 查询答卷信息
    SPaperRecordInfoResVO selectPaperRecordInfo(Long paId);

    // 查询答卷题目
    List<SPaperRecordQuestionItemResVO> selectQuestionRecordList(Long paId, Integer questionType);
}
