package com.xin.online_exam_sys.controller.teacher;

import com.xin.online_exam_sys.enums.HttpStatusCode;
import com.xin.online_exam_sys.pojo.vo.teacher.TPaperAddFormVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TPaperAddQuestionQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TPaperListQueryInfoReqVO;
import com.xin.online_exam_sys.pojo.vo.ResultVO;
import com.xin.online_exam_sys.service.teacher.TPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher/paper")
public class TPaperController {
    @Autowired
    private TPaperService tPaperService;

    @GetMapping("/courseOptions")
    public ResultVO getCourseOptions() {
        return ResultVO.success(HttpStatusCode.OK, tPaperService.getCourseOptions());
    }

    @PostMapping("/questionList")
    public ResultVO getQuestionList(@RequestBody TPaperAddQuestionQueryInfoReqVO reqVO) {
        System.out.println(reqVO);
        return ResultVO.success(HttpStatusCode.OK, tPaperService.getQuestionList(reqVO));
    }

    @PostMapping("")
    public ResultVO addPaper(@RequestBody TPaperAddFormVO reqVO) {
        tPaperService.savePaper(reqVO);
        return ResultVO.success();
    }

    @PostMapping("/list")
    public ResultVO getPaperList(@RequestBody TPaperListQueryInfoReqVO reqVO) {
        return ResultVO.success(HttpStatusCode.OK, tPaperService.getPaperList(reqVO));
    }

    @GetMapping("/{id}")
    public ResultVO getPaperById(@PathVariable("id") Long id) {
        return ResultVO.success(HttpStatusCode.OK, tPaperService.getPaperById(id));
    }
}
