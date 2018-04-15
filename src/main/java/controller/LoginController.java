package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.User;
import services.LoginService;
import services.LoginServiceImpl;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Resource(name="userService")
	private LoginServiceImpl loginService;
	@RequestMapping("/login")
	public ModelAndView login(User user,HttpServletRequest req,Model model){
		if(loginService.login(user)){
			System.out.println("登陆成功");
			HttpSession session = req.getSession();
			session.setAttribute("user", loginService.getUser(user));
		}else{
		       return new ModelAndView("/login.jsp");
		}
		return new ModelAndView("/index.jsp");
	}
}
