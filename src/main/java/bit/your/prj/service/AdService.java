package bit.your.prj.service;

import java.util.List;


import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.Param;

public interface AdService {
	List<MemberDto> allmemlist(Param ad);
	int getMemCount(Param ad);
	List<MemberDto> excellist();
	
	int getMenCount();
	int getWomenCount();
	int getAllMemCount();
	int getAllRecipeCount();
	int getAllClassCount();
	int getAllMarketCount();

	
	//월별 매출통계
	String jan();
	String feb();
	String mar();
	String apr();
	String may();
	String jun();
	String jul();
	String aug();
	String sep();
	String oct();
	String nov();
	String dec();
	// 분류 매출통계 
	String meat();
	String seefood();
	String vegetable();
	String fruit();
	String mealkit();

	
	List<RecipeDto> allrecipelist(Param ad);
	int getRecipeCount(Param ad);

	
	List<CCDto> allclasslist(Param ad);
	int getClassCount(Param ad);
	
	
	List<MarketDto> allmarketlist(Param ad);
	int getMarketCount(Param ad);
	
	
}

