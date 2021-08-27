package bit.your.prj.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bit.your.prj.dto.CalendarDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.param.CalendarParam;
import bit.your.prj.service.CalendarService;
import bit.your.prj.util.CalendarUtil;

@Controller
public class CalendarController {

	@Autowired
	CalendarService service;
	
	@RequestMapping(value = "calist.do", method = RequestMethod.GET)
	public String calendarlist(Model model, CalendarParam param, HttpSession session) {
		model.addAttribute("doc_title", "나의수업일정");
		
		Calendar cal = Calendar.getInstance();
		
		int year = param.getYear();
		int month = param.getMonth();
		int day = param.getDay();
		
		if(month == 0) {
			year--;
			month = 12;
		}
		else if(month == 13) {
			year++;
			month = 1;
		}
		else if(month < 0) {	// 처음 들어 온경우
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			if(day < 0) {
				day = cal.get(Calendar.DATE);
			}
		}
		cal.set(year, month - 1, 1);
		
		// 요일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		// 마지막 날짜
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		param.setYear(year);
		param.setMonth(month);
		param.setDay(day);
		param.setDayOfWeek(dayOfWeek);
		param.setLastDay(lastDay);
		
		// 로그인 정보
		String nickname = ((MemberDto)session.getAttribute("login")).getNickname();
		// 날짜 취득
		String yyyymm = CalendarUtil.yyyymm(param.getYear(), param.getMonth());
		
		// DB로부터 그 달의 정보를 취득
		CalendarDto fcal = new CalendarDto();
		fcal.setNickname(nickname);
		fcal.setCdate(yyyymm);
		
		//System.out.println("nickname>>>>>>>>>"  + nickname);
		//System.out.println("yyyymm>>>>>>>>" + yyyymm);
		
		List<CalendarDto> list = service.getCalendar(fcal); 
		System.out.println("callist>>>>>" + list);
		
		model.addAttribute("flist", list);	// 일정목록
		model.addAttribute("cal", param);	// 날짜
		
		return "calist.tiles";		
	}
	
	@RequestMapping(value = "writeCalendar.do", method = RequestMethod.GET)
	public String writeCalendar(Model model, CalendarDto dto,
									@RequestParam("seq_class") int seq_class,
									@RequestParam("nickname") String nickname,
									@RequestParam("title") String title,
									@RequestParam("cdate1") String cdate1,
									@RequestParam("cdate2") String cdate2,
									@RequestParam("cday") String cday) throws ParseException {		
		
		model.addAttribute("doc_title", "일정등록");
		
		//날짜 형식 바꾸기 ex)2021-09-03 -> 20210903 
		//시작날
		String yyyy1 = cdate1.substring(0, 4);
		String mm1 = cdate1.substring(5, 7);
		String dd1 = cdate1.substring(8, 10);
		String cdate3 = yyyy1+ mm1 + dd1;
			
		//마지막날
		String yyyy2 = cdate2.substring(0, 4);
		String mm2 = cdate2.substring(5, 7);
		String dd2 = cdate2.substring(8, 10);
		String cdate4 = yyyy2+ mm2 + dd2;
		
		if(cday.length() > 1) {
			char[] array_word = new char[cday.length()];
			for(int i=0; i<array_word.length; i++){ 
				array_word[i]=(cday.charAt(i));//스트링을 한글자씩 끊어 배열에 저장
				
				List<Integer> days = new ArrayList<Integer>(); //
				days.add(CalendarUtil.Switch(array_word[i]));
				
				Calendar cal = Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				
				String StartDate = cdate3;
				String EndDate = cdate4;
				
				Date d1 = df.parse(StartDate);
				Date d2 = df.parse(EndDate);
				
				ArrayList<String> dates = new ArrayList<String>();
				
				Date currentDate = d1;
				
				while (currentDate.compareTo(d2) <= 0){
					cal.setTime(currentDate);
					int num = cal.get(Calendar.DAY_OF_WEEK);
				
					//시작날이 여러 수업요일에 포함되어있는가? 포함되어있으면 배열추가
					if(days.contains(num)) {
						dates.add(df.format(currentDate));
						cal.add(Calendar.DAY_OF_MONTH, 1);
						currentDate = cal.getTime();
					//다르면 다른날로 넘김
					}else {
						cal.add(Calendar.DAY_OF_MONTH, 1);
						currentDate = cal.getTime();
					}
				}
				
				for (int j = 0; j < dates.size(); j++) {
					//dto에 날짜와 파라미터를 담는다
					List<CalendarDto> list = new ArrayList<CalendarDto>();
					dto.setSeq_class(seq_class);
					dto.setNickname(nickname);
					dto.setTitle(title);
					dto.setCdate(dates.get(j));
					list.add(dto);
					
					//System.out.println("list>>>>>>>>>" + list.toString());
					Map<String, Object> map = new HashMap<>();
					map.put("list", list);
					for(CalendarDto dto1 : list) {
			            service.writeCalendar(dto1);
			        }
				}
			}
		}else {
			char car = cday.charAt(0);
			
			int day = CalendarUtil.Switch(car);
			
			Calendar cal = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			
			//시작일, 끝일
			String StartDate = cdate3;
			String EndDate = cdate4;
			
			Date d1 = df.parse(StartDate);
			Date d2 = df.parse(EndDate);
			
			//날짜들을 담을 배열
			ArrayList<String> dates = new ArrayList<String>();
			
			Date currentDate = d1;
			
			while (currentDate.compareTo(d2) <= 0){
				cal.setTime(currentDate);
				int num = cal.get(Calendar.DAY_OF_WEEK);
				//시작날이 수업요일와 같은가? 같으면 배열추가
				if(num == day) {
					dates.add(df.format(currentDate));
					cal.add(Calendar.DAY_OF_MONTH, 1);
					currentDate = cal.getTime();
				//다르면 다른날로 넘김
				}else {
					cal.add(Calendar.DAY_OF_MONTH, 1);
					currentDate = cal.getTime();
				}
			}
					  	
			for (int i = 0; i < dates.size(); i++) {
				//dto에 날짜와 파라미터를 담는다
				List<CalendarDto> list = new ArrayList<CalendarDto>();
				dto.setSeq_class(seq_class);
				dto.setNickname(nickname);
				dto.setTitle(title);
				dto.setCdate(dates.get(i));
				list.add(dto);
				
				//System.out.println("list>>>>>>>>>" + list.toString());
				Map<String, Object> map = new HashMap<>();
				map.put("list", list);
				for(CalendarDto dto1 : list) {
		            service.writeCalendar(dto1);
		        }
			}	
		}
		return "calist.tiles";	
	}
	
	@RequestMapping(value="deleteCalendar.do", method = RequestMethod.GET)
	public String deleteCalendar(Model model, CalendarDto dto,
						 @RequestParam("seq_class") int seq_class,
						 @RequestParam("nickname") String nickname) {
		
		model.addAttribute("doc_title", "일정삭제");
		
		//System.out.println("seq_class" + seq_class);
		//System.out.println("nickname" + nickname);
		
		dto.setSeq_class(seq_class);
		dto.setNickname(nickname);
			
		service.deleteCalendar(dto);
		
		return "calist.tiles";
	}
	
	@RequestMapping(value = "updateCalendar.do", method= {RequestMethod.GET, RequestMethod.POST})
	public void updateCalendar(Model model, CalendarDto dto,
							@RequestParam("seq_class") int seq_class,
							/* @RequestParam("nickname") String nickname, */
							@RequestParam("title") String title, //바뀐 제목
							@RequestParam("cdate1") String cdate1,
							@RequestParam("cdate2") String cdate2,
							@RequestParam("cday") String cday ) throws ParseException { //바뀐 날짜
		
		model.addAttribute("doc_title", "일정업데이트");
		
		dto.setSeq_class(seq_class);
		
		service.deleteCalendar(dto);
		
		//날짜 형식 바꾸기 ex)2021-09-03 -> 20210903 
		//시작날
		String yyyy1 = cdate1.substring(0, 4);
		String mm1 = cdate1.substring(5, 7);
		String dd1 = cdate1.substring(8, 10);
		String cdate3 = yyyy1+ mm1 + dd1;
			
		//마지막날
		String yyyy2 = cdate2.substring(0, 4);
		String mm2 = cdate2.substring(5, 7);
		String dd2 = cdate2.substring(8, 10);
		String cdate4 = yyyy2+ mm2 + dd2;
		
		if(cday.length() > 1) {
			char[] array_word = new char[cday.length()];
			for(int i=0; i<array_word.length; i++){ 
				array_word[i]=(cday.charAt(i));//스트링을 한글자씩 끊어 배열에 저장
				
				List<Integer> days = new ArrayList<Integer>(); //
				days.add(CalendarUtil.Switch(array_word[i]));
				
				Calendar cal = Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				
				String StartDate = cdate3;
				String EndDate = cdate4;
				
				Date d1 = df.parse(StartDate);
				Date d2 = df.parse(EndDate);
				
				ArrayList<String> dates = new ArrayList<String>();
				
				Date currentDate = d1;
				
				while (currentDate.compareTo(d2) <= 0){
					cal.setTime(currentDate);
					int num = cal.get(Calendar.DAY_OF_WEEK);
				
					//시작날이 여러 수업요일에 포함되어있는가? 포함되어있으면 배열추가
					if(days.contains(num)) {
						dates.add(df.format(currentDate));
						cal.add(Calendar.DAY_OF_MONTH, 1);
						currentDate = cal.getTime();
					//다르면 다른날로 넘김
					}else {
						cal.add(Calendar.DAY_OF_MONTH, 1);
						currentDate = cal.getTime();
					}
				}
				
				for (int j = 0; j < dates.size(); j++) {
					//dto에 날짜와 파라미터를 담는다
					List<CalendarDto> list = new ArrayList<CalendarDto>();
					dto.setSeq_class(seq_class);
					/* dto.setNickname(nickname); */
					dto.setTitle(title);
					dto.setCdate(dates.get(j));
					list.add(dto);
					
					//System.out.println("list>>>>>>>>>" + list.toString());
					Map<String, Object> map = new HashMap<>();
					map.put("list", list);
					for(CalendarDto dto1 : list) {
			            service.writeCalendar(dto1);
			        }
				}
			}
		}else {
			char car = cday.charAt(0);
			
			int day = CalendarUtil.Switch(car);
			
			Calendar cal = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			
			//시작일, 끝일
			String StartDate = cdate3;
			String EndDate = cdate4;
			
			Date d1 = df.parse(StartDate);
			Date d2 = df.parse(EndDate);
			
			//날짜들을 담을 배열
			ArrayList<String> dates = new ArrayList<String>();
			
			Date currentDate = d1;
			
			while (currentDate.compareTo(d2) <= 0){
				cal.setTime(currentDate);
				int num = cal.get(Calendar.DAY_OF_WEEK);
				//시작날이 수업요일와 같은가? 같으면 배열추가
				if(num == day) {
					dates.add(df.format(currentDate));
					cal.add(Calendar.DAY_OF_MONTH, 1);
					currentDate = cal.getTime();
				//다르면 다른날로 넘김
				}else {
					cal.add(Calendar.DAY_OF_MONTH, 1);
					currentDate = cal.getTime();
				}
			}
					  	
			for (int i = 0; i < dates.size(); i++) {
				//dto에 날짜와 파라미터를 담는다
				List<CalendarDto> list = new ArrayList<CalendarDto>();
				dto.setSeq_class(seq_class);
				/* dto.setNickname(nickname); */
				dto.setTitle(title);
				dto.setCdate(dates.get(i));
				list.add(dto);
				
				//System.out.println("list>>>>>>>>>" + list.toString());
				Map<String, Object> map = new HashMap<>();
				map.put("list", list);
				for(CalendarDto dto1 : list) {
		            service.writeCalendar(dto1);
		        }
			}	
		}
	}
}












