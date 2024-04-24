package com.xin.online_exam_sys.service.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.TCascaderOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAddTaskFormReqVO;

import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2024/4/9 - 14:14
 * @file : TTaskService.java
 * @ide : IntelliJ IDEA
 */
public interface TTaskService {
    // 获取班级列表
    List<TSelectOptionVO> getClassList();
    // 获取学生列表
    List<TCascaderOptionVO> getStuList();
    // 获取试卷列表
    List<TSelectOptionVO> getPaperList();
    // 获取任务列表
    Map<String, Object> getTaskList(Integer pageNum, Integer pageSize);
    // 提交任务
    void submitTask(Long tId, TAddTaskFormReqVO vo);
}
