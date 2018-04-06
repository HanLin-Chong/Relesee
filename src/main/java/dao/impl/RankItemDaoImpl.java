package dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import bean.RankItem;
import dao.RankItemDao;
import util.IMapperUtil;
public class RankItemDaoImpl  extends BaseDaoImpl implements RankItemDao{
	@Override
	public boolean insertRankitem(RankItem rankItem) {
		String sql;
		sql="insert into RankLines(ranklinesid,managersid,filesurl,uploaddate,managerstype) values(?,?,?,?,?)";
		Object[] args = new Object[]{
				rankItem.getRanklinesid(),
				rankItem.getManagersid(),
				rankItem.getFilesurl(),
				rankItem.getUploaddate(),
				rankItem.getManagerstype()
		};
		return this.updateByParam(sql, args);
	}

	@Override
	public List<RankItem> findByManagerId(String managerId) {
		List<RankItem> itemList;
		String sql = "select * from ranklines where managerid="+"'"+managerId+"'";
		return null; 
	}

	@Override
	public List<RankItem> findWithDiffScope(int low, int high) {
		List<RankItem> itemList;
		String sql = "select top "+high+" * from orderlines";
		return this.findWithDiffScopeOrderBy(low, high, "RankLinesId ");
	}

	@Override
	public List<RankItem> findWithDiffScopeOrderBy(int low, int high, String orderColumn) {
		String sql="select top "+high+" *from RankLines where RankLinesId not in ";
		sql+="(select top "+low+" ranklinesid from RankLines ) order by "+orderColumn;
		return  this.find(sql, RankItem.class);
	}
}
