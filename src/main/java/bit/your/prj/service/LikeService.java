package bit.your.prj.service;

import bit.your.prj.dto.LikeDto;

public interface LikeService {

	void heartx(LikeDto dto);
		
	void heart(LikeDto dto);
	
	void likeup(int seq_recipe);
	void likedown(int seq_recipe);
}
