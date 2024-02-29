package com.xin.online_exam_sys.exception;

import com.xin.online_exam_sys.pojo.vo.ResultVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignatureException extends Exception {
    private int errCode;
    private String errMsg;

    @ExceptionHandler
    public ResultVO authorizationException(SignatureException e){
        return new ResultVO(e.getErrCode(), e.getErrMsg());
    }
}

