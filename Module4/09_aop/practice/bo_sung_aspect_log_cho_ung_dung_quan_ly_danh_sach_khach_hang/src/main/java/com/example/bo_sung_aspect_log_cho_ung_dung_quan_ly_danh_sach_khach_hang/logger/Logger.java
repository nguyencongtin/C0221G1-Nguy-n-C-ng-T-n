package com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
    @AfterThrowing(pointcut = "execution(public * com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.service.CustomerService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));

    }
}
