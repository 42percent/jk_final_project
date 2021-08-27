package bit.your.prj.visit;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class VisitCountDao {
	
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Vi.";
	
	public int insertVisitor(VisitCountDto dto) {
		
		System.out.print("dao visit = " + dto);
		return session.insert(ns+"VisitCountDao", dto);
	}
}