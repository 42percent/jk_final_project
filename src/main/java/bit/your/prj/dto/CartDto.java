package bit.your.prj.dto;

import java.io.Serializable;

public class CartDto implements Serializable{

	private int seq;
	private String id;
	private int checknum;
	private int canum;
	private int itemnum;
	private String mainpt;
	private String title;
	private int count;
	private int price;
	private String address;
	
	public CartDto() {}

	public CartDto(int seq, String id, int checknum, int canum, int itemnum, String mainpt, String title, int count,
			int price, String address) {
		super();
		this.seq = seq;
		this.id = id;
		this.checknum = checknum;
		this.canum = canum;
		this.itemnum = itemnum;
		this.mainpt = mainpt;
		this.title = title;
		this.count = count;
		this.price = price;
		this.address = address;
	}
	
	

	public CartDto(String id, int canum, int itemnum, String mainpt, String title, int count, int price,
			String address) {
		super();
		this.id = id;
		this.canum = canum;
		this.itemnum = itemnum;
		this.mainpt = mainpt;
		this.title = title;
		this.count = count;
		this.price = price;
		this.address = address;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getChecknum() {
		return checknum;
	}

	public void setChecknum(int checknum) {
		this.checknum = checknum;
	}

	public int getCanum() {
		return canum;
	}

	public void setCanum(int canum) {
		this.canum = canum;
	}

	public int getItemnum() {
		return itemnum;
	}

	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}

	public String getMainpt() {
		return mainpt;
	}

	public void setMainpt(String mainpt) {
		this.mainpt = mainpt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CartDto [seq=" + seq + ", id=" + id + ", checknum=" + checknum + ", canum=" + canum + ", itemnum="
				+ itemnum + ", mainpt=" + mainpt + ", title=" + title + ", count=" + count + ", price=" + price
				+ ", address=" + address + "]";
	}
	
	
}
