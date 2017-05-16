package org.jon.lv.interceptors;

import org.jon.lv.exception.AppWebException;
import org.jon.lv.exception.ErrorConstant;
import org.jon.lv.result.ResultDO;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.ConnectException;

/**
 * @Description: 全局异常
 * Author lv bin
 * @date 2017/3/17 9:35
 * version V1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private ResultDO<String> resultDO = new ResultDO<String>();

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultDO<String> runtimeExceptionHandler(RuntimeException runtimeException) {
        logException(runtimeException);
        resultDO.setErrCode(ErrorConstant.RUNTIME_EXCEPTION.getCode());
        resultDO.setErrMsg(ErrorConstant.RUNTIME_EXCEPTION.getMsg());
        return resultDO;
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultDO<String> nullPointerExceptionHandler(NullPointerException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.NULL_POINTER_EXCEPTION.getCode());
        resultDO.setErrMsg(ErrorConstant.NULL_POINTER_EXCEPTION.getMsg());
        return resultDO;
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ResultDO<String> classCastExceptionHandler(ClassCastException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.CLASS_CAST_EXCEPTION.getCode());
        resultDO.setErrMsg(ErrorConstant.CLASS_CAST_EXCEPTION.getMsg());
        return resultDO;
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ResultDO<String> iOExceptionHandler(IOException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.IO_EXCEPTION.getCode());
        resultDO.setErrMsg(ErrorConstant.IO_EXCEPTION.getMsg());
        return resultDO;
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public ResultDO<String> noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.NO_SUCH_METHOD_EXCEPTION.getCode());
        resultDO.setErrMsg(ErrorConstant.NO_SUCH_METHOD_EXCEPTION.getMsg());
        return resultDO;
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ResultDO<String> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.INDEX_OUT_OF_BOUNDS_EXCEPTION.getCode());
        resultDO.setErrMsg(ErrorConstant.INDEX_OUT_OF_BOUNDS_EXCEPTION.getMsg());
        return resultDO;
    }

    //网络异常
    @ExceptionHandler(ConnectException.class)
    @ResponseBody
    public ResultDO<String> connectException(ConnectException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.CONNECT_EXCEPTION.getCode());
        resultDO.setErrMsg(ErrorConstant.CONNECT_EXCEPTION.getMsg());
        return resultDO;
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResultDO<String> requestNotReadable(HttpMessageNotReadableException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.BAD_REQUEST.getCode());
        resultDO.setErrMsg(ErrorConstant.BAD_REQUEST.getMsg());
        return resultDO;
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public ResultDO<String> requestTypeMismatch(TypeMismatchException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.BAD_REQUEST.getCode());
        resultDO.setErrMsg(ErrorConstant.BAD_REQUEST.getMsg());
        return resultDO;
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ResultDO<String> requestMissingServletRequest(MissingServletRequestParameterException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.BAD_REQUEST.getCode());
        resultDO.setErrMsg(ErrorConstant.BAD_REQUEST.getMsg());
        return resultDO;
    }

    @ExceptionHandler({ ServletException.class })
    @ResponseBody
    public ResultDO<String> http404(ServletException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.NOT_FOUND_REQUEST.getCode());
        resultDO.setErrMsg(ErrorConstant.NOT_FOUND_REQUEST.getMsg());
        return resultDO;
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ResultDO<String> request405(HttpRequestMethodNotSupportedException ex) {
        logException(ex);
        resultDO.setErrCode(ErrorConstant.METHOD_NOT_ALLOWED.getCode());
        resultDO.setErrMsg(ErrorConstant.METHOD_NOT_ALLOWED.getMsg());
        return resultDO;
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public ResultDO<String> request406(HttpMediaTypeNotAcceptableException ex) {
        logException(ex);

        resultDO.setErrCode(ErrorConstant.NOT_ACCEPTABLE.getCode());
        resultDO.setErrMsg(ErrorConstant.NOT_ACCEPTABLE.getMsg());
        return resultDO;
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public ResultDO<String> server500(RuntimeException runtimeException) {
        logException(runtimeException);
        resultDO.setErrCode(ErrorConstant.INTERNAL_SERVER_ERROR.getCode());
        resultDO.setErrMsg(ErrorConstant.INTERNAL_SERVER_ERROR.getMsg());
        return resultDO;
    }

    //app web 异常
    @ExceptionHandler({AppWebException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultDO<String> appWebException(AppWebException appWebException) {
        logException(appWebException);
        resultDO.setErrCode(appWebException.getErrCode());
        resultDO.setErrMsg(appWebException.getMessage());
        return resultDO;
    }

    /**
     * 异常记录
     * @param e
     */
    private void logException(Exception e){
        e.printStackTrace();
    }
}
