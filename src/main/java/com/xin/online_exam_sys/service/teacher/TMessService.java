package com.xin.online_exam_sys.service.teacher;


import java.util.Map;

public interface TMessService {
    Map<String, Object> getMessageList(Integer pageNum, Integer pageSize);
}
