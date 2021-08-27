package bit.your.prj.param;

public class ClassParam {
	private String search;
	private String choice;
	private int pageNumber;
	
	private int start;
	private int end;
	private String check;
	private String category;
	
	public ClassParam() {
	}
	
	public ClassParam(String search, String choice, int pageNumber, int start, int end, String check, String category) {
		super();
		this.search = search;
		this.choice = choice;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
		this.check = check;
		this.category = category;
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

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ClassParam [search=" + search + ", choice=" + choice + ", pageNumber=" + pageNumber + ", start=" + start
				+ ", end=" + end + ", check=" + check + ", category=" + category + "]";
	}

}