package com.wdqsoft.system.common.exception;

import com.wdqsoft.system.common.lang.Result;
import com.wdqsoft.system.common.lang.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理全局异常类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handler(ShiroException e){
        log.error("GlobalExceptionHandler-----运行异常！！！--------");
        log.error("-------ShiroException-----运行异常！！！---\n"+e.getLocalizedMessage());
        e.printStackTrace();

        String msg="";

        if(e.getLocalizedMessage().contains("UnauthorizedException")){
            msg="没有访问权限";
        }else {
            msg=e.getMessage();
        }
        return Result.fail(ResultCode.ShiroException_CODE,msg);
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e){
        log.error("GlobalExceptionHandler-----运行异常！！！--------");
        log.error("-------MethodArgumentNotValidException-bvgfhg----运行异常！！！---\n"+e.getLocalizedMessage());
        e.printStackTrace();

        BindingResult bindingResult=e.getBindingResult();
        ObjectError objectError=bindingResult.getAllErrors().stream().findFirst().get();

        return Result.fail(ResultCode.MethodArgumentNotValidException_CODE,objectError.getDefaultMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalAccessException.class)
    public Result handler(IllegalAccessException e){
        log.error("GlobalExceptionHandler-----Assert！！！--------");
        log.error("-------IllegalAccessException-----运行异常！！！---\n"+e.getLocalizedMessage());
        e.printStackTrace();
        return Result.fail(ResultCode.IllegalAccessException_CODE,e.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        log.error("GlobalExceptionHandler-----运行异常！！！--------");
        log.error("-------RuntimeException-----运行异常！！！---\n"+e.getLocalizedMessage());
        e.printStackTrace();

        return Result.fail(ResultCode.RuntimeException_CODE,e.getMessage());
    }
}
