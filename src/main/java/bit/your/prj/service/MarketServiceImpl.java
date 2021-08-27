package bit.your.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.MarketDao;
import bit.your.prj.dto.CartDto;
import bit.your.prj.dto.IncomeDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MarketParam;

@Service
public class MarketServiceImpl implements MarketService{

	@Autowired
	MarketDao dao;


	@Override
	public List<MarketDto> getMarketlist() {
		return dao.getMarketlist();
	}


	@Override
	public MarketDto getMarket(int seq) {
		return dao.getMarket(seq);
	}


	@Override
	public List<MarketDto> getCalist(int canum) {
		return dao.getCalist(canum);
	}


	@Override
	public boolean uploadMarket(MarketDto dto) {
		return dao.uploadMarket(dto);
	}


	@Override
	public MarketDto getItem(int itemnum) {
		return dao.getItem(itemnum);
	}

	@Override
	public boolean addCart(CartDto dto) {
		return dao.addCart(dto);
	}


	@Override
	public int getCartCount(String id) {
		return dao.getCartCount(id);
	}


	@Override
	public List<MarketDto> newMarketList() {
		return dao.newMarketList();
	}


	@Override
	public List<MarketDto> getSearchList(MarketParam search) {
		return dao.getSearchList(search);
	}


	@Override
	public List<CartDto> getCartList(String id) {
		return dao.getCartList(id);
	}


	@Override
	public CartDto getCount(int itemnum) {
		return dao.getCount(itemnum);
	}


	@Override
	public boolean delCart(int seq) {
		return dao.delCart(seq);
	}


	@Override
	public boolean itemCountUp(int seq) {
		return dao.itemCountUp(seq);
	}


	@Override
	public boolean itemCountDown(int seq) {
		return dao.itemCountDown(seq);
	}


	@Override
	public boolean delAllItem(String id) {
		return dao.delAllItem(id);
	}


	@Override
	public CartDto getCartItem(int seq) {
		return dao.getCartItem(seq);
	}


	@Override
	public boolean insertIncome(IncomeDto dto) {
		return dao.insertIncome(dto);
	}


	@Override
	public List<IncomeDto> getIncome(String id) {
		return dao.getIncome(id);
	}


	

}
