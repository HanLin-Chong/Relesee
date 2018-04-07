package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.impl.RankItemDaoImpl;

@Service("rankLinesService")
public class RankLinesService {
	@Autowired
	private RankItemDaoImpl rankItemDao;
}
