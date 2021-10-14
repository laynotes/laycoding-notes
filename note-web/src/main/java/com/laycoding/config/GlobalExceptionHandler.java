package com.laycoding.config;

import com.laycoding.common.enums.ErrorCodeEnum;
import com.laycoding.common.exceptions.BaseException;
import com.laycoding.common.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public Result bizExceptionHandler(BaseException e) {
        return Result.defineError(e);
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler( Exception e) {
        return Result.otherError(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
    }
}
