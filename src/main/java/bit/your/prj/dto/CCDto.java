package bit.your.prj.dto;

import java.io.Serializable;

public class CCDto implements Serializable{
/*
DROP TABLE COOKCLASS
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_COOKCLASS;

CREATE TABLE COOKCLASS(
SEQ NUMBER(10) PRIMARY KEY,	
NICKNAME VARCHAR2(50) NOT NULL,	-- 작성자 닉네임
TITLE VARCHAR2(50) NOT NULL, --클래스 이름
LOCATION VARCHAR2(100) NOT NULL, --클래스 장소
KINDS VARCHAR2(40) NOT NULL, --클래스 카테고리
READCOUNT NUMBER(10) NOT NULL, --조회수
MEMBERCOUNT NUMBER(10) NOT NULL, --회원수
CONTENT VARCHAR2(4000) NOT NULL, --상세내용
MEMBERNUM NUMBER(10) NOT NULL, --모집인원수
RDATE DATE NOT NULL,	--작성날짜
EDATE DATE NOT NULL, --마감날짜
CDATE DATE NOT NULL, -- 클래스 시작날짜
FILENAME VARCHAR2(50) NOT NULL, --원본파일 이름
NEWFILENAME VARCHAR2(50) NOT NULL, --변형파일 이름
DEL NUMBER(10) NOT NULL --삭제 유무 기본 0 삭제 1
);

CREATE SEQUENCE SEQ_COOKCLASS
START WITH 1
INCREMENT BY 1;

ALTER TABLE COOKCLASS
ADD CONSTRAINT FK_COOKCLASS_NICKNAME FOREIGN KEY (NICKNAME)
REFERENCES MEMBER(NICKNAME);
*/

	private int seq; 			//글 시퀀스
	private String nickname; 	//글 작성자
	private String title;		//글 제목
	private String location;	//수업 장소
	private String kinds;		//분류
	private int readcount;		//조회수
	private int membercount;	//회원정보 수
	private String content;		//글 내용
	private String membernum; 	//모집인원
	private String rdate;		//작성날짜
	private String edate;		//접수 마감날짜
	private String cdate1;		//수업 시작
	private String cdate2;		//수업 마지막
	private String cday;
	private String filename;	//원본 파일이름
	private String newfilename;	//저장 파일이름
	private int del;  			//삭제 유무 기본 0 삭제 1  
	
	public CCDto() {
	}

	public CCDto(int seq, String nickname, String title, String location, String kinds, int readcount, int membercount,
			String content, String membernum, String rdate, String edate, String cdate1, String cdate2, String cday,
			String filename, String newfilename, int del) {
		super();
		this.seq = seq;
		this.nickname = nickname;
		this.title = title;
		this.location = location;
		this.kinds = kinds;
		this.readcount = readcount;
		this.membercount = membercount;
		this.content = content;
		this.membernum = membernum;
		this.rdate = rdate;
		this.edate = edate;
		this.cdate1 = cdate1;
		this.cdate2 = cdate2;
		this.cday = cday;
		this.filename = filename;
		this.newfilename = newfilename;
		this.del = del;
	}

	public CCDto(String nickname, String title, String location, String kinds, String content, String membernum,
			String edate, String cdate1, String cdate2, String cday, String filename, String newfilename) {
		super();
		this.nickname = nickname;
		this.title = title;
		this.location = location;
		this.kinds = kinds;
		this.content = content;
		this.membernum = membernum;
		this.edate = edate;
		this.cdate1 = cdate1;
		this.cdate2 = cdate2;
		this.cday = cday;
		this.filename = filename;
		this.newfilename = newfilename;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getMembercount() {
		return membercount;
	}

	public void setMembercount(int membercount) {
		this.membercount = membercount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMembernum() {
		return membernum;
	}

	public void setMembernum(String membernum) {
		this.membernum = membernum;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getCdate1() {
		return cdate1;
	}

	public void setCdate1(String cdate1) {
		this.cdate1 = cdate1;
	}

	public String getCdate2() {
		return cdate2;
	}

	public void setCdate2(String cdate2) {
		this.cdate2 = cdate2;
	}

	public String getCday() {
		return cday;
	}

	public void setCday(String cday) {
		this.cday = cday;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "CCDto [seq=" + seq + ", nickname=" + nickname + ", title=" + title + ", location=" + location
				+ ", kinds=" + kinds + ", readcount=" + readcount + ", membercount=" + membercount + ", content="
				+ content + ", membernum=" + membernum + ", rdate=" + rdate + ", edate=" + edate + ", cdate1=" + cdate1
				+ ", cdate2=" + cdate2 + ", cday=" + cday + ", filename=" + filename + ", newfilename=" + newfilename
				+ ", del=" + del + "]";
	}
	
}