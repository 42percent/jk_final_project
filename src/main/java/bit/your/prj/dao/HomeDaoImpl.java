package bit.your.prj.dao;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.CCDto;
import bit.your.prj.param.ClassParam;
import bit.your.prj.dto.MarketDto;

@Repository
public class HomeDaoImpl implements HomeDao {
	
	@Autowired
	SqlSessionTemplate session;
	
	
	String ns = "Home.";
	
	@Override
	public List<MarketDto> homemclist() {
		return session.selectList(ns + "homemclist");
	}

	@Override
	public List<CCDto> maincclist(ClassParam cc) {
		return session.selectList(ns + "maincclist", cc); 
	}
}
