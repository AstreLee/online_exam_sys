package com.xin.online_exam_sys.controller.student;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.pojo.vo.student.req.SPaperFormReqVO;
import com.xin.online_exam_sys.service.student.SPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class SPaperController {
    private final SPaperService sPaperService;

    @Autowired
    private SPaperController(SPaperService sPaperService) {
        this.sPaperService = sPaperService;
    }

    // 获取试卷列表
    @GetMapping("/exam/list")
    public ResultVO getPaperList(@RequestParam Integer type) {
        return ResultVO.success(sPaperService.getPaperList(type));
    }

    // 获取试卷信息
    @GetMapping("/exam/info")
    public ResultVO getPaperInfo(@RequestParam Long paperId) {
        return ResultVO.success(sPaperService.getPaperInfo(paperId));
    }

    // 获取试题详情
    @GetMapping("/exam/question")
    public ResultVO getQuestion(@RequestParam Long paperId) {
        return ResultVO.success(sPaperService.getPaperTitleItem(paperId));
    }

    // 试卷提交
    @PostMapping("/exam/submit")
    public ResultVO submitPaper(@RequestBody SPaperFormReqVO formReqVO) {
        sPaperService.savePaperAnswer(formReqVO);
        return ResultVO.success();
    }

    // 答卷列表获取
    @GetMapping("/exam/record/list")
    public ResultVO getRecordList() {
        return ResultVO.success(sPaperService.getRecordList());
    }

    // 答卷信息获取
    @GetMapping("/exam/record/info")
    public ResultVO getRecordInfo(@RequestParam Long paId) {
        return ResultVO.success(sPaperService.getRecordInfo(paId));
    }

    // 答卷详情获取
    @GetMapping("/exam/record/question")
    public ResultVO getRecordQuestion(@RequestParam Long paId) {
        return ResultVO.success(sPaperService.getRecordTitleItem(paId));
    }
}
