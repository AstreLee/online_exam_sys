package com.xin.online_exam_sys.service.student.Impl;

import com.xin.online_exam_sys.dao.student.SMessMapper;
import com.xin.online_exam_sys.pojo.vo.student.res.SMessListResVO;
import com.xin.online_exam_sys.service.student.SMessService;
import com.xin.online_exam_sys.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SMessServiceImpl implements SMessService {
    private final SMessMapper sMessMapper;
    public SMessServiceImpl(SMessMapper sMessMapper) {
        this.sMessMapper = sMessMapper;
    }

    @Override
    public List<SMessListResVO> getMessList(Long stuId, Integer messType) {
        List<SMessListResVO> resList = new ArrayList<>();
        List<Long> messIdList;
        if (messType == 0) {
            // 1. 查询所有消息ID列表
            messIdList = sMessMapper.selectMessIdList(stuId, 0);
        } else {
            // 1. 查询学生所属班级
            Long classId = sMessMapper.selectClassId(stuId);
            // 2. 查询所有消息ID列表
            messIdList = sMessMapper.selectMessIdList(classId, 1);
        }
        // 将已读和未读取的消息分开
        List<Long> readList = new ArrayList<>();
        List<Long> notReadList = new ArrayList<>();
        for (Long messId : messIdList) {
            if (sMessMapper.isRead(stuId, messId) == 1) {
                readList.add(messId);
            } else {
                notReadList.add(messId);
            }
        }
        // 3. 添加未读消息列表
        if (notReadList.size() > 0) {
            List<SMessListResVO> list = sMessMapper.selectMessList(notReadList);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setMessStatus(0);
            }
            resList.addAll(list);
        }
        // 4. 添加已读消息列表
        if (readList.size() > 0) {
            List<SMessListResVO> list = sMessMapper.selectMessList(readList);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setMessStatus(1);
            }
            resList.addAll(list);
        }
        // 返回结果
        return resList;
    }

    @Override
    public void saveMessConfirm(Long stuId, Long messId) {
        // 获取当前时间
        String confirmTime = DateTimeUtil.getCurrentFormattedDateTime();
        // 保存确认消息
        sMessMapper.insertMessConfirm(messId, stuId, confirmTime);
    }
}
