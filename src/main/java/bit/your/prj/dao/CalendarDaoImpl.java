package bit.your.prj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.CalendarDto;

@Repository
public class CalendarDaoImpl implements CalendarDao {

	@Autowired
	SqlSession session;
	
	String ns = "Cal.";

	@Override
	public List<CalendarDto> getCalendar(CalendarDto dto) {
		return session.selectList(ns + "getCalendar", dto); 
	}

	@Override
	public boolean writeCalendar(CalendarDto dto) {
		int n = session.insert(ns + "writeCalendar", dto);
		return n>0?true:false;
	}

	@Override
	public void deleteCalendar(CalendarDto dto) {
		session.delete(ns + "deleteCalendar", dto);
	}
	
	
}
