//package com.mengke.exception;
//
//import org.springframework.boot.autoconfigure.web.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("${server.error.path:${error.path:/error}}")
//public class FundaErrorController implements ErrorController {
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//
//    @ResponseBody
//    @RequestMapping
//    public Result doHandleError() {
//        return new Result(ResultCode.WEAK_NET_WORK);
//    }
//}