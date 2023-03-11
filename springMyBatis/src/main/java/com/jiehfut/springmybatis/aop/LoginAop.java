package com.jiehfut.springmybatis.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  // 切面类
@Component
public class LoginAop {

    // 定义切点
    @Pointcut("execution(* com.jiehfut.springmybatis.controller.UserController.* (..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("这是aop的前置方法");
    }

}
