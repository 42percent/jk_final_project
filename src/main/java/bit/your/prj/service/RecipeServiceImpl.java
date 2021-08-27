package bit.your.prj.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.LikeDao;
import bit.your.prj.dao.RecipeDao;
import bit.your.prj.dto.LikeDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.RecipeParam;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeDao dao;
	
	
	@Override
	public List<RecipeDto> getRecipeList(RecipeParam recipe) {
		return dao.getRecipeList(recipe);
	}

	@Override
	public boolean uploadRecipe(RecipeDto dto) {
		return dao.uploadRecipe(dto);
	}

	@Override
	public RecipeDto getRecipe(int seq) {
		return dao.getRecipe(seq);
	}

	@Override
	public int getRecCount(RecipeParam recipe) {
		return dao.getRecCount(recipe);
	}
	
	@Override
	public void readCount(int seq) {
		dao.readCount(seq);
		
	}

	@Override
	public boolean updaterecipe(RecipeDto dto) {
		return dao.updaterecipe(dto);
	}

	@Override
	public void deleterecipe(int seq) {
		dao.deleterecipe(seq);
		
	}

	@Override
	public boolean uploadre(RecipeDto dto) {
		return dao.uploadre(dto);
	}

	@Override
	public List<LikeDto> getlist(int seq) {
		return dao.getlist(seq);
	}

	@Override
	public int getLikeCount(int seq) {
		return dao.getLikeCount(seq);
	}
	
	//효제추가//
	@Override
	public List<RecipeDto> myrecipelist(String id) {
		return dao.myrecipelist(id);
	}

	@Override
	public List<Map<String, Object>> likerecipe(String id) {
		return dao.likerecipe(id);
	}
	

}
