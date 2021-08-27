package bit.your.prj.dao;

import java.util.List;


import bit.your.prj.dto.CMCDto;

public interface CMCDao {
	
	public List<CMCDto> getCMCList(int seq) throws Exception;
	
	public int writeCMC(CMCDto dto) throws Exception;
	
	public int updateCMC(CMCDto dto) throws Exception;
	
	public int deleteCMC(int seq) throws Exception;
	
	/*
	public List<CMCDto> getCMCPagingList(CParam param) throws Exception;
	
	public int getCMCCount(int seq) throws Exception;
	*/
	
	public int writeReCMC(CMCDto dto) throws Exception;
	
	public int updatere(CMCDto dto) throws Exception;
}
