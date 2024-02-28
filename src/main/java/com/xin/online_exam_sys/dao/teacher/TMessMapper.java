package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.vo.teacher.res.TMessListResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TMessMapper {
    List<TMessListResVO> selectMessList(Long tId);
}
