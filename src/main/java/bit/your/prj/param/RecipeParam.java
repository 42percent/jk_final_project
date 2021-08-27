package bit.your.prj.param;

public class RecipeParam {
	
	private String search;
	private String choice;
	private int pageNumber;
	
	private int start;
	private int end;
	
	public RecipeParam() {
	}

	public RecipeParam(String search, String choice, int pageNumber, int start, int end) {
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

	public String getChoice() {
		return choice;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "RecipeParam [search=" + search + ", choice=" + choice + ", pageNumber=" + pageNumber + ", start="
				+ start + ", end=" + end + "]";
	}
	
	
}
