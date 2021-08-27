package bit.your.prj.controller;



import java.io.File;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bit.your.prj.dto.CCDto;
import bit.your.prj.param.ClassParam;
import bit.your.prj.param.Param;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.RecCommentParam;
import bit.your.prj.param.RecipeParam;
import bit.your.prj.service.CCService;
import bit.your.prj.service.HomeService;
import bit.your.prj.service.MarketService;
import bit.your.prj.service.RecipeService;
import bit.your.prj.util.PdsUtil;


@Controller
public class HomeController {
		
	@Autowired
	RecipeService service;
	@Autowired
	HomeService mcservice;
	@Autowired
	CCService ccservice;
	
	@RequestMapping(value = "home.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String home(Model model, RecipeParam  param, ClassParam pa, HttpServletRequest request) {
		model.addAttribute("doc_title", "레시피목록");
		
		/*	레시피	 */	
		int sn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + sn * 4;	// 1  11
		int end = (sn + 1) * 4;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<RecipeDto> list = service.getRecipeList(param);
		model.addAttribute("recipelist", list);
		
		int totalCount = service.getRecCount(param);
		model.addAttribute("totalCount", totalCount);
		
		model.addAttribute("pageNumber", param.getPageNumber()+1);
		
		model.addAttribute("search", param.getSearch());
		model.addAttribute("choice", param.getChoice());
		
		/*	마감임박 쿠킹클래스	 */		
		int ccsn = pa.getPageNumber();	// 0 1 2 3 4
		int ccstart = 1 + ccsn * 2;	// 1  11
		int ccend = (ccsn + 1) * 2;	// 10 20 
		
		pa.setStart(ccstart);
		pa.setEnd(ccend);
		
		List<CCDto> cclist = mcservice.maincclist(pa);
		model.addAttribute("homecclist", cclist);
		System.out.println("ddddddddddddddddddddddddddddd"+cclist.toString());
		
		/*
		 * int cctotalCount = ccservice.getCCCount(pa);
		 * model.addAttribute("cctotalCount", cctotalCount);
		 */
		 
		
		/*	마켓 이미지	 */		

		List<MarketDto> mclist = mcservice.homemclist();
		model.addAttribute("marketlist", mclist);

		return "home.tiles";
	}

	
}
