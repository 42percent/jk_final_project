package bit.your.prj.service;

import java.util.List;

import bit.your.prj.dto.CartDto;
import bit.your.prj.dto.IncomeDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MarketParam;

public interface MarketService {

	List<MarketDto> getMarketlist();
	
	MarketDto getMarket(int seq);
	
	public List<MarketDto> getCalist(int canum);
	
	boolean uploadMarket(MarketDto dto);
	
	MarketDto getItem(int itemnum);
	
	boolean addCart(CartDto dto);
	
	int getCartCount(String id);
	
	List<MarketDto> newMarketList();
	
	List<MarketDto> getSearchList(MarketParam search);
	
	List<CartDto> getCartList(String id);
	
	CartDto getCount(int itemnum);
	
	boolean delCart(int seq);
	
	boolean itemCountUp(int seq);
	
	boolean itemCountDown(int seq);
	
	boolean delAllItem(String id);
	
	CartDto getCartItem(int seq);
	
	boolean insertIncome(IncomeDto dto);
	
	List<IncomeDto> getIncome(String id);
	
}
