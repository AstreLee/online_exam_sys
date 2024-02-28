package com.xin.online_exam_sys.dao.teacher;

import com.xin.online_exam_sys.pojo.entity.SysLog;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TLogListResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TLogMapper {
    void saveLog(SysLog sysLog);

    List<TLogListResVO> selectLog(Long tId);
}
