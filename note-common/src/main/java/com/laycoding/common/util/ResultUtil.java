package com.laycoding.common.util;

import com.laycoding.common.enums.ErrorCodeEnum;
import com.laycoding.common.exceptions.BaseException;
import lombok.Data;

@Data
public class ResultUtil<T> {
    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private T data;

    public ResultUtil() {

    }

    //自定义返回结果的构造方法
    public ResultUtil(Boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultUtil<T> success(T data) {

        ResultUtil<T> result = new ResultUtil<T>();
        result.setSuccess(true);
        result.setCode(0);
        result.setMsg(null);
        result.setData(data);
        return result;
    }

    //自定义异常返回的结果
    public static ResultUtil defineError(BaseException baseException) {
        ResultUtil result = new ResultUtil();
        result.setSuccess(false);
        result.setCode(baseException.getErrorCode());
        result.setMsg(baseException.getErrorMsg());
        result.setData(null);
        return result;
    }

    //其他异常处理方法返回的结果
    public static ResultUtil otherError(ErrorCodeEnum errorEnum) {
        ResultUtil result = new ResultUtil();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }


}