package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Task;
import com.xin.online_exam_sys.pojo.vo.teacher.TCascaderOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TTaskTableResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : AstreLee
 * @date : 2024/4/9 - 14:14
 * @file : TTaskMapper.java
 * @ide : IntelliJ IDEA
 */
@Mapper
public interface TTaskMapper {
    List<TSelectOptionVO> selectClassList(Long tId);

    List<TCascaderOptionVO> selectStuList(Long tId, Long classId);

    List<TSelectOptionVO> selectPaperList(Long tId);

    List<TTaskTableResVO> selectTaskList(Long tId);

    void insertTask(Task task);
}
