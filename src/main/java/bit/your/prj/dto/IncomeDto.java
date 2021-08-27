package bit.your.prj.dto;

import java.io.Serializable;

public class IncomeDto implements Serializable{

	private int seq;
	private String ordernum;
	private String title;
	private String mainpt;
	private int price;
	private int count;
	private int canum; // 상품 카테고리 번호
	private String pdate; //결제일
	private String id;
	
	
	public IncomeDto() {}


	public IncomeDto(int seq, String ordernum, String title, String mainpt, int price, int count, int canum,
			String pdate, String id) {
		super();
		this.seq = seq;
		this.ordernum = ordernum;
		this.title = title;
		this.mainpt = mainpt;
		this.price = price;
		this.count = count;
		this.canum = canum;
		this.pdate = pdate;
		this.id = id;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getOrdernum() {
		return ordernum;
	}


	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getMainpt() {
		return mainpt;
	}


	public void setMainpt(String mainpt) {
		this.mainpt = mainpt;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getCanum() {
		return canum;
	}


	public void setCanum(int canum) {
		this.canum = canum;
	}


	public String getPdate() {
		return pdate;
	}


	public void setPdate(String pdate) {
		this.pdate = pdate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "IncomeDto [seq=" + seq + ", ordernum=" + ordernum + ", title=" + title + ", mainpt=" + mainpt
				+ ", price=" + price + ", count=" + count + ", canum=" + canum + ", pdate=" + pdate + ", id=" + id
				+ "]";
	}


	

	
	
	

	
	
	
}
