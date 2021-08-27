package bit.your.prj.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.CMCDto;

@Repository
public class CMCDaoImpl implements CMCDao{
	
	@Autowired
	private SqlSession session;
	
	String ns = "CMC.";
	
	@Override
	public List<CMCDto> getCMCList(int seq) throws Exception {
		return session.selectList(ns + "getCMCList", seq);
	}

	@Override
	public int writeCMC(CMCDto dto) throws Exception {
		return session.insert(ns + "writeCMC", dto);
	}

	@Override
	public int updateCMC(CMCDto dto) throws Exception {
		return session.update(ns + "updateCMC", dto);
	}

	@Override
	public int deleteCMC(int seq) throws Exception {
		return session.delete(ns + "deleteCMC", seq);	
	}

	@Override
	public int writeReCMC(CMCDto dto) throws Exception {
		return session.insert(ns + "writeReCMC", dto);
	}

	@Override
	public int updatere(CMCDto dto) throws Exception {
		return session.update(ns + "updatere", dto);
	}
	
	/*
	@Override
	public List<CMCDto> getCMCPagingList(CParam param) throws Exception {
		return session.selectList(ns + "getCMCPagingList", param);
	}

	@Override
	public int getCMCCount(int seq) throws Exception {
		return session.selectOne(ns + "getCMCCount", seq);
	}
	*/
	
	
}
