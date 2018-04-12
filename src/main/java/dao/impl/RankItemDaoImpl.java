package dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import bean.RankItem;
import dao.RankItemDao;
@Repository("rankItemDao")
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

	/*
	 * TODO 未完成，待补充
	 */
	@Override
	public List<RankItem> findByManagerId(String managerId) {
		String sql = "select * from ranklines where managerid="+"'"+managerId+"'";
		return null; 
	}

	@Override
	public List<RankItem> findWithDiffScope(int low, int high) {
		return this.findWithDiffScopeOrderBy(low, high, "RankLinesId ");
	}

	@Override
	public List<RankItem> findWithDiffScopeOrderBy(int low, int high, String orderColumn) {
		String sql="select top "+high+" *from RankLines where RankLinesId not in ";
		sql+="(select top "+low+" ranklinesid from RankLines ) order by "+orderColumn;
		return  this.find(sql, RankItem.class);
	}


	
	public boolean updateIsNewFile(int isNewFile,String ranklinesid){
		String currentColumn="isnewFiles";
		Object[] obj=new Object[]{
			isNewFile,
			ranklinesid
		};
		return this.update(currentColumn, obj);
	}
	
	/**
	 * (non-Javadoc)
	 * @see dao.RankItemDao#upldate(java.lang.String, java.lang.Object[])
	 * @return 若执行更新成功则放回true
	 * @param column 需要更新的列，obj数据包括两个部分，第一位所要更新的新值，第二个id所要更新列的id值
	 */
	@Override
	public boolean update(String column, Object[] obj) {	
		String sql = "update ranklines set "+column+"=? where "+"ranklinesid=?";
		return this.updateByParam(sql, obj);
		
	}

	@Override
	public List<RankItem> findWidthStatus(String status) {
		String sql = "select * from ranklines where states="+"'"+status+"'";
		return this.find(sql, RankItem.class);
	}
}
