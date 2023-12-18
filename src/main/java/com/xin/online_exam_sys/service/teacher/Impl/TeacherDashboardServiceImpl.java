package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TeacherDashboardMapper;
import com.xin.online_exam_sys.service.teacher.TeacherDashboardService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2023/12/17 - 16:53
 * @file : TeacherDashboardServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class TeacherDashboardServiceImpl implements TeacherDashboardService {
    @Autowired
    private TeacherDashboardMapper teacherDashboardMapper;

    @Override
    public Map<String, Integer> getDashboardInfo() {
        Map<String, Integer> ans = new HashMap<>();
        Long tId = JWTContextUtil.getCurrentId();
        ans.put("paperCount", teacherDashboardMapper.selectPaperCount(tId));
        ans.put("questionCount", teacherDashboardMapper.selectQuestionCount(tId));
        ans.put("doPaperCount", teacherDashboardMapper.selectDoPaperCount(tId));
        ans.put("doQuestionCount", teacherDashboardMapper.selectDoQuestionCount(tId));
        return ans;
    }
}
