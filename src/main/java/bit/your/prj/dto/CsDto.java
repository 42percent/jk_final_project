package bit.your.prj.dto;

import java.io.Serializable;

public class CsDto implements Serializable {
	
	private int seq; // 글번호
	private String id; // 작성자 id
	
	private int ref; // 그룹번호 - 글과 답글번호 묶음
	private int step; // 행번호 - 답글번호 - 새로 달린 글일수록 낮은 번호를 가짐
	private int depth; // 깊이 - 들여쓰기 - 우너글의답글은 깊이가 1, 답글의 답글은 깊이가 2가 되는 방식
	
	private String title; // 글제목
	private String content; // 글내용
	private String rdate; // 작성날짜
	private int type; // default:0 / 공지:1
	
	private int del; // 삭제 
	private int readcount; // 조회수
	
	public CsDto() {
	}

	public CsDto(int seq, String id, int ref, int step, int depth, String title, String content, String rdate, int type,
			int del, int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.type = type;
		this.del = del;
		this.readcount = readcount;
	}

	public CsDto(String id, String title, String content, int type) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "CsDto [seq=" + seq + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", title="
				+ title + ", content=" + content + ", rdate=" + rdate + ", type=" + type + ", del=" + del
				+ ", readcount=" + readcount + "]";
	}
	
	
	
	

}
