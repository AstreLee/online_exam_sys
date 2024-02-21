package com.xin.online_exam_sys.service.student.Impl;

import com.xin.online_exam_sys.dao.student.SPaperMapper;
import com.xin.online_exam_sys.pojo.entity.PaperAnswer;
import com.xin.online_exam_sys.pojo.entity.PaperQuestionAnswer;
import com.xin.online_exam_sys.pojo.vo.student.req.SPaperFormReqVO;
import com.xin.online_exam_sys.pojo.vo.student.res.*;
import com.xin.online_exam_sys.service.student.SPaperService;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : AstreLee
 * @date : 2024/2/15 - 10:58
 * @file : SPaperServiceImpl.java
 * @ide : IntelliJ IDEA
 */
@Service
public class SPaperServiceImpl implements SPaperService {
    @Autowired
    private SPaperMapper sPaperMapper;
    // 数据成员titleMap
    private Map<Integer, String> titleMap = new HashMap<>();
    // 代码块初始化
    {
        titleMap.put(1, "单选题");
        titleMap.put(2, "多选题");
        titleMap.put(3, "判断题");
        titleMap.put(4, "填空题");
        titleMap.put(5, "简答题");
    };

    @Override
    public List<SPaperListResVO> getPaperList(Integer paperType) {
        // 获取当前学生用户ID
        Long studentId = JWTContextUtil.getCurrentId();
        // 获取班级ID
        Long classId = sPaperMapper.selectStudentClassId(studentId);
        // 获取任务列表
        List<Long> paperIds = sPaperMapper.selectStudentPapersId(studentId, classId);
        // 获取已经完成的试卷列表
        List<Long> finishedPaperIds = sPaperMapper.selectFinishedPapersId(studentId);
        // 获取未完成的试卷列表
        List<Long> unfinishedPaperIds = new ArrayList<>();
        for (Long paperId : paperIds) {
            if (!finishedPaperIds.contains(paperId)) {
                unfinishedPaperIds.add(paperId);
            }
        }
        if (unfinishedPaperIds.isEmpty()) {
            return null;
        } else {
            return sPaperMapper.selectPaperList(paperType, unfinishedPaperIds);
        }
    }

    @Override
    public SPaperInfoResVO getPaperInfo(Long paperId) {
        return sPaperMapper.selectPaperInfo(paperId);
    }

    @Override
    public List<SPaperTitleItemResVO> getPaperTitleItem(Long paperId) {
        List<SPaperTitleItemResVO> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<SPaperQuestionItemResVO> questionItemResVOs = sPaperMapper.selectQuestionList(paperId, i + 1);
            if (questionItemResVOs.isEmpty()) {
                continue;
            }
            // 只有单选题和多选题需要设置选项前缀
            if (i < 2) {
                for (int j = 0; j < questionItemResVOs.size(); j++) {
                    char ch = 'A';
                    for (int k = 0; k < questionItemResVOs.get(j).getOptions().size(); k++) {
                        questionItemResVOs.get(j).getOptions().get(k).setPrefix(ch++);
                    }
                }
            }
            SPaperTitleItemResVO titleItemResVO = new SPaperTitleItemResVO(i + 1, titleMap.get(i + 1));
            titleItemResVO.setQuestionList(questionItemResVOs);
            res.add(titleItemResVO);
        }
        return res;
    }

    @Override
    public void savePaperAnswer(SPaperFormReqVO reqVO) {
        // 获取当前学生用户ID
        Long stuId = JWTContextUtil.getCurrentId();
        // 保存答卷信息
        PaperAnswer paperAnswer = new PaperAnswer(null, reqVO.getPaperId(), stuId, 0, 0, reqVO.getSubmitTime(), reqVO.getDoTime(), 0);
        sPaperMapper.savePaperAnswer(paperAnswer);
        // 获取答卷ID
        Long paperAnswerId = paperAnswer.getPaId();
        // 保存答题信息
        double sumScore = 0;
        int rightNum = 0;
        for (int i = 0; i < reqVO.getPaperAnswer().size(); i++) {
            if (reqVO.getPaperAnswer().get(i).isEmpty()) {
                continue;
            }
            for (int j = 0; j < reqVO.getPaperAnswer().get(i).size(); j++) {
                // 获取题目Id
                Long questionId = reqVO.getPaperAnswer().get(i).get(j).getQuestionId();
                String userAnswer = reqVO.getPaperAnswer().get(i).get(j).getAnswer();
                // 查询题目正确答案以及题目分值
                String rightAnswer = sPaperMapper.selectQuestionAnswer(questionId);
                double score = sPaperMapper.selectQuestionScore(questionId);
                // 客观题系统自动判分，主观题等待老师手动判分
                if (i <= 2) {
                    // 1. 客观题默认已读
                    // 2. 初始化为错误答案
                    int isRight = 0;
                    // 3. 得分初始化为0
                    double userScore = 0;
                    if (isEqual(userAnswer, rightAnswer)) {
                        rightNum++;
                        sumScore += score;
                        userScore = score;
                        isRight = 1;
                    }
                    PaperQuestionAnswer pqa = new PaperQuestionAnswer(null, paperAnswerId, questionId, userAnswer, 1, isRight, userScore);
                    sPaperMapper.saveQuestionAnswer(pqa);
                } else {
                    PaperQuestionAnswer pqa = new PaperQuestionAnswer(null, paperAnswerId, questionId, userAnswer, 0, 0, 0.0);
                    sPaperMapper.saveQuestionAnswer(pqa);
                }
            }
        }
        // 更新答卷信息
        sPaperMapper.updatePaperAnswer(paperAnswerId, sumScore, rightNum);
    }

    @Override
    public List<SPaperRecordListResVO> getRecordList() {
        // 1. 获取学生ID
        Long stuId = JWTContextUtil.getCurrentId();
        // 2. 获取答卷信息
        return sPaperMapper.selectPaperRecordList(stuId);
    }

    @Override
    public SPaperRecordInfoResVO getRecordInfo(Long paId) {
        return sPaperMapper.selectPaperRecordInfo(paId);
    }

    @Override
    public List<SPaperRecordTitleItemResVO> getRecordTitleItem(Long paId) {
        List<SPaperRecordTitleItemResVO> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<SPaperRecordQuestionItemResVO> recordList = sPaperMapper.selectQuestionRecordList(paId, i + 1);
            if (recordList.isEmpty()) {
                continue;
            }
            // 客观题设置前缀
            if (i < 2) {
                for (int j = 0; j < recordList.size(); j++) {
                    char ch = 'A';
                    for (int k = 0; k < recordList.get(j).getOptions().size(); k++) {
                        recordList.get(j).getOptions().get(k).setPrefix(ch++);
                    }
                }
            }
            SPaperRecordTitleItemResVO titleItemResVO = new SPaperRecordTitleItemResVO(i + 1, titleMap.get(i + 1), null);
            titleItemResVO.setQuestionList(recordList);
            res.add(titleItemResVO);
        }
        return res;
    }

    private boolean isEqual(String str1, String str2) {
        // str1为用户答案，str2为正确答案，保证str2正确答案不为空
        if (str1 == null || str1.length() == 0 || str1.length() != str2.length()) {
            return false;
        }
        int[] frequency1 = new int[10];
        int[] frequency2 = new int[10];
        for (int i = 0; i < str1.length(); i++) {
            frequency1[str1.charAt(i) - '0']++;
            frequency2[str2.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }
        return true;
    }
}
