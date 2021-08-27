package bit.your.prj.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.CsDto;
import bit.your.prj.param.Param;

@Repository
public class CsDaoImpl implements CsDao {

	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Cs.";
	
	@Override
	public List<CsDto> getCslist(Param cs) {
		return session.selectList(ns+"cslist", cs);
	}

	@Override
	public int getCsCount(Param cs) {
		return session.selectOne(ns+"getCsCount",cs);
	}

	@Override
	public boolean writeCs(CsDto dto) {
		int n = session.insert(ns + "writeCs", dto);
		return n>0?true:false;
	}

	@Override
	public CsDto getCsBbs(int seq) {
		return session.selectOne(ns + "getCsBbs", seq);
	}

	@Override
	public void readCount(int seq) {
		session.update(ns + "readCount", seq);
	}

	@Override
	public void deleteBbs(int seq) {
		session.delete(ns+"deleteBbs", seq);
	}

	@Override
	public void updateBbs(CsDto cs) {
		session.update(ns + "updateBbs", cs);
		
	}

	@Override
	public boolean replyCsBbsUpdate(CsDto cs) {
		int n = session.update(ns + "replyCsBbsUpdate", cs);
		return n>0?true:false;
	}

	@Override
	public boolean replyCsBbsInsert(CsDto cs) {
		int n = session.insert(ns + "replyCsBbsInsert", cs);
		return n>0?true:false;
	}




}
