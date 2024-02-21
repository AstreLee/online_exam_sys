package com.xin.online_exam_sys.service.teacher.Impl;


import com.xin.online_exam_sys.dao.teacher.TLogMapper;
import com.xin.online_exam_sys.pojo.entity.SysLog;
import com.xin.online_exam_sys.service.teacher.TLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TLogServiceImpl implements TLogService {
    private final TLogMapper tLogMapper;

    @Autowired
    public TLogServiceImpl(TLogMapper tLogMapper) {
        this.tLogMapper = tLogMapper;
    }
    @Override
    public void saveLog(SysLog sysLog) {

    }
}
