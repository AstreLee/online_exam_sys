package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TTaskMapper;
import com.xin.online_exam_sys.pojo.entity.Task;
import com.xin.online_exam_sys.pojo.vo.teacher.TCascaderOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAddTaskFormReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TTaskTableResVO;
import com.xin.online_exam_sys.service.teacher.TTaskService;
import com.xin.online_exam_sys.utils.DateTimeUtil;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2024/4/9 - 14:15
 * @file : TTaskServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class TTaskServiceImpl implements TTaskService {
    private final TTaskMapper tTaskMapper;

    public TTaskServiceImpl(TTaskMapper taskMapper) {
        this.tTaskMapper = taskMapper;
    }
    @Override
    public List<TSelectOptionVO> getClassList() {
        return tTaskMapper.selectClassList(JWTContextUtil.getCurrentId());
    }

    @Override
    public List<TCascaderOptionVO> getStuList() {
        Long tId = JWTContextUtil.getCurrentId();
        List<TSelectOptionVO> classList = tTaskMapper.selectClassList(tId);
        List<TCascaderOptionVO> res = new ArrayList<>();
        for (int i = 0; i < classList.size(); i++) {
            TCascaderOptionVO list = new TCascaderOptionVO();
            list.setLabel(classList.get(i).getLabel());
            list.setValue(classList.get(i).getValue());
            List<TCascaderOptionVO> children = tTaskMapper.selectStuList(tId, classList.get(i).getValue());
            list.setChildren(children);
            res.add(list);
        }
        return res;
    }

    @Override
    public List<TSelectOptionVO> getPaperList() {
        return tTaskMapper.selectPaperList(JWTContextUtil.getCurrentId());
    }

    @Override
    public Map<String, Object> getTaskList(Integer pageNum, Integer pageSize) {
        Long tId = JWTContextUtil.getCurrentId();
        List<TTaskTableResVO> res = tTaskMapper.selectTaskList(tId);
        List<TTaskTableResVO> newRes = new PaginationUtil<TTaskTableResVO>().getLimitCount(pageNum, pageSize, res);
        Map<String, Object> data = new HashMap<>();
        data.put("total", res.size());
        data.put("data", newRes);
        return data;
    }

    @Override
    public void submitTask(Long tId, TAddTaskFormReqVO vo) {
        Task task = new Task();
        task.setTaskType(vo.getTaskType());
        task.setPId(vo.getTaskPaperId());
        if (vo.getTaskType() == 0) {
            task.setStuId(vo.getTaskRecvId());
        } else {
            task.setClassId(vo.getTaskRecvId());
        }
        task.setTaskCreatedId(tId);
        task.setTaskCreatedTime(DateTimeUtil.getCurrentFormattedDateTime());
        tTaskMapper.insertTask(task);
    }
}
