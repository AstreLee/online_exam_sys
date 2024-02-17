package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.res.TAnswerListResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TAnswerMapper {
    // 根据当前用户Id查询所有提交答卷的学生id
    List<Long> selectStuIdsByTeacherId(Long tId);

    // 查询学生答卷
    List<TAnswerListResVO> selectRecordListByIds(List<Long> stuIds, Long courseId, Integer state);
}
