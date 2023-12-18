package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TeacherUserListMapper;
import com.xin.online_exam_sys.pojo.request.teacher.TeacherUserListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherSelectOptionResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserListInfoResVO;
import com.xin.online_exam_sys.pojo.response.teacher.TeacherUserUpdateInfoResVO;
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
    public List<TeacherSelectOptionResVO> getGradeOptions(TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Long userId = teacherUserListQueryInfoReqVO.getUserId();
        Long classId = teacherUserListQueryInfoReqVO.getClassId();
        Long t_id = JWTContextUtil.getCurrentId();
        if (userId != null) {
            classId = null;
        }
        List<Integer> gradeLists = teacherUserListMapper.selectGradeOptions(userId, classId, t_id);
        List<TeacherSelectOptionResVO> ans = new ArrayList<>();
        for (Integer grade : gradeLists) {
            String label = "20" + grade + "级";
            ans.add(new TeacherSelectOptionResVO(label, grade));
        }
        return ans;
    }

    @Override
    public List<TeacherSelectOptionResVO> getClassOptions(TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Long userId = teacherUserListQueryInfoReqVO.getUserId();
        Integer grade = teacherUserListQueryInfoReqVO.getGrade();
        Long t_id = JWTContextUtil.getCurrentId();
        if (userId != null) {
            grade = null;
        }
        return teacherUserListMapper.selectClassOptions(userId, grade, t_id);
    }

    @Override
    public Map<String, Object> getList(TeacherUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Long userId = teacherUserListQueryInfoReqVO.getUserId();
        Integer grade = teacherUserListQueryInfoReqVO.getGrade();
        Long classId = teacherUserListQueryInfoReqVO.getClassId();
        Integer pageNum = teacherUserListQueryInfoReqVO.getPageNum();
        Integer pageSize = teacherUserListQueryInfoReqVO.getPageSize();
        Long tId = JWTContextUtil.getCurrentId();
        List<TeacherUserListInfoResVO> totalList = teacherUserListMapper.selectList(userId, grade, classId, tId);
        Map<String, Object> map = new HashMap<>();
        Integer total = totalList.size();
        map.put("total", total);
        List<TeacherUserListInfoResVO> newList = new ArrayList<>();
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
    public TeacherUserUpdateInfoResVO getInfoById(Long userId) {
        return teacherUserListMapper.selectInfoById(userId);
    }

    @Override
    public void updateInfoById(Long userId, TeacherUserUpdateInfoResVO teacherUserUpdateInfoResVO) {
        String phone = teacherUserUpdateInfoResVO.getPhone();
        String email = teacherUserUpdateInfoResVO.getEmail();
        teacherUserListMapper.updateInfoById(userId, phone, email);
    }
}
