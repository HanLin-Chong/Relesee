package filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		User user=new User();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse reps = (HttpServletResponse) response;
		String path=request.getRequestURI();
		user=(User)request.getSession().getAttribute("user");
		RequestDispatcher rd = null;
		if(path.endsWith("relesee/login.jsp")||path.endsWith("relesee/index.jsp")||path.endsWith("user/login")){
		
		}
		else if(user==null){
			 reps.sendRedirect("/relesee/login.jsp");
		}else{
			
		} 
		 chain.doFilter(req, response);				
	}

	@Override
	public void destroy(){
		// TODO Auto-generated method stub
		
	}

}
