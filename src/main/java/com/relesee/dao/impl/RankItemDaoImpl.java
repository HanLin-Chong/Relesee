package com.relesee.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.relesee.bean.RankItem;
import com.relesee.dao.RankItemDao;
@Repository("rankItemDao")
public class RankItemDaoImpl  extends BaseDaoImpl implements RankItemDao{
	@Override
	public boolean insertRankitem(RankItem rankItem) {
		String sql;
		sql="insert into RankLines(ranklineid,managerid,customerid,filesurl,uploaddate,customertype) values(?,?,?,?,?,?)";
		Object[] args = new Object[]{
				rankItem.getRanklineid(),
				rankItem.getManagerid(),
				rankItem.getCustomerid(),
				rankItem.getFilesurl(),
				rankItem.getUploaddate(),
				rankItem.getCustomertype()
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
	 * @see com.relesee.dao.RankItemDao#upldate(java.lang.String, java.lang.Object[])
	 * @return 若执行更新成功则放回true
	 * @param column 需要更新的列，obj数据包括两个部分，第一位所要更新的新值，第二个id所要更新列的id值
	 */
	@Override
	public boolean update(String column, Object[] obj) {	
		String sql = "update ranklines set "+column+"=? where "+"ranklinesid=?";
		return this.updateByParam(sql, obj);
		
	}

	/*
	 * 根据申请项目的审核状态查找订单
	 */
	@Override
	public List<RankItem> findWidthStatus(String status) {
		String sql = "select * from ranklines where state="+"'"+status+"'";
		return this.find(sql, RankItem.class);
	}

	/*
	 * 删除队列指定的项目 
	 */
	@Override
	public boolean deleteItem(String ranklineid) {
		String sql = "delete ranklines where ranklineid=?";
		Object[] arg0 = new Object[]{
				ranklineid
		};
		return this.updateByParam(sql, arg0);
	}

	
	/*
	 * (non-Javadoc)
	 * 根据顶
	 * @see dao.RankItemDao#findById(java.lang.String)
	 */
	@Override
	public RankItem findById(String ranklineid) {
		String sql= "select * from ranklines where ranklineid="+"'"+ranklineid+"'";
		List<RankItem> mList = new ArrayList<RankItem>();
		mList = this.find(sql, RankItem.class);
		if(mList.size()==0){
			return null;
		}else{
			return mList.get(0);
		}
	}
	

}
