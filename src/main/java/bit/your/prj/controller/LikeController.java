package bit.your.prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import bit.your.prj.dto.LikeDto;
import bit.your.prj.service.LikeService;

@Controller
public class LikeController {

	@Autowired
	LikeService service;

	@RequestMapping(value="heartx.do", method = RequestMethod.GET)
		public String heartx(Model model, LikeDto dto,
					@RequestParam("seq_recipe") int seq_recipe,
					@RequestParam("id") String id) {
		
		dto.setSeq_recipe(seq_recipe);
		dto.setId(id);
		service.heartx(dto);
		service.likedown(seq_recipe);
		
		return "redetail.tiles";
	}
	
	@RequestMapping(value = "heart.do", method = RequestMethod.GET)
		public String heart(Model model, LikeDto dto,
					@RequestParam("seq_recipe") int seq_recipe,
					@RequestParam("id") String id) {
		
		dto.setSeq_recipe(seq_recipe);
		dto.setId(id);
		service.heart(dto);
		service.likeup(seq_recipe);
		
		return "redetail.tiles";
	}
}










