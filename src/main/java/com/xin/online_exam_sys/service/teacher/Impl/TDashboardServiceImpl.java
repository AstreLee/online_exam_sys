package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TDashboardMapper;
import com.xin.online_exam_sys.service.teacher.TDashboardService;
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
public class TDashboardServiceImpl implements TDashboardService {
    @Autowired
    private TDashboardMapper tDashboardMapper;

    @Override
    public Map<String, Integer> getDashboardInfo() {
        Map<String, Integer> ans = new HashMap<>();
        Long tId = JWTContextUtil.getCurrentId();
        ans.put("paperCount", tDashboardMapper.selectPaperCount(tId));
        ans.put("questionCount", tDashboardMapper.selectQuestionCount(tId));
        ans.put("doPaperCount", tDashboardMapper.selectDoPaperCount(tId));
        ans.put("doQuestionCount", tDashboardMapper.selectDoQuestionCount(tId));
        return ans;
    }
}
