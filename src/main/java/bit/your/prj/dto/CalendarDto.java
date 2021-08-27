package bit.your.prj.dto;

import java.io.Serializable;

/*
DROP TABLE CALENDAR
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_CALENDAR;

CREATE TABLE CALENDAR(
	SEQ NUMBER(10) PRIMARY KEY,
	NICKNAME VARCHAR2(50) NOT NULL,
	SEQ_CLASS NUMBER(10) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	RDATE DATE NOT NULL,	
	CDATE VARCHAR2(12) NOT NULL
);

CREATE SEQUENCE SEQ_CALENDAR
START WITH 1
INCREMENT BY 1;

ALTER TABLE CALENDAR
ADD CONSTRAINT FK_CALENDAR_SEQ_CLASS FOREIGN KEY (SEQ_CLASS)
REFERENCES COOKCLASS(SEQ);
*/
public class CalendarDto implements Serializable{
	private int seq; 
	private String nickname;
	private int seq_class;
	private String title;
	private String rdate;
	private String cdate;
	
	public CalendarDto() {
		super();
	}

	public CalendarDto(int seq, String nickname, int seq_class, String title, String rdate, String cdate) {
		super();
		this.seq = seq;
		this.nickname = nickname;
		this.seq_class = seq_class;
		this.title = title;
		this.rdate = rdate;
		this.cdate = cdate;
	}

	public CalendarDto(String nickname, int seq_class, String title, String cdate) {
		super();
		this.nickname = nickname;
		this.seq_class = seq_class;
		this.title = title;
		this.cdate = cdate;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "CalendarDto [seq=" + seq + ", nickname=" + nickname + ", seq_class=" + seq_class + ", title=" + title
				+ ", rdate=" + rdate + ", cdate=" + cdate + "]";
	}
	
}
