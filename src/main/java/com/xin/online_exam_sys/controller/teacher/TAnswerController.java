package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerQueryInfoReqVO;
import com.xin.online_exam_sys.service.teacher.TAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teacher")
public class TAnswerController {
    @Autowired
    private TAnswerService tAnswerService;

    @PostMapping("/answer/list")
    public ResultVO getAnswerList(@RequestBody TAnswerQueryInfoReqVO vo) {
        return ResultVO.success(tAnswerService.getStuIdsByTeacherId(vo));
    }
}
