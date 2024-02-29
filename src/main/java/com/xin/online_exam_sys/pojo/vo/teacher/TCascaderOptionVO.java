package com.xin.online_exam_sys.pojo.vo.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCascaderOptionVO {
    private String label;
    private Long value;
    private List<TCascaderOptionVO> children;
}
