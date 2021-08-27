package bit.your.prj.dto;

public class RecCommentDto {
	
	private int seq;
	private int bbsid;
	private String id;
	private String rdate;
	private String content;
	private int ref;
	private int step;
	private int depth;
	private int del;
	
	public RecCommentDto() {
		
	}
	
	public RecCommentDto(int seq, int bbsid, String id, String rdate, String content, int ref, int step, int depth,
			int del) {
		super();
		this.seq = seq;
		this.bbsid = bbsid;
		this.id = id;
		this.rdate = rdate;
		this.content = content;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.del = del;
	}

	public RecCommentDto(String id, String rdate, String content) {
		super();
		this.id = id;
		this.rdate = rdate;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public int getBbsid() {
		return bbsid;
	}

	public String getId() {
		return id;
	}

	public String getRdate() {
		return rdate;
	}

	public String getContent() {
		return content;
	}

	public int getRef() {
		return ref;
	}

	public int getStep() {
		return step;
	}

	public int getDepth() {
		return depth;
	}

	public int getDel() {
		return del;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setBbsid(int bbsid) {
		this.bbsid = bbsid;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "RecCommentDto [seq=" + seq + ", bbsid=" + bbsid + ", id=" + id + ", rdate=" + rdate + ", content="
				+ content + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", del=" + del + "]";
	}
	
}
