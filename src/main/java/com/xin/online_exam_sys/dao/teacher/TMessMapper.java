package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.Message;
import com.xin.online_exam_sys.pojo.vo.teacher.TCascaderOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TMessListResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TMessMapper {
    List<TMessListResVO> selectMessList(Long tId);

    List<TSelectOptionVO> selectClassList(Long tId);

    List<TCascaderOptionVO> selectStuList(Long tId, Long classId);

    void insertMess(Message message);
}
