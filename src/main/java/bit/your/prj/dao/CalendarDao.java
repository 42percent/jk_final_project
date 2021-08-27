package bit.your.prj.dao;

import java.util.List;

import bit.your.prj.dto.CalendarDto;

public interface CalendarDao {

	List<CalendarDto> getCalendar(CalendarDto dto);
	
	boolean writeCalendar(CalendarDto dto);
	
	void deleteCalendar(CalendarDto dto);
}
