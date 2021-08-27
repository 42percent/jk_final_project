package bit.your.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.CsDao;
import bit.your.prj.dto.CsDto;
import bit.your.prj.param.Param;

@Service
public class CsServiceImpl implements CsService {
	
	@Autowired
	CsDao dao;

	@Override
	public List<CsDto> getCslist(Param cs) {
		return dao.getCslist(cs);
	}

	@Override
	public int getCsCount(Param cs) {
		return dao.getCsCount(cs);
	}

	@Override
	public boolean writeCs(CsDto dto) {
		return dao.writeCs(dto);
	}

	@Override
	public CsDto getCsBbs(int seq) {
		return dao.getCsBbs(seq);
	}

	@Override
	public void readCount(int seq) {
		dao.readCount(seq);
		
	}

	@Override
	public void deleteBbs(int seq) {
		dao.deleteBbs(seq);
	}

	@Override
	public void updateBbs(CsDto cs) {
		dao.updateBbs(cs);
	}

	@Override
	public boolean reply(CsDto cs) {
		boolean b1 = dao.replyCsBbsUpdate(cs);
		boolean b2 = dao.replyCsBbsInsert(cs);
		if(b1 == false || b2 == false) {
			return false;
		}
		return true;
	}

}
