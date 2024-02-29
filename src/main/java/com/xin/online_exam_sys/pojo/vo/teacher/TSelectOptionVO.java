package com.xin.online_exam_sys.pojo.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TSelectOptionVO {
    private String label;   // 标签名
    private Long value;  // 标签值
}
