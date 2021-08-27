package bit.your.prj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.CartDto;
import bit.your.prj.dto.IncomeDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MarketParam;

@Repository
public class MarketDaoImpl implements MarketDao{

	@Autowired
	SqlSessionTemplate session;
	
	
	String ns = "Market.";

	@Override
	public List<MarketDto> getMarketlist() {
		return session.selectList(ns + "marketlist");
	}

	@Override
	public MarketDto getMarket(int seq) {
		return session.selectOne(ns + "getMarket", seq);
	}

	@Override
	public List<MarketDto> getCalist(int canum) {
		return session.selectList(ns + "getCalist", canum);
	}

	@Override
	public boolean uploadMarket(MarketDto dto) {
		int n = session.insert(ns + "uploadMarket", dto);
		return n>0?true:false;
	}

	@Override
	public MarketDto getItem(int itemnum) {
		return session.selectOne(ns + "getItem", itemnum);
	}

	@Override
	public boolean addCart(CartDto dto) {
		System.out.println(session);

		int b = session.insert(ns + "addCart", dto);
		return b>0?true:false;
	}

	@Override
	public int getCartCount(String id) {
		return session.selectOne(ns + "getCartCount", id);
	}

	@Override
	public List<MarketDto> newMarketList() {
		return session.selectList(ns + "newMarketList");
	}

	@Override
	public List<MarketDto> getSearchList(MarketParam search) {
		return session.selectList(ns + "getSearchList", search);
	}

	@Override
	public List<CartDto> getCartList(String id) {
		return session.selectList(ns + "getCartList", id);
	}

	@Override
	public CartDto getCount(int itemnum) {
		return session.selectOne(ns + "getCount", itemnum);
	}

	@Override
	public boolean delCart(int seq) {
		int b = session.update(ns + "delCart", seq);
		return b>0?true:false;
	}

	@Override
	public boolean itemCountUp(int seq) {
		int b = session.update(ns + "itemCountUp", seq);
		return b>0?true:false;
	}

	@Override
	public boolean itemCountDown(int seq) {
		int b = session.update(ns + "itemCountDown", seq);
		return b>0?true:false;
	}

	@Override
	public boolean delAllItem(String id) {
		int b = session.update(ns + "delAllItem", id);
		return b>0?true:false;
	}

	@Override
	public CartDto getCartItem(int seq) {
		return session.selectOne(ns+"getCartItem", seq);
	}

	@Override
	public boolean insertIncome(IncomeDto dto) {
		int b = session.insert(ns + "insertIncome", dto);
		return b>0?true:false;
	}

	@Override
	public List<IncomeDto> getIncome(String id) {
		return session.selectList(ns + "getIncome" ,id);
	}

	
	




}
