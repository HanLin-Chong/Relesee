package com.relesee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.relesee.bean.RankItem;
import com.relesee.bean.User;
import com.relesee.services.RankLinesService;
import com.relesee.util.DateUtil;
import com.relesee.util.ToastUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/ranklines")
public class RankLinesController {
	
	@Autowired
	private RankLinesService rankLinesService;
	private final String error = "错误";
	private final String errorColor = "red";
	private final String success = "操作成功";
	private final String successColor = "green";
	/*
	 *  根据队列项目的订单状态查询队列，
	 */
	@RequestMapping("/query_with_status")
	public void findRankLinesWithStatuts(String status,HttpServletRequest req,HttpServletResponse resp){
		resp.setHeader("Content-type", "text/html;charset=UTF-8");  
		List<RankItem> mList = new ArrayList<RankItem>();
		mList = rankLinesService.getRankItems(status);
		
		//将List中y
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
	public void findRankLinesWithId(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String status = req.getParameter("status");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		String ranklinesid = req.getParameter("ranklinesid");
		String info;
		boolean flag;
		flag=rankLinesService.updateStatusById(status, ranklinesid);
		if(flag){
				info = this.getSuccessToastMessage("查找成功");
			//修改成功
		}else{
			// 查找失败
			info = this.getErrorToastMessage("查找失败");
		}	
		resp.getWriter().write(info);
	}
	@RequestMapping("/find_with_id")
	public void findById(HttpServletRequest req, HttpServletResponse resp){
		
	}
	@RequestMapping("/add_new_item")
	public void addRankLinesItem(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session=req.getSession();
		User user =(User) session.getAttribute("user");
		String userid = user.getUserid();
		String updateDate = DateUtil.getTime();	
	}
	
	/*
	 * 根据的在正在排队审核的id删除该项目
	 */
	@RequestMapping("/delete_item")
	public void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String ranklineid = req.getParameter("ranklineid");
		System.out.println(ranklineid);
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		String info;
		//在一下的删除操作之前应该加一个判断，判断在数据库中是该ranklineid不存在
		// 若不存即返回消息，数据库中不存在该条数据
		if(this.rankLinesService.findById(ranklineid)!=null){
			if(this.rankLinesService.deleteItem(ranklineid)){
			
				info = getSuccessToastMessage("删除成功");
			}else{
				info = this.getErrorToastMessage("删除失败");
			}
		}else{
			info = this.getErrorToastMessage("不存在当前值");
		}
		resp.getWriter().write(info);
	}
	private String getErrorToastMessage(String message){
		return ToastUtil.getToast(error, message, errorColor);
	}
	private String getSuccessToastMessage(String message){
		return ToastUtil.getToast(success, message, successColor);
	}
}
