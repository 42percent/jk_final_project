package bit.your.prj.dto;

public class CMCDto {
	
	private int seq;
	private String nickname;
	private int seq_class;
	private String rdate;
	private String content;
	private int ref;
	private int step;
	private int depth;
	private int del;
	
	public CMCDto() {
		super();
	}

	public CMCDto(int seq, String nickname, int seq_class, String rdate, String content, int ref, int step, int depth,
			int del) {
		super();
		this.seq = seq;
		this.nickname = nickname;
		this.seq_class = seq_class;
		this.rdate = rdate;
		this.content = content;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.del = del;
	}

	public CMCDto(String nickname, int seq_class, String content) {
		super();
		this.nickname = nickname;
		this.seq_class = seq_class;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSeq_class() {
		return seq_class;
	}

	public void setSeq_class(int seq_class) {
		this.seq_class = seq_class;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "ComentCDto [seq=" + seq + ", nickname=" + nickname + ", seq_class=" + seq_class + ", rdate=" + rdate
				+ ", content=" + content + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", del=" + del
				+ "]";
	}

}
