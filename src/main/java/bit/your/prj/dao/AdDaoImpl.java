package bit.your.prj.dao;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.IncomeDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.Param;

@Repository
public class AdDaoImpl implements AdDao{
	
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Ad.";

	@Override
	public List<MemberDto> allmemlist(Param ad) {
		return session.selectList(ns+"allmemlist",ad);
	}

	@Override
	public int getMemCount(Param ad) {
		return session.selectOne(ns+"getMemCount",ad);
	}

	@Override
	public List<MemberDto> excellist() {
		return session.selectList(ns+"excellist");
	}

	@Override
	public int getMenCount() {
		return session.selectOne(ns+"getMenCount");
	}

	@Override
	public int getWomenCount() {
		return session.selectOne(ns+"getWomenCount");
	}
	
	@Override
	public int getAllMemCount() {
		return session.selectOne(ns+"getAllMemCount");
	}
	
	@Override
	public int getAllRecipeCount() {
		return session.selectOne(ns+"getAllRecipeCount");
	}

	@Override
	public int getAllClassCount() {
		return session.selectOne(ns+"getAllClassCount");
	}

	@Override
	public int getAllMarketCount() {
		return session.selectOne(ns+"getAllMarketCount");
	}
	
	@Override
	public String jan() {
		return session.selectOne(ns+"jan");
	}

	@Override
	public String feb() {
		return session.selectOne(ns+"feb");
	}

	@Override
	public String mar() {
		return session.selectOne(ns+"mar");
	}

	@Override
	public String apr() {
		return session.selectOne(ns+"apr");
	}

	@Override
	public String may() {
		return session.selectOne(ns+"may");
	}

	@Override
	public String jun() {
		return session.selectOne(ns+"jun");
	}

	@Override
	public String jul() {
		return session.selectOne(ns+"jul");
	}

	@Override
	public String aug() {
		return session.selectOne(ns+"aug");
	}

	@Override
	public String sep() {
		return session.selectOne(ns+"sep");
	}

	@Override
	public String oct() {
		return session.selectOne(ns+"oct");
	}

	@Override
	public String nov() {
		return session.selectOne(ns+"nov");
	}

	@Override
	public String dec() {
		return session.selectOne(ns+"dec");
	}
	// 분류통계
	@Override
	public String meat() {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"meat");
	}

	@Override
	public String seefood() {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"seefood");
	}

	@Override
	public String vegetable() {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"vegetable");
	}

	@Override
	public String fruit() {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"fruit");
	}

	@Override
	public String mealkit() {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"mealkit");
	}

	@Override
	public List<RecipeDto> allrecipelist(Param ad) {
 		return session.selectList(ns+"allrecipelist",ad);
	}

	@Override
	public int getRecipeCount(Param ad) {
		return session.selectOne(ns+"getRecipeCount",ad);
	}

	@Override
	public List<CCDto> allclasslist(Param ad) {
		return session.selectList(ns+"allclasslist",ad);
	}

	@Override
	public int getClassCount(Param ad) {
		return session.selectOne(ns+"getClassCount",ad);
	}

	@Override
	public List<MarketDto> allmarketlist(Param ad) {
		return session.selectList(ns+"allmarketlist", ad);
	}

	@Override
	public int getMarketCount(Param ad) {
		return session.selectOne(ns+"getMarketCount",ad);
	}


	

	

}
