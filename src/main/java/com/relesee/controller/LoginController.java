package com.relesee.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.relesee.bean.User;
import com.relesee.bean.UserType;
import com.relesee.services.LoginService;
import com.relesee.services.LoginServiceImpl;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	@RequestMapping("/login")
	public ModelAndView login(User user,HttpServletRequest req,Model model){
		if(loginServiceImpl.login(user)){
			System.out.println("登陆成功");
			HttpSession session = req.getSession();
			User user1 = loginServiceImpl.getUser(user);
			session.setAttribute("user", user1);
			if(user.getUserid().startsWith(UserType.getName(1))){
				return new ModelAndView("redirect:/CustomerManager.jsp");
			}else if(user.getUserid().startsWith(UserType.getName(2))){
				return new ModelAndView("redirect:/index.html");
			}else{
				  return new ModelAndView("");
			}
		}else{
		       return new ModelAndView("redirect:/login.jsp");
		}
	}
}
