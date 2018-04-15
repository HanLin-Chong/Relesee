package services;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import bean.RankItem;
import dao.impl.RankItemDaoImpl;

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
	public List<RankItem> getRankItems(String status){
		if("".equals(status) || status==null) status = "排队待审核";
		this.rankItemDao.setJdbcTemplate(jdbcTemplate);
		String sql = "select * from ranklines where states="+"'"+status+"'";
		return this.rankItemDao.find(sql, RankItem.class);
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
}
