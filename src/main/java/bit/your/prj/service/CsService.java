package bit.your.prj.service;

import java.util.List;


import bit.your.prj.dto.CsDto;
import bit.your.prj.param.Param;


public interface CsService {

	List<CsDto> getCslist(Param cs);
	int getCsCount(Param cs);

	boolean writeCs(CsDto dto);

	CsDto getCsBbs(int seq);
	void readCount(int seq);
	
	void deleteBbs(int seq);
	void updateBbs(CsDto cs);
	
	boolean reply(CsDto cs);
	
	
}
