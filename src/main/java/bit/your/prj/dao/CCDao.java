package bit.your.prj.dao;

import java.util.List;
import java.util.Map;

import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.CMDto;
import bit.your.prj.param.ClassParam;

public interface CCDao {
	
	//글 리스트 
	//List<CCDto> getCClist();
	List<CCDto> getCClist(ClassParam cc);
	int getCCCount(ClassParam cc);
	
	//글 작성
	boolean uploadCC(CCDto dto);
	
	//글 디테일
	CCDto getCC(int seq);
	void readCount(int seq);
	
	//글 삭제
	void deleteCC(int seq);
	
	//글 수정
	boolean updateCC(CCDto dto);

/////////////////클래스멤버/////////////////////////////////
	//클래스 참여
	boolean enterCM(CMDto dto);
		
	//참여인원 리스트
	List<CMDto> getCM(int seq);
	
	//참여인원 리스트2
	List<Map<String, Object>> getNickNameCM(String nickname);
	
	//탈퇴하기
	void resignCM(CMDto dto);
	
	//참여인원수
	int getCMCount(int seq);
	
	//회원가입시 회원수 증가
	void memberCount(int seq);
	void memberCountDown(int seq);
	
	
	//효제추가
	List<CCDto> mycclist(String nickname);
	List<Map<String, Object>> myclass(String nickname);

	
}
