package com.relesee.services;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.relesee.annotation.Operator;
import com.relesee.bean.RankItem;
import com.relesee.contant.Contant;
import com.relesee.dao.impl.RankItemDaoImpl;

@Service("rankLinesService")
public class RankLinesService {
	@Autowired
	private RankItemDaoImpl rankItemDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * 根据项目的审核状态查询订单
	 * 当状态值输入为空的时候，默认查询全部状态的审核项目
	 */
	
	@Operator(target="RankItem", operator="查找")
	public List<RankItem> getRankItems(String status){
		if("".equals(status) || status==null) status = "排队待审核";
		this.rankItemDao.setJdbcTemplate(jdbcTemplate);
		String sql = "select * from ranklines where state="+"'"+status+"'";
		return this.rankItemDao.find(sql, RankItem.class);
	}
	
	public List<RankItem> getRankItemByManagerId(String managerid, String status){
		String sql;
		sql = "select * from ranklines where managerid = "+"'"+managerid+"'";
		if(status == null && status.equals("")){
			return this.rankItemDao.find(sql, RankItem.class);
		}else{
			sql+=" and state="+"'"+status+"'";
			return this.rankItemDao.find(sql, RankItem.class);
		}
	}
	
	/*
	 * 修改审核项目的是否为最新的状态，
	 * @param 0为最新文件，1表示该文件已被审核或被下载
	 */
	public boolean updatIsNewFile(String ranklinesid,int status){
		return rankItemDao.updateIsNewFile(status, ranklinesid);
	}

	
	/*
	 * 更新项目的审核状态，
	 */
	public boolean updateStatusById(String status,String ranklinesid){
		Object[] object = new Object[]{
				status,
				ranklinesid,
		};
		return rankItemDao.update("states", object);
	}
	
	
	/*
	 * 新增审核项目
	 */
	public boolean addNewRankLinesItem(RankItem rankItem){
		return rankItemDao.insertRankitem(rankItem);
	}
	
	public boolean deleteItem(String ranklineid){
	
		return rankItemDao.deleteItem(ranklineid);
	}
	
	public RankItem findById(String ranklineid){
		return rankItemDao.findById(ranklineid);
	}
}
