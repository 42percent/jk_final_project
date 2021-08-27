package bit.your.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.CalendarDao;
import bit.your.prj.dto.CalendarDto;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	CalendarDao dao;

	@Override
	public List<CalendarDto> getCalendar(CalendarDto dto) {
		return dao.getCalendar(dto);
	}

	@Override
	public boolean writeCalendar(CalendarDto dto) {
		return dao.writeCalendar(dto);
	}

	@Override
	public void deleteCalendar(CalendarDto dto) {
		dao.deleteCalendar(dto);
	}
}
