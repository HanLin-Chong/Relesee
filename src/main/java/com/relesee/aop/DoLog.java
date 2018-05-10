package com.relesee.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.relesee.annotation.Operator;
import com.relesee.bean.User;

// TODO 这里还需要添加
/**
 * 
 * @author jinfeng
 *	@since 1.0.0
 *  记录申请项目操作的类，
 */
@Aspect
public class DoLog {
	private final String RANK_LINE_LOG="";
	/**
	 * 对Controller下所有方法进行切片，
	 */
	@Pointcut("execution(* com.relesee.controller.RankLinesController.*(..))")
	public void pointcut(){
		
	}

	@After("pointcut()")
	/**
	 * 在方法执行之后记录下执行的记录
	 * @param joinPoint
	 */
	public void afterdDo(JoinPoint joinPoint){
		HttpServletRequest req = null;
		String userid = null;
		Object[] args = joinPoint.getArgs();
		// 从前段获取session，获取记录对象
		
		//遍历所有的参数，从中取得HttpservletRequest
		for(int i=0;i<args.length;i++){
			Object obj = args[i];
			// 判断该对象是否是HttpServletRequest
			if(obj instanceof HttpServletRequest){
				req =(HttpServletRequest) obj;
			}
		}
		HttpSession  session = req.getSession();
		if(session != null){
			User user = (User) session.getAttribute("user");
			if(user !=null){
				userid = user.getUserid();
			}
		}
		Signature signature = joinPoint.getSignature();
		if(signature !=null){
			MethodSignature methodSignature = (MethodSignature) signature; 
			Method method = methodSignature.getMethod();
			Operator operator = method.getAnnotation(Operator.class);
			if(operator !=null){
				System.out.println(userid+"操作方法名字"+method.getName()+"-------操作类型："+operator.operator());
			
				System.out.println("在执行操作之后的日志");
			}
		}
	
		 
	}
}
