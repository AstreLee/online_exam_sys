package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerCheckInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TAnswerQueryInfoReqVO;
import com.xin.online_exam_sys.service.teacher.TAnswerService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher/answer")
public class TAnswerController {
    private final TAnswerService tAnswerService;

    public TAnswerController(TAnswerService tAnswerService) {
        this.tAnswerService = tAnswerService;
    }

    @PostMapping("/list")
    public ResultVO getAnswerList(@RequestBody TAnswerQueryInfoReqVO vo) {
        return ResultVO.success(tAnswerService.getStuIdsByTeacherId(vo));
    }

    @GetMapping("/info")
    public ResultVO getAnswerInfo(@RequestParam Long paId) {
        return ResultVO.success(tAnswerService.getAnswerInfo(paId));
    }

    @GetMapping("/question")
    public ResultVO getAnswerQuestion(@RequestParam Long paId) {
        return ResultVO.success(tAnswerService.getAnswerTitleItem(paId));
    }

    @PostMapping("/submit")
    public ResultVO submitAnswer(@RequestBody TAnswerCheckInfoReqVO vo) {
        tAnswerService.submitCheckAnswer(vo);
        return ResultVO.success();
    }
}
