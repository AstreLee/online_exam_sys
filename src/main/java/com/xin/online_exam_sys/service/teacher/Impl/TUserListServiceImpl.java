package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TUserListMapper;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TUserListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TUserListInfoResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TUserUpdateInfoResVO;
import com.xin.online_exam_sys.service.teacher.TUserListService;
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
public class TUserListServiceImpl implements TUserListService {
    @Autowired
    private TUserListMapper tUserListMapper;

    @Override
    public List<TSelectOptionVO> getGradeOptions(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Long userId = teacherUserListQueryInfoReqVO.getUserId();
        Long classId = teacherUserListQueryInfoReqVO.getClassId();
        Long t_id = JWTContextUtil.getCurrentId();
        if (userId != null) {
            classId = null;
        }
        List<Long> gradeLists = tUserListMapper.selectGradeOptions(userId, classId, t_id);
        List<TSelectOptionVO> ans = new ArrayList<>();
        for (Long grade : gradeLists) {
            String label = "20" + grade + "级";
            ans.add(new TSelectOptionVO(label, grade));
        }
        return ans;
    }

    @Override
    public List<TSelectOptionVO> getClassOptions(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Long userId = teacherUserListQueryInfoReqVO.getUserId();
        Integer grade = teacherUserListQueryInfoReqVO.getGrade();
        Long t_id = JWTContextUtil.getCurrentId();
        if (userId != null) {
            grade = null;
        }
        return tUserListMapper.selectClassOptions(userId, grade, t_id);
    }

    @Override
    public Map<String, Object> getList(TUserListQueryInfoReqVO teacherUserListQueryInfoReqVO) {
        Long userId = teacherUserListQueryInfoReqVO.getUserId();
        Integer grade = teacherUserListQueryInfoReqVO.getGrade();
        Long classId = teacherUserListQueryInfoReqVO.getClassId();
        Integer pageNum = teacherUserListQueryInfoReqVO.getPageNum();
        Integer pageSize = teacherUserListQueryInfoReqVO.getPageSize();
        Long tId = JWTContextUtil.getCurrentId();
        List<TUserListInfoResVO> totalList = tUserListMapper.selectList(userId, grade, classId, tId);
        Map<String, Object> map = new HashMap<>();
        Integer total = totalList.size();
        map.put("total", total);
        List<TUserListInfoResVO> newList = new ArrayList<>();
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
    public TUserUpdateInfoResVO getInfoById(Long userId) {
        return tUserListMapper.selectInfoById(userId);
    }

    @Override
    public void updateInfoById(Long userId, TUserUpdateInfoResVO tUserUpdateInfoResVO) {
        String phone = tUserUpdateInfoResVO.getPhone();
        String email = tUserUpdateInfoResVO.getEmail();
        tUserListMapper.updateInfoById(userId, phone, email);
    }
}
