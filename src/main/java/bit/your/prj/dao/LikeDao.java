package bit.your.prj.dao;

import bit.your.prj.dto.LikeDto;

public interface LikeDao {
	
	void heartx(LikeDto dto);
	
	void heart(LikeDto dto);
	
	void likeup(int seq_recipe);
	void likedown(int seq_recipe);
}
