package com.relesee.dao.impl;

import java.util.List;

import com.relesee.bean.PriorLine;

/**
 * 
 * @author jinfeng
 * 申请数据库项目优先队列的操作
 * 优先队列表的相关CRUD操作
 */
public interface PriorLineDao{
	public List<PriorLine> findWithState(String state);
	public boolean deleteById(String priorlineid);
	public PriorLine findById(String priorlineid);
}
