package com.xin.online_exam_sys.pojo.vo.student.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SPaperRecordListResVO {
    private Long paId;
    private String paperName;
    private String submitTime;
    private Integer doTime;
    private Integer paperType;
    private String course;
    private Integer fullNum;
    private Double fullScore;
    private Integer rightNum;
    private Double sumScore;
    private Integer state;
}
