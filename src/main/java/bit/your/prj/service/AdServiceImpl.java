package bit.your.prj.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.AdDao;
import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.IncomeDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.Param;

@Service
public class AdServiceImpl implements AdService{

	@Autowired
	AdDao dao;
	
	@Override
	public List<MemberDto> allmemlist(Param ad) {
		return dao.allmemlist(ad);
	}

	@Override
	public int getMemCount(Param ad) {
		return dao.getMemCount(ad);
	}

	@Override
	public List<MemberDto> excellist() {
		return dao.excellist();
	}

	@Override
	public int getMenCount() {
		return dao.getMenCount();
	}

	@Override
	public int getWomenCount() {
		return dao.getWomenCount();
	}
	
	@Override
	public int getAllMemCount() {
		return dao.getAllMemCount();
	}
	
	@Override
	public int getAllRecipeCount() {
		return dao.getAllRecipeCount();
	}

	@Override
	public int getAllClassCount() {
		return dao.getAllClassCount();
	}

	@Override
	public int getAllMarketCount() {
		return dao.getAllMarketCount();
	}
	
	@Override
	public String jan() {
		return dao.jan();
	}

	@Override
	public String feb() {
		return dao.feb();
	}

	@Override
	public String mar() {
		return dao.mar();
	}

	@Override
	public String apr() {
		return dao.apr();
	}

	@Override
	public String may() {
		return dao.may();
	}

	@Override
	public String jun() {
		return dao.jun();
	}

	@Override
	public String jul() {
		return dao.jul();
	}

	@Override
	public String aug() {
		return dao.aug();
	}

	@Override
	public String sep() {
		return dao.sep();
	}

	@Override
	public String oct() {
		return dao.oct();
	}

	@Override
	public String nov() {
		return dao.nov();
	}

	@Override
	public String dec() {
		return dao.dec();
	}
	
	@Override
	public String meat() {
		return dao.meat();
	}

	@Override
	public String seefood() {
		return dao.seefood();
	}

	@Override
	public String vegetable() {
		return dao.vegetable();
	}

	@Override
	public String fruit() {
		return dao.fruit();
	}

	@Override
	public String mealkit() {
		return dao.mealkit();
	}


	@Override
	public List<RecipeDto> allrecipelist(Param ad) {
		return dao.allrecipelist(ad);
	}

	@Override
	public int getRecipeCount(Param ad) {
		return dao.getRecipeCount(ad);
	}

	@Override
	public List<CCDto> allclasslist(Param ad) {
		return dao.allclasslist(ad);
	}

	@Override
	public int getClassCount(Param ad) {
		return dao.getClassCount(ad);
	}

	@Override
	public List<MarketDto> allmarketlist(Param ad) {
		return dao.allmarketlist(ad);
	}

	@Override
	public int getMarketCount(Param ad) {
		return dao.getMarketCount(ad);
	}


	

	
	


}
