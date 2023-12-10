package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TeacherUserListMapper;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQueryInfoVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOption;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserListInfo;
import com.xin.online_exam_sys.service.teacher.TeacherUserListService;
import com.xin.online_exam_sys.utils.JWTContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/9 - 9:22
 * @file : UserListServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class TeacherUserListServiceImpl implements TeacherUserListService {
    @Autowired
    private TeacherUserListMapper teacherUserListMapper;

    @Override
    public List<TeacherSelectOption> getGradeOptions(TeacherQueryInfoVO teacherQueryInfoVO) {
        Long userId = teacherQueryInfoVO.getUserId();
        Long classId = teacherQueryInfoVO.getClassId();
        Long t_id = JWTContext.getCurrentId();
        if (userId != null) {
            classId = null;
        }
        List<Integer> gradeLists = teacherUserListMapper.selectGradeOptions(userId, classId, t_id);
        List<TeacherSelectOption> ans = new ArrayList<>();
        for (Integer grade : gradeLists) {
            String label = "20" + grade + "级";
            ans.add(new TeacherSelectOption(label, grade));
        }
        return ans;
    }

    @Override
    public List<TeacherSelectOption> getClassOptions(TeacherQueryInfoVO teacherQueryInfoVO) {
        Long userId = teacherQueryInfoVO.getUserId();
        Integer grade = teacherQueryInfoVO.getGrade();
        Long t_id = JWTContext.getCurrentId();
        if (userId != null) {
            grade = null;
        }
        return teacherUserListMapper.selectClassOptions(userId, grade, t_id);
    }

    @Override
    public Map<String, Object> getList(TeacherQueryInfoVO teacherQueryInfoVO) {
        Long userId = teacherQueryInfoVO.getUserId();
        Integer grade = teacherQueryInfoVO.getGrade();
        Long classId = teacherQueryInfoVO.getClassId();
        Integer pageNum = teacherQueryInfoVO.getPageNum();
        Integer pageSize = teacherQueryInfoVO.getPageSize();
        Integer offset = (pageNum - 1) * pageSize;
        Long tId = JWTContext.getCurrentId();
        List<TeacherUserListInfo> totalList = teacherUserListMapper.selectList(userId, grade, classId, tId);
        Map<String, Object> map = new HashMap<>();
        map.put("total", totalList.size());
        List<TeacherUserListInfo> newList = new ArrayList<>();
        for (int i = (pageNum - 1) * pageSize; i < pageNum * pageSize; ++i) {
            newList.add(totalList.get(i));
        }
        map.put("data", newList);
        return map;
    }
}
