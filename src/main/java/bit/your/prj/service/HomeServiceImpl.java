package bit.your.prj.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.HomeDao;
import bit.your.prj.dto.CCDto;
import bit.your.prj.param.ClassParam;
import bit.your.prj.dto.MarketDto;

	@Service
	public class HomeServiceImpl implements HomeService{

		@Autowired
		HomeDao dao;
		
		@Override
		public List<MarketDto> homemclist() {
			return dao.homemclist();
		}
		
		@Override//메인페이지 쿠킹리스트
		public List<CCDto> maincclist(ClassParam cc) {
			return dao.maincclist(cc);
		}
		
	}
