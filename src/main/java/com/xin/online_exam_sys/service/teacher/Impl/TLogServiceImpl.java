package com.xin.online_exam_sys.service.teacher.Impl;


import com.xin.online_exam_sys.dao.teacher.TLogMapper;
import com.xin.online_exam_sys.pojo.entity.SysLog;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TLogListResVO;
import com.xin.online_exam_sys.service.teacher.TLogService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TLogServiceImpl implements TLogService {
    private final TLogMapper tLogMapper;

    public TLogServiceImpl(TLogMapper tLogMapper) {
        this.tLogMapper = tLogMapper;
    }

    @Override
    public void saveLog(SysLog sysLog) {
        tLogMapper.saveLog(sysLog);
    }

    @Override
    public Map<String, Object> getLogList(Integer pageNum, Integer pageSize) {
        List<TLogListResVO> list = tLogMapper.selectLog(JWTContextUtil.getCurrentId());
        List<TLogListResVO> resList = new PaginationUtil<TLogListResVO>().getLimitCount(pageNum, pageSize, list);
        Map<String, Object> res = new HashMap<>();
        if (resList.size() == 0) {
            res.put("data", "");
            res.put("total", 0);
        } else {
            res.put("data", resList);
            res.put("total", list.size());
        }
        return res;
    }
}
