package dao;

import java.util.List;

import bean.RankItem;

public interface RankItemDao {
	public boolean insertRankitem(RankItem rankItem);
	//根据处理业务不同的管理员的项目进行分类检索
	public List<RankItem> findByManagerId(String managerId);
	
	//查找一定范围内的项目
	public List<RankItem> findWithDiffScope(int low,int heigh);
	//更具某一列查找某一范围的的排序
	public List<RankItem> findWithDiffScopeOrderBy(int low, int high, String orderColumn);
	//
	public boolean update(String column,Object[] obj);
}
