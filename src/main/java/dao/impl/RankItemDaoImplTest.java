package dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.springframework.test.context.junit4.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import bean.RankItem;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml"})
public class RankItemDaoImplTest {
	@Autowired private JdbcTemplate jdbcTemplate;
	@Test
	public void test() {
		
	  RankItemDaoImpl dao = new RankItemDaoImpl();
	  dao.setJdbcTemplate(jdbcTemplate);
	  List<RankItem> list = new ArrayList<RankItem>();
	  list = dao.findWithDiffScope(4, 10);
	  Iterator iter = (Iterator) list.iterator();
	  while(iter.hasNext()){
		  RankItem item = (RankItem) iter.next();
		  System.out.println(item.getFilesurl());
		  
	  }
	}
}
