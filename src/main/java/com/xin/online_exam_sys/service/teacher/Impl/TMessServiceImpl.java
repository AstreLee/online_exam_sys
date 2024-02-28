package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TMessMapper;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TMessListResVO;
import com.xin.online_exam_sys.service.teacher.TMessService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TMessServiceImpl implements TMessService {
    private final TMessMapper tMessMapper;

    public TMessServiceImpl(TMessMapper tMessMapper) {
        this.tMessMapper = tMessMapper;
    }

    @Override
    public Map<String, Object> getMessageList(Integer pageNum, Integer pageSize) {
        List<TMessListResVO> result = tMessMapper.selectMessList(JWTContextUtil.getCurrentId());
        List<TMessListResVO> res = new PaginationUtil<TMessListResVO>().getLimitCount(pageNum, pageSize, result);
        HashMap<String, Object> map = new HashMap<>();
        if (res == null) {
            map.put("list", null);
            map.put("total", 0);
        } else {
            map.put("list", res);
            map.put("total", res.size());
        }
        return map;
    }
}
