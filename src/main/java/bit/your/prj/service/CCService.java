package bit.your.prj.service;

import java.util.List;
import java.util.Map;

import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.CMDto;
import bit.your.prj.param.ClassParam;

public interface CCService {
	
	//List<CCDto> getCClist();
	List<CCDto> getCClist(ClassParam cc); 
	int getCCCount(ClassParam cc);
	
	boolean uploadCC(CCDto dto);
	
	CCDto getCC(int seq);
	void readCount(int seq);

	void deleteCC(int seq);
	
	boolean updateCC(CCDto dto);
	
	boolean enterCM(CMDto dto);
	
	List<CMDto> getCM(int seq_class);
	List<Map<String, Object>> getNickNameCM(String nickname);
	
	void resignCM(CMDto dto);	
	
	int getCMCount(int seq);
	
	void memberCount(int seq);
	void memberCountDown(int seq);
	
	//효제추가
	List<CCDto> mycclist(String nickname); 
	List<Map<String, Object>> myclass(String nickname);
	

}
