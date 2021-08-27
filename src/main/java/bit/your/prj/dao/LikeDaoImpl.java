package bit.your.prj.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.LikeDto;

@Repository
public class LikeDaoImpl implements LikeDao{

	@Autowired
	SqlSession session;
	
	String ns = "RecipeLiked.";
	
	
	@Override
	public void heartx(LikeDto dto) {
		session.update(ns +"heartx", dto);
	}
	
	@Override
	public void heart(LikeDto dto) {
		session.insert(ns +"heart", dto);
	}

	@Override
	public void likeup(int seq_recipe) {
		session.update(ns +"likeup", seq_recipe);
		
	}
	
	@Override
	public void likedown(int seq_recipe) {
		session.update(ns +"likedown", seq_recipe);
		
	}
}
