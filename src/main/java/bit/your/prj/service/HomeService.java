package bit.your.prj.service;

import java.util.List;


import bit.your.prj.dto.CCDto;
import bit.your.prj.param.ClassParam;
import bit.your.prj.dto.MarketDto;

public interface HomeService {

	List<MarketDto> homemclist();
	
	//메인페이지 쿠킹리스트
	List<CCDto> maincclist(ClassParam cc); 
}
