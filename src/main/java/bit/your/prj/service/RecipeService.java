package bit.your.prj.service;

import java.util.List;
import java.util.Map;


import bit.your.prj.dto.LikeDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.RecipeParam;

public interface RecipeService {
	
	List<RecipeDto> getRecipeList(RecipeParam recipe);
	int getRecCount(RecipeParam recipe);
	
	boolean uploadRecipe(RecipeDto dto);
	
	boolean uploadre(RecipeDto dto);
	
	RecipeDto getRecipe(int seq);
	
	void readCount(int seq);
	
	boolean updaterecipe(RecipeDto dto);
	
	void deleterecipe(int seq);
	
	
	
	List<LikeDto> getlist(int seq);
	
	int getLikeCount(int seq);
	
	
	////효제추가////
	List<RecipeDto> myrecipelist(String id);
	List<Map<String, Object>> likerecipe(String id);
}
