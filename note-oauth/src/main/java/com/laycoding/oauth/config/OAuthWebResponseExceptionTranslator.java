package com.laycoding.oauth.config;

import com.laycoding.common.enums.ErrorCodeEnum;
import com.laycoding.common.exceptions.BaseException;
import com.laycoding.common.utils.ResultUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

import javax.security.auth.message.AuthException;

public class OAuthWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity translate(Exception e) {
        String message;
        if (e instanceof AuthException || e.getCause() instanceof AuthException) {
            message = e.getMessage();
        } else if (e instanceof InternalAuthenticationServiceException) {
            message = "身份验证失败";
        } else if (e instanceof InvalidGrantException) {
            message = "用户名或密码错误";
        } else if (e instanceof InvalidTokenException) {
            message = "Token无效或过期";
        } else if (e instanceof UnsupportedGrantTypeException) {
            message = "不支持的授予类型";
        } else {
            message = "登录失败";
        }
        return ResponseEntity.ok(ResultUtil.defineError(new BaseException(ErrorCodeEnum.NO_AUTH.getErrorCode(),message)));
    }

}
