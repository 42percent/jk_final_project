package bit.your.prj.param;

import java.io.Serializable;

public class Param implements Serializable{
	private String search; //검색
	private String choice; //선택
	private int pageNumber; //페이징넘버
	
	private int start; 
	private int end;
	
	public Param() {
	}

	public Param(String search, String choice, int pageNumber, int start, int end) {
		super();
		this.search = search;
		this.choice = choice;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Param [search=" + search + ", choice=" + choice + ", pageNumber=" + pageNumber + ", start=" + start
				+ ", end=" + end + "]";
	}

}
