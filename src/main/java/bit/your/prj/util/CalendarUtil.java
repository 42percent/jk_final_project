package bit.your.prj.util;

import java.sql.Date;
import java.util.List;

import bit.your.prj.dto.CalendarDto;

public class CalendarUtil {

		
	// 한문자를 두문자로 변경해 주는 함수	2021 03 19	-> 1 ~ 9 -> 01 ~ 09
	public static String two(String msg) {
		return msg.trim().length()<2?"0"+msg.trim():msg.trim();
	}
	
	// nvl 함수 : 문자열이 비어 있는지 확인 함수
	public static boolean nvl(String msg) {
		return msg == null || msg.trim().equals("")?true:false;
	}
	
	// 달력의 날짜 별로 설정할 테이블을 작성하는 함수
	public static String makeTable(int year, int month, int day, List<CalendarDto> list) {
		String str = "";
		
		// 2021 3 19	-> 20210319
		String dates = (year + "") + two(month + "") + two(day + "");
		
		str += "<table class='innerTable'>";
		str += "<col width='100px'/>";
		
		for(CalendarDto dto : list) {
			if(dto.getCdate().substring(0, 8).equals(dates)) {
				str += "<tr>";
				str += "<td>";
				str += "<a href='ccdetail.do?seq=" + dto.getSeq_class() + "'>";
				str += "<font style='font-size:16px;color:black;text-decoration: none;'>";
				str += dot3(dto.getTitle());
				str += "</font>";
				str += "</a>";
				str += "</td>";
				str += "</tr>";
			}			
		}
		
		str += "</table>";
		
		return str;
	}
	
	public static String yyyymm(int year, int month) {
		return "" + year + two(month + "");
	}
	
	public static String yyyymmdd(int year, int month, int day) {
		return "" + year + two(month + "") + two(day + "");
	}
	
	public static String yyyymmddhhmm(int year, int month, int day, int hour, int min) {		
		return yyyymmdd(year, month, day) + two(hour + "") + two(min + "");		
	}
	
	// 일정의 제목이 길 때 ...로 처리하는 함수		CGV에서 데이트 약속 -> CGV에서... 
	public static String dot3(String msg) {
		String str = "";
		if(msg.length() >= 7) {
			str = msg.substring(0, 7);
			str += "...";
		}else {
			str = msg.trim();
		}		
		return str;
	}
	
	// 2021-04-26 -> java.sql.Date로 변경
	public static Date toDate(int year, int month, int day) {
		String s = year + "-" + two(month + "") + "-" + two(day + "");
		Date d = Date.valueOf(s);
		return d;
	}
	
	public static int Switch(char cday) {
		int dayNum = 0;
		switch (cday) {
		case '일':
			dayNum = 1;
			return dayNum;
		case '월':
			dayNum = 2;
			return dayNum;
		case '화':
			dayNum = 3;
			return dayNum;
		case '수':
			dayNum = 4;
			return dayNum;
		case '목':
			dayNum = 5;
			return dayNum;
		case '금':
			dayNum = 6;
			return dayNum;	
		case '토':
			dayNum = 7;
			return dayNum;	
		}
		return dayNum;
	}
	
}











