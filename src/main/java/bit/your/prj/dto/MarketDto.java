package bit.your.prj.dto;


public class MarketDto {

	private int seq;
	private int canum;
	private String subca;
	private int itemnum;
	private String title;
	private String subtitle;
	private int price;
	private String gram;
	private String country;
	private String expiration;
	private int count;
	private String content;
	private String mainpt;
	private String newmainpt;
	private int rvcount;
	private String rdate;
	

	public MarketDto() {}

	
	
	public MarketDto(String subca, String title, String content) {
		super();
		this.subca = subca;
		this.title = title;
		this.content = content;
	}



	public MarketDto(int canum,String subca, String title, String subtitle, int price, String gram, String country,
			String expiration, String content, String mainpt, String newmainpt) {
		super();
		this.canum = canum;
		this.subca = subca;
		this.title = title;
		this.subtitle = subtitle;
		this.price = price;
		this.gram = gram;
		this.country = country;
		this.expiration = expiration;
		this.content = content;
		this.mainpt = mainpt;
		this.newmainpt = newmainpt;
	}





	public MarketDto(int seq, int canum, String subca, int itemnum, String title, String subtitle, int price, String gram,
			String country, String expiration, int count, String content, String mainpt, String newmainpt, int rvcount,
			String rdate) {
		
		super();
		this.seq = seq;
		this.canum = canum;
		this.subca = subca;
		this.itemnum = itemnum;
		this.title = title;
		this.subtitle = subtitle;
		this.price = price;
		this.gram = gram;
		this.country = country;
		this.expiration = expiration;
		this.count = count;
		this.content = content;
		this.mainpt = mainpt;
		this.newmainpt = newmainpt;
		this.rvcount = rvcount;
		this.rdate = rdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getCanum() {
		return canum;
	}

	public void setCanum(int canum) {
		this.canum = canum;
	}
	

	public String getSubca() {
		return subca;
	}


	public void setSubca(String subca) {
		this.subca = subca;
	}


	public int getItemnum() {
		return itemnum;
	}

	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGram() {
		return gram;
	}

	public void setGram(String gram) {
		this.gram = gram;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMainpt() {
		return mainpt;
	}

	public void setMainpt(String mainpt) {
		this.mainpt = mainpt;
	}

	public String getNewmainpt() {
		return newmainpt;
	}

	public void setNewmainpt(String newmainpt) {
		this.newmainpt = newmainpt;
	}

	public int getRvcount() {
		return rvcount;
	}

	public void setRvcount(int rvcount) {
		this.rvcount = rvcount;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}


	@Override
	public String toString() {
		return "MarketDto [seq=" + seq + ", canum=" + canum + ", subca=" + subca + ", itemnum=" + itemnum + ", title="
				+ title + ", subtitle=" + subtitle + ", price=" + price + ", gram=" + gram + ", country=" + country
				+ ", expiration=" + expiration + ", count=" + count + ", content=" + content + ", mainpt=" + mainpt
				+ ", newmainpt=" + newmainpt + ", rvcount=" + rvcount + ", rdate=" + rdate + "]";
	}



	
	
	
}
