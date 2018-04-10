package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.RankItem;
import net.sf.json.JSONArray;
import services.RankLinesService;

@Controller
@RequestMapping("/ranklines")
public class RankLinesControlller {
	
	@Autowired
	private RankLinesService rankLinesService;
	@RequestMapping("/get/ranklines")
	
	public void findRankLiensWithStatuts(String status,HttpServletRequest req,HttpServletResponse resp){
		List<RankItem> mList = new ArrayList<RankItem>();
		mList = rankLinesService.getRankItems(status);
		JSONArray json = JSONArray.fromObject(mList);
		try {
			resp.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
