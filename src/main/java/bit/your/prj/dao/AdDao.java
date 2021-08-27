package bit.your.prj.dao;

import java.util.List;


import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.Param;

public interface AdDao {
	//회원정보 리스트 , excel download
	List<MemberDto> allmemlist(Param ad);
	int getMemCount(Param ad);
	List<MemberDto> excellist();
	
	//회원성별 통계
	int getMenCount();
	int getWomenCount();
	
	int getAllMemCount();
	int getAllRecipeCount();
	int getAllClassCount();
	int getAllMarketCount();
	
	// 매출통계
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
	
	//분류 매출통계
	String meat();
	String seefood();
	String vegetable();
	String fruit();
	String mealkit();
	
	
	//레시피 리스트, excel download
	List<RecipeDto> allrecipelist(Param ad);
	int getRecipeCount(Param ad);
	//엑셀 나중에 확인해서 작성 필
	
	//클래스 리스트, excel download
	List<CCDto> allclasslist(Param ad);
	int getClassCount(Param ad);
	//엑셀추가자리
	
	
	//판매리스트, excel
	List<MarketDto> allmarketlist(Param ad);
	int getMarketCount(Param ad);
	//엑셀추가자리
	
	
	
	
	
	
}
