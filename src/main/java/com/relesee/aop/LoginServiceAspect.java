package com.relesee.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.relesee.bean.User;
import com.relesee.domain.UserLoginLog;
import com.relesee.services.LoginServiceImpl;
/**
 * 
 * @author JinFeng
 *  用户登录成功之后，该切面是当用户登录成功之后记录用户的的相关登录日志的切面
 */
@Aspect
public class LoginServiceAspect {
	UserLoginLog loginLog  = new UserLoginLog();
	@Autowired
	
	@Pointcut("execution(* com.relesee.services.LoginServiceImpl.login(..))")
	public void login(){
		
	}
	User user = new User();
	@Before("login()")
	public void doBefor(JoinPoint joinPoint){
			user = (User) joinPoint.getArgs()[0];
	}
	@After("login()")
	public void doAfter(){
		
	} 
    @AfterReturning(pointcut="login()", returning="returnValue")  
    public void afterReturn(Object returnValue){  
    	System.out.println("用户登录信息："+user.toString());
    	if((boolean)returnValue == true){
    		System.out.println("系统以保存日志");
    		/*
    		 * TODO 在这里写入记录用户登录的日志,使用spring的自动注 @autoworied可以将LogDao注入到这个地方
    		 */
    	}
    	else{
    		System.out.println("账号输入错误，放弃写入日志");
    	}
    }  
}
