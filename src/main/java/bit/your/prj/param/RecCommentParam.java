package bit.your.prj.param;

public class RecCommentParam {
	
	private int pageNumber;
	private int start;
	private int end;

	
	public RecCommentParam() {
		
	}


	public RecCommentParam(int pageNumber, int start, int end) {
		super();
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
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
		return "RecCommentParam [pageNumber=" + pageNumber + ", start=" + start + ", end=" + end + "]";
	}


	
}