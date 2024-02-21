package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerCheckInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerQueryInfoReqVO;
import com.xin.online_exam_sys.service.teacher.TAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher")
public class TAnswerController {
    @Autowired
    private TAnswerService tAnswerService;

    @PostMapping("/answer/list")
    public ResultVO getAnswerList(@RequestBody TAnswerQueryInfoReqVO vo) {
        return ResultVO.success(tAnswerService.getStuIdsByTeacherId(vo));
    }

    @GetMapping("/answer/info")
    public ResultVO getAnswerInfo(@RequestParam Long paId) {
        return ResultVO.success(tAnswerService.getAnswerInfo(paId));
    }

    @GetMapping("/answer/question")
    public ResultVO getAnswerQuestion(@RequestParam Long paId) {
        return ResultVO.success(tAnswerService.getAnswerTitleItem(paId));
    }

    @PostMapping("/answer/submit")
    public ResultVO submitAnswer(@RequestBody TAnswerCheckInfoReqVO vo) {
        tAnswerService.submitCheckAnswer(vo);
        return ResultVO.success();
    }
}
