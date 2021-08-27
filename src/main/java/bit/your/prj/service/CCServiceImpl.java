package bit.your.prj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.CCDao;
import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.CMDto;
import bit.your.prj.param.ClassParam;

@Service
public class CCServiceImpl implements CCService {
	
	@Autowired
	CCDao dao;
	
	/*
	@Override
	public List<CCDto> getCClist() {
		return dao.getCClist();
	}
	*/
	
	@Override 
	 public List<CCDto> getCClist(ClassParam cc) { 
	 	return dao.getCClist(cc); 
	}
	
	 @Override 
	 public int getCCCount(ClassParam cc) { 
	 	return dao.getCCCount(cc); 
	 }

	@Override
	public boolean uploadCC(CCDto dto) {
		return dao.uploadCC(dto);
	}

	@Override
	public CCDto getCC(int seq) {
		return dao.getCC(seq);
	}

	@Override
	public void readCount(int seq) {
		dao.readCount(seq);
	}

	@Override
	public void deleteCC(int seq) {
		dao.deleteCC(seq);
	}
	
	@Override
	public boolean updateCC(CCDto dto) {
		return dao.updateCC(dto);
	}
	
	@Override
	public boolean enterCM(CMDto dto) {
		return dao.enterCM(dto);
	}

	@Override
	public List<CMDto> getCM(int seq_class) {
		return dao.getCM(seq_class);
	}

	@Override
	public List<Map<String, Object>> getNickNameCM(String nickname) {
		return dao.getNickNameCM(nickname);
	}

	@Override
	public void resignCM(CMDto dto) {
		dao.resignCM(dto);		
	}

	@Override
	public int getCMCount(int seq) {
		return dao.getCMCount(seq);
	}

	@Override
	public void memberCount(int seq) {
		dao.memberCount(seq);
	}

	@Override
	public void memberCountDown(int seq) {
		dao.memberCountDown(seq);
	}
	
	//효제추가
	@Override
	public List<CCDto> mycclist(String nickname) {
		return dao.mycclist(nickname);
	}

	@Override
	public List<Map<String, Object>> myclass(String nickname) {
		return dao.myclass(nickname);
	}
}
