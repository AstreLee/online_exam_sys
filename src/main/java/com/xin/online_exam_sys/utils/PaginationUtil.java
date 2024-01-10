package com.xin.online_exam_sys.utils;

import java.util.*;
/**
 * @author : AstreLee
 * @date : 2023/12/16 - 23:23
 * @file : PaginationUtil.java
 * @ide : IntelliJ IDEA
 */
public class PaginationUtil<T> {
    public List<T> getLimitCount(Integer pageNum, Integer pageSize, List<T> totalList) {
        if (totalList == null || totalList.size() == 0) {
            return null;
        }
        Integer total = totalList.size();
        List<T> newList = new ArrayList<>();
        int start = (pageNum - 1) * pageSize;
        int end = pageNum * pageSize;
        if (pageNum * pageSize > total) {
            start = total % pageSize == 0 ? (total / pageSize - 1) * pageSize : total / pageSize * pageSize;
            end = start + (total % pageSize == 0 ? pageSize : total % pageSize);
        }
        for (; start < end; ++start) {
            newList.add(totalList.get(start));
        }
        return newList;
    }
}
