package bit.your.prj.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.CMCDao;
import bit.your.prj.dto.CMCDto;

@Service
public class CMCServiceImpl implements CMCService{
	
	@Autowired
	CMCDao dao;
	
	@Override
	public List<CMCDto> getCMCList(int seq) throws Exception {
		return dao.getCMCList(seq);
	}

	@Override
	public int writeCMC(CMCDto dto) throws Exception {
		return dao.writeCMC(dto);
	}

	@Override
	public int updateCMC(CMCDto dto) throws Exception {
		return dao.updateCMC(dto);
	}

	@Override
	public int deleteCMC(int seq) throws Exception {
		return dao.deleteCMC(seq);
	}

	@Override
	public int writeReCMC(CMCDto dto) throws Exception {
		return dao.writeReCMC(dto);
	}

	@Override
	public int updatere(CMCDto dto) throws Exception {
		return dao.updatere(dto);
	}
	
	/*
	@Override
	public List<CMCDto> getCMCPagingList(CParam param) throws Exception {
		return dao.getCMCPagingList(param);
	}

	@Override
	public int getCMCCount(int seq) throws Exception {
		return dao.getCMCCount(seq);
	}
	*/
}
