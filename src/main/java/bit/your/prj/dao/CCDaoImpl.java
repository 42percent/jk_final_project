package bit.your.prj.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.CMDto;
import bit.your.prj.param.ClassParam;

@Repository
public class CCDaoImpl implements CCDao{
	
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "CC.";
	
	/*
	@Override
	public List<CCDto> getCClist() {
		return session.selectList(ns + "cclist");
	}
	*/
	
	@Override 
	public List<CCDto> getCClist(ClassParam cc) { 
		return session.selectList(ns + "getCClist", cc); 
	}
	 
	 @Override 
	 public int getCCCount(ClassParam cc) { 
	 	return session.selectOne(ns + "getCCCount", cc); 
	}
	
	@Override
	public boolean uploadCC(CCDto dto) {
		int n = session.insert(ns + "uploadCC", dto);
		return n>0?true:false;
	}

	@Override
	public CCDto getCC(int seq) {
		return session.selectOne(ns + "getCC", seq);
	}

	@Override
	public void readCount(int seq) {
		session.update(ns + "readCount", seq);	
	}
	
	@Override
	public void deleteCC(int seq) {
		session.update(ns+"deleteCC", seq);
	}

	@Override
	public boolean updateCC(CCDto dto) {
		int n = session.update(ns + "updateCC", dto);
		return n>0?true:false;
	}
	
	@Override
	public boolean enterCM(CMDto dto) {
		int n = session.insert(ns + "enterCM", dto);
		return n>0?true:false;
	}

	@Override
	public List<CMDto> getCM(int seq) {
		return session.selectList(ns + "getCM", seq);
	}
	
	@Override
	public List<Map<String, Object>> getNickNameCM(String nickname) {
		return session.selectList(ns + "getNickNameCM", nickname);
	}

	@Override
	public void resignCM(CMDto dto) {
		session.delete(ns + "resignCM", dto);
	}

	@Override
	public int getCMCount(int seq) {
		return session.selectOne(ns + "getCMCount", seq);
	}

	@Override
	public void memberCount(int seq) {
		session.update(ns + "memberCount", seq);	
	}

	@Override
	public void memberCountDown(int seq) {
		session.update(ns + "memberCountDown", seq);
	}
	
	
	//효제추가 
	@Override
	public List<CCDto> mycclist(String nickname) {
		return session.selectList(ns + "mycclist", nickname);
	}
	
	@Override
	public List<Map<String, Object>> myclass(String nickname) {
		return session.selectList(ns + "myclass", nickname);
	}
	
}
