package com.xin.online_exam_sys.service.teacher.Impl;

import com.xin.online_exam_sys.dao.teacher.TMessMapper;
import com.xin.online_exam_sys.pojo.entity.Message;
import com.xin.online_exam_sys.pojo.vo.teacher.TCascaderOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.TSelectOptionVO;
import com.xin.online_exam_sys.pojo.vo.teacher.req.TMessAddFormReqVO;
import com.xin.online_exam_sys.pojo.vo.teacher.res.TMessListResVO;
import com.xin.online_exam_sys.service.teacher.TMessService;
import com.xin.online_exam_sys.utils.DateTimeUtil;
import com.xin.online_exam_sys.utils.JWTContextUtil;
import com.xin.online_exam_sys.utils.PaginationUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TMessServiceImpl implements TMessService {
    private final TMessMapper tMessMapper;

    public TMessServiceImpl(TMessMapper tMessMapper) {
        this.tMessMapper = tMessMapper;
    }

    @Override
    public Map<String, Object> getMessageList(Integer pageNum, Integer pageSize) {
        List<TMessListResVO> result = tMessMapper.selectMessList(JWTContextUtil.getCurrentId());
        List<TMessListResVO> res = new PaginationUtil<TMessListResVO>().getLimitCount(pageNum, pageSize, result);
        HashMap<String, Object> map = new HashMap<>();
        if (res == null) {
            map.put("list", null);
            map.put("total", 0);
        } else {
            map.put("list", res);
            map.put("total", res.size());
        }
        return map;
    }

    @Override
    public List<TSelectOptionVO> getClassList() {
        return tMessMapper.selectClassList(JWTContextUtil.getCurrentId());
    }

    @Override
    public List<TCascaderOptionVO> getStuList() {
        Long tId = JWTContextUtil.getCurrentId();
        List<TSelectOptionVO> classList = tMessMapper.selectClassList(tId);
        List<TCascaderOptionVO> res = new ArrayList<>();
        for (int i = 0; i < classList.size(); i++) {
            TCascaderOptionVO list = new TCascaderOptionVO();
            list.setLabel(classList.get(i).getLabel());
            list.setValue(classList.get(i).getValue());
            List<TCascaderOptionVO> children = tMessMapper.selectStuList(tId, classList.get(i).getValue());
            list.setChildren(children);
            res.add(list);
        }
        return res;
    }

    @Override
    public void saveMessage(TMessAddFormReqVO vo) {
        Long tId = JWTContextUtil.getCurrentId();
        Integer messageType = vo.getMessageType();
        Long recvId = vo.getMessageRecvId();
        String time = DateTimeUtil.getCurrentFormattedDateTime();
        String messTitle = vo.getMessageTitle();
        String messContent = vo.getMessageContent();
        Message message = new Message();
        message.setMessSendId(tId);
        message.setMessRecvType(messageType);
        message.setMessSendTime(time);
        message.setMessTitle(messTitle);
        message.setMessContent(messContent);
        message.setMessRecvId(recvId);
        tMessMapper.insertMess(message);
    }
}
