package com.hb.common.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hb.common.util.RequestResult;

/**
 * @Description: controller异常处理
 */
@RestControllerAdvice
public class ExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public RequestResult<String> handleException(Exception e) {
        logger.error("服务运行异常", e);
        return new RequestResult<String>(false, RequestResult.CODE_EXCEPTION, "服务运行异常", null);
    }

}
