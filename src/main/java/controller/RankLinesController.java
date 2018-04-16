package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.RankItem;
import bean.User;
import net.sf.json.JSONArray;
import services.RankLinesService;
import util.DateUtil;

@Controller
@RequestMapping("/ranklines")
public class RankLinesController {
	
	@Autowired
	private RankLinesService rankLinesService;
	/*
	 *  更具队列项目的订单状态查询队列，
	 */
	@RequestMapping("/query_with_status")
	public void findRankLinesWithStatuts(String status,HttpServletRequest req,HttpServletResponse resp){
		resp.setHeader("Content-type", "text/html;charset=UTF-8");  
		List<RankItem> mList = new ArrayList<RankItem>();
		mList = rankLinesService.getRankItems(status);
		JSONArray json = JSONArray.fromObject(mList);
		try {
			System.out.println(json.toString());
			resp.setCharacterEncoding("utf-8");
			
			resp.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 根据队列项目的项目id修改订单的状态 ,前端的ajax想后端发送连个数据， 审核项目的的id 要修改的状态
	 */
	@RequestMapping("/update_status_with_id")
	public void findRankLinesWithId(HttpServletRequest req,HttpServletResponse resp){
		String status = req.getParameter("status");
		String ranklinesid = req.getParameter("ranklinesid");
		boolean flag;
		flag=rankLinesService.updateStatusById(status, ranklinesid);
		if(flag){
			//修改成功
		}else{
			//修改失败
		}	
	}
	
	@RequestMapping("add_new_item")
	public void addRankLinesItem(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session=req.getSession();
		User user =(User) session.getAttribute("user");
		String userid = user.getUserid();
		String updateDate = DateUtil.getTime();
		
	
	}
}
