package com.xin.online_exam_sys.dao.student;

import com.xin.online_exam_sys.pojo.vo.student.res.SMessListResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SMessMapper {
    // 根据学生ID以及消息类型(个人/班级)获取消息列表
    List<SMessListResVO> selectMessList(List<Long> messIds);

    // 根据ID以及消息类型获取消息列表
    List<Long> selectMessIdList(Long id, Integer messType);

    // 根据学生ID和消息ID查询学生是否已读
    Integer isRead(Long stuId, Long messId);

    // 查询学生所属班级
    Long selectClassId(Long stuId);

    // 确认消息已读
    void insertMessConfirm(Long messId, Long stuId, String confirmTime);
}
