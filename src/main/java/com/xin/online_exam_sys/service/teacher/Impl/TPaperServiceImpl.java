package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TPaperMapper;
import com.xin.online_exam_sys.pojo.entity.Paper;
import com.xin.online_exam_sys.pojo.vo.teacher.TPaperAddFormQuestionItemsVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TPaperAddFormTitleItemsVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TPaperAddFormVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TPaperAddQuestionTableResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TPaperListResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TSelectOptionResVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.*;
import com.xin.online_exam_sys.service.teacher.TPaperService;
import com.xin.online_exam_sys.utils.DateTimeUtil;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TPaperServiceImpl implements TPaperService {
    @Autowired
    private TPaperMapper tPaperMapper;

    @Override
    public List<TSelectOptionResVO> getCourseOptions() {
        Long tId = JWTContextUtil.getCurrentId();
        return tPaperMapper.selectCourseOptions(tId);
    }

    @Override
    public Map<String, Object> getQuestionList(TPaperAddQuestionQueryInfoReqVO reqVO) {
        List<TPaperAddQuestionTableResVO> result = tPaperMapper.selectQuestions(reqVO.getQuestionId(),
                reqVO.getCourseId(), reqVO.getQuestionType());
        Integer pageNum = reqVO.getPageNum();
        Integer pageSize = reqVO.getPageSize();
        List<TPaperAddQuestionTableResVO> newResult = new PaginationUtil<TPaperAddQuestionTableResVO>().getLimitCount(pageNum, pageSize, result);
        if (newResult == null) {
            Map<String, Object> res = new HashMap<>();
            res.put("list", null);
            res.put("total", 0);
            return res;
        }
        for (int i = 0; i < newResult.size(); i++) {
            if (reqVO.getQuestionType() == 1 || reqVO.getQuestionType() == 2) {
                char prefix = 'A';
                for (int j = 0; j < newResult.get(i).getItems().size(); j++) {
                    newResult.get(i).getItems().get(j).setPrefix(prefix++);
                }
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("list", newResult);
        res.put("total", newResult.size());
        return res;
    }

    @Override
    public void savePaper(TPaperAddFormVO reqVO) {
        Long tId = JWTContextUtil.getCurrentId();
        Paper paper = new Paper();
        paper.setPaperName(reqVO.getPaperName());
        paper.setCourseId(reqVO.getCourseId());
        paper.setPaperType(reqVO.getPaperType());
        int objectiveNum = 0;
        int subjectiveNum = 0;
        for (int i = 0; i < reqVO.getTitleItems().size(); i++) {
            if (reqVO.getTitleItems().get(i).getTitleId() == 4 || reqVO.getTitleItems().get(i).getTitleId() == 5) {
                subjectiveNum += reqVO.getTitleItems().get(i).getQuestionItems().size();
            } else {
                objectiveNum += reqVO.getTitleItems().get(i).getQuestionItems().size();
            }
        }
        paper.setPaperObjectiveNum(objectiveNum);
        paper.setPaperSubjectiveNum(subjectiveNum);
        paper.setPaperSumNum(objectiveNum + subjectiveNum);
        paper.setPaperSuggestTime(reqVO.getSuggestTime());
        paper.setPaperStartTime(reqVO.getStartTime());
        paper.setPaperEndTime(reqVO.getEndTime());
        paper.setPaperCreatedTime(DateTimeUtil.getCurrentFormattedDateTime());
        paper.setPaperCreatedUser(tId);

        // 保存试卷
        tPaperMapper.insertPaper(paper);
        // 获取试卷id
        Long paperId = paper.getPaperId();
        // 获取试卷所有题目
        List<Long> questionIds = new ArrayList<>();
        for (TPaperAddFormTitleItemsVO titleItem : reqVO.getTitleItems()) {
            for (TPaperAddFormQuestionItemsVO questionItem : titleItem.getQuestionItems()) {
                questionIds.add(questionItem.getQuestionId());
            }
        }
        // 保存试卷题目
        tPaperMapper.insertPaperQuestionList(paperId, questionIds);
    }

    @Override
    public Map<String, Object> getPaperList(TPaperListQueryInfoReqVO reqVO) {
        List<TPaperListResVO> result = tPaperMapper.selectPaperList(reqVO.getPaperId(), reqVO.getCourseId());
        Integer pageNum = reqVO.getPageNum();
        Integer pageSize = reqVO.getPageSize();
        List<TPaperListResVO> newResult = new PaginationUtil<TPaperListResVO>().getLimitCount(pageNum, pageSize, result);
        if (newResult == null) {
            Map<String, Object> res = new HashMap<>();
            res.put("list", null);
            res.put("total", 0);
            return res;
        }
        Map<String, Object> res = new HashMap<>();
        res.put("list", newResult);
        res.put("total", newResult.size());
        return res;
    }

    @Override
    public TPaperAddFormVO getPaperById(Long id) {
        List<Integer> qTypesList = tPaperMapper.selectQuestionTypeByPaperId(id);
        TPaperAddFormVO res = tPaperMapper.selectPaperDetail(id);
        res.setTitleItems(new ArrayList<>());
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "单选题");
        map.put(2, "多选题");
        map.put(3, "判断题");
        map.put(4, "简答题");
        map.put(5, "填空题");
        for (Integer qType : qTypesList) {
            TPaperAddFormTitleItemsVO titleItem = new TPaperAddFormTitleItemsVO();
            titleItem.setTitleId(qType);
            titleItem.setTitleName(map.get(qType));
            List<Long> questionIds = tPaperMapper.selectQuestionByType(id, qType);
            List<TPaperAddFormQuestionItemsVO> questionItem = tPaperMapper.selectQuestionDetail(questionIds);
            for (int i = 0; i < questionItem.size(); i++) {
                if (questionItem.get(i).getItems().isEmpty() || qType > 2) {
                    continue;
                }
                char prefix = 'A';
                for (int j = 0; j < questionItem.get(i).getItems().size(); j++) {
                    questionItem.get(i).getItems().get(j).setPrefix(prefix++);
                }
            }
            titleItem.setQuestionItems(questionItem);
            res.getTitleItems().add(titleItem);
        }
        return res;
    }
}
