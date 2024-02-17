package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperRecordInfoResVO {
    private String paperName;
    private Double sumScore;
    private Double fullScore;
    private Integer doTime;
    private Integer totalNum;
}
