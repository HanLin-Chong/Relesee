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
	
	public List<RankItem> getRankItems(String status){
		if("".equals(status) || status==null) status = "待审核";
		this.rankItemDao.setJdbcTemplate(jdbcTemplate);
		String sql = "select * from ranklines where states="+"'"+status+"'";
		return this.rankItemDao.find(sql, RankItem.class);
	}
}
