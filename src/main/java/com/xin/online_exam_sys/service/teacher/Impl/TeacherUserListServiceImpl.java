package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TeacherUserListMapper;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherQueryInfoVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOption;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserListInfo;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserUpdateInfo;
import com.xin.online_exam_sys.service.teacher.TeacherUserListService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
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
        Long t_id = JWTContextUtil.getCurrentId();
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
        Long t_id = JWTContextUtil.getCurrentId();
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
        Long tId = JWTContextUtil.getCurrentId();
        List<TeacherUserListInfo> totalList = teacherUserListMapper.selectList(userId, grade, classId, tId);
        Map<String, Object> map = new HashMap<>();
        Integer total = totalList.size();
        map.put("total", total);
        List<TeacherUserListInfo> newList = new ArrayList<>();
        int start = (pageNum - 1) * pageSize;
        int end = pageNum * pageSize;
        if (pageNum * pageSize > total) {
            start = total % pageSize == 0 ? (total / pageSize - 1) * pageSize : total / pageSize * pageSize;
            end = start + (total % pageSize == 0 ? pageSize : total % pageSize);
        }
        for (; start < end; ++start) {
            newList.add(totalList.get(start));
        }
        map.put("data", newList);
        return map;
    }

    @Override
    public TeacherUserUpdateInfo getInfoById(Long userId) {
        return teacherUserListMapper.selectInfoById(userId);
    }

    @Override
    public void updateInfoById(Long userId, TeacherUserUpdateInfo teacherUserUpdateInfo) {
        String phone = teacherUserUpdateInfo.getPhone();
        String email = teacherUserUpdateInfo.getEmail();
        teacherUserListMapper.updateInfoById(userId, phone, email);
    }
}
