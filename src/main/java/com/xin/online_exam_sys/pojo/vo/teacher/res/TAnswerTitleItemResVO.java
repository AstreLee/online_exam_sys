package com.xin.online_exam_sys.pojo.vo.teacher.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAnswerTitleItemResVO {
    private Integer questionType;
    private String titleName;
    private List<TAnswerQuestionItemResVO> questionList;
}
