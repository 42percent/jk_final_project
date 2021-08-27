package bit.your.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.LikeDao;
import bit.your.prj.dao.LikeDaoImpl;
import bit.your.prj.dto.LikeDto;

@Service
public class LikeServiceImpl implements LikeService{

	@Autowired
	private LikeDao likedao;

	@Override
	public void heartx(LikeDto dto) {
		likedao.heartx(dto);
	}
	
	@Override
	public void heart(LikeDto dto) {
		likedao.heart(dto);
	}

	@Override
	public void likeup(int seq_recipe) {
		likedao.likeup(seq_recipe);
		
	}
	
	@Override
	public void likedown(int seq_recipe) {
		likedao.likedown(seq_recipe);
		
	}
}
