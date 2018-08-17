package com.jimmy.frame.config;

import com.baomidou.mybatisplus.extension.api.ApiResult;
import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: GlobalExceptionHandler
 * @description: 通用 Api Controller 全局异常处理
 * @data: 2018-08-017 07:14
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     *
     * 功能描述: 自定义 REST 业务异常
     *
     * @param:
     * @return:
     * @auther: Zhongyuan Wang
     * @date: 2018/8/17 7:25
     */
    @ExceptionHandler(value = Exception.class)
    public ApiResult<Object> handleBadRequest(Exception e) {
        /*
         * 业务逻辑异常
         */
        if (e instanceof ApiException) {
            IErrorCode errorCode = ((ApiException) e).getErrorCode();
            if (null != errorCode) {
                logger.debug("Rest request error, {}", errorCode.toString());
                return ApiResult.failed(errorCode);
            }
            logger.debug("Rest request error, {}", e.getMessage());
            return ApiResult.failed(e.getMessage());
        }

        /*
         * 参数校验异常
         */
        if (e instanceof BindException) {
            BindingResult bindingResult = ((BindException) e).getBindingResult();
            if (null != bindingResult && bindingResult.hasErrors()) {
                List<Object> jsonList = new ArrayList<>();
                bindingResult.getFieldErrors().stream().forEach(fieldError -> {
                    Map<String, Object> jsonObject = new HashMap<>(2);
                    jsonObject.put("name", fieldError.getField());
                    jsonObject.put("msg", fieldError.getDefaultMessage());
                    jsonList.add(jsonObject);
                });
                return ApiResult.restResult(jsonList, ApiErrorCode.FAILED);
            }
        }

        /**
         * 系统内部异常，打印异常栈
         */
        logger.error("Error: handleBadRequest StackTrace : {}", e);
        return ApiResult.failed(ApiErrorCode.FAILED);
    }
}
