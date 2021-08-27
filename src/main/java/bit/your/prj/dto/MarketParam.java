package bit.your.prj.dto;

import java.io.Serializable;

public class MarketParam implements Serializable{

	private String search;
	
	
	public MarketParam() {}

	
	
	public MarketParam(String search) {
		super();
		this.search = search;
	}



	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}



	@Override
	public String toString() {
		return "MarketParam [search=" + search + "]";
	}

	
	
	
}
