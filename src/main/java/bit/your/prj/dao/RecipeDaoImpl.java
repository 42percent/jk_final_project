package bit.your.prj.dao;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.LikeDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.RecipeParam;

@Repository
public class RecipeDaoImpl implements RecipeDao {

	@Autowired
	SqlSession session;
	
	String ns = "Recipe.";
	String nn = "RecipeLiked.";
	
	@Override
	public List<RecipeDto> getRecipeList(RecipeParam recipe) {
		return session.selectList(ns + "getRecipeList", recipe);
	}

	@Override
	public boolean uploadRecipe(RecipeDto dto) {
		int n = session.insert(ns + "uploadRecipe", dto);
		return n>0?true:false;
	}
	
	@Override
	public boolean uploadre(RecipeDto dto) {
		int n = session.insert(ns + "uploadre", dto);
		return n>0?true:false;
	}
	
	@Override
	public RecipeDto getRecipe(int seq) {
		return session.selectOne(ns + "getRecipe", seq);
	}

	@Override
	public int getRecCount(RecipeParam recipe) {
		return session.selectOne(ns + "getRecCount", recipe);
	}
	@Override
	public void readCount(int seq) {
		session.update(ns +"readCount", seq);
		
	}

	@Override
	public boolean updaterecipe(RecipeDto dto) {
		int n = session.update(ns + "updaterecipe", dto);
		return n>0?true:false;
	}

	@Override
	public void deleterecipe(int seq) {
		session.update(ns +"deleterecipe", seq);
		
	}

	@Override
	public List<LikeDto> getlist(int seq) {
		return session.selectList(nn +"getlist", seq);
	}

	@Override
	public int getLikeCount(int seq) {
		return session.selectOne(nn + "getLikeCount", seq);
	}

	/////효제추가/////
	@Override
	public List<RecipeDto> myrecipelist(String id) {
		return session.selectList(ns + "myrecipelist", id);
	}

	@Override
	public List<Map<String, Object>> likerecipe(String id) {
		return session.selectList(ns + "likerecipe", id);
	}
	




}
