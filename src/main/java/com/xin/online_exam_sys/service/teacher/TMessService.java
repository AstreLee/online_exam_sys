package com.xin.online_exam_sys.service.teacher;


import com.xin.online_exam_sys.pojo.vo.teacher.TCascaderOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TMessAddFormReqVO;

import java.util.List;
import java.util.Map;

public interface TMessService {
    Map<String, Object> getMessageList(Integer pageNum, Integer pageSize);

    List<TSelectOptionVO> getClassList();

    List<TCascaderOptionVO> getStuList();

    void saveMessage(TMessAddFormReqVO vo);
}
