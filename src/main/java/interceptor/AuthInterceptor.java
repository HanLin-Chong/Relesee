package interceptor;

import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import annotation.Auth;
/**
 * 
 * @author JinFeng
 * 实现用户权限控制的拦截器
 * 拦截器只对action请求做出相应
 */
public class AuthInterceptor  implements HandlerInterceptor{
	
	 private Log logger = LogFactory.getLog(AuthInterceptor.class);
	 public static final String SESSION_USERID = "user_id";
	 public static final String SESSION_AUTH = "user_auth";
	 /*
	  * (non-Javadoc)
	  * 
	  * 在此处实现权限的控制，从session中取出用户的相关信息，核对用户的相关权限
	  * 核对完成之后可以自己对respons做出相对应的处理
	  *
	  */
	 @Override
	 public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		 System.out.println("拦截器启动拦截");
		 boolean flag = true;
		 if(handler instanceof HandlerMethod){
			 Auth auth = ((HandlerMethod) handler).getMethod().getAnnotation(Auth.class);
			if(auth!=null){
				if(request.getSession().getAttribute(SESSION_USERID) == null){
				
					
				}
			} else {// 登录了检查,方法上只是@Auth,表示只要求登录就能通过.@Auth("authority")这类型,验证用户权限  
                if (!"".equals(auth.value())) {  
                    Set<String> auths = (Set<String>) request.getSession().getAttribute(SESSION_AUTH);  
                    if (!auths.contains(auth.value())) {// 提示用户没权限  
                        response.setStatus(HttpStatus.FORBIDDEN.value());  
                        response.setContentType("text/html; charset=UTF-8");  
                        PrintWriter out=response.getWriter();  
                        out.write("{\"type\":\"noauth\",\"msg\":\"您没有"+auth.name()+"权限!\"}");  
                        out.flush();  
                        out.close();  
                        flag = false;  
                    }  
                }  
            }  
		 }
		 return flag;
	 }
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
				throws Exception {
			System.out.println("This is postHandle");
			
		}
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				Exception ex) throws Exception {
			// TODO Auto-generated method stub
			
		}
	 
}
