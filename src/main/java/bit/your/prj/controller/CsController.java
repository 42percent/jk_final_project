package bit.your.prj.controller;

import java.util.Date;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.your.prj.dto.CsDto;
import bit.your.prj.param.Param;
import bit.your.prj.service.CsService;

@Controller
public class CsController {
	
	static Logger log = LoggerFactory.getLogger(CsController.class);
	
	@Autowired
	CsService service;
	
	
	@RequestMapping(value = "cslist.do", method = RequestMethod.GET)
	public String cslist(Model model, Param param) {
			log.info("CsController cslist() " + new Date());
			
			int sn = param.getPageNumber();	// 0 1 2 3 4
			int start = 1 + sn * 10;	// 1  11
			int end = (sn + 1) * 10;	// 10 20 
			
			param.setStart(start);
			param.setEnd(end);
			
			List<CsDto> list = service.getCslist(param);
			model.addAttribute("csbbslist", list);
			
			int totalCount = service.getCsCount(param);
			model.addAttribute("totalCount", totalCount);
			
			model.addAttribute("pageNumber", param.getPageNumber() + 1);
			
			model.addAttribute("search", param.getSearch());
			model.addAttribute("choice", param.getChoice());
					
			return "cslist.tiles";
		}
	
	// 글쓰기
	@RequestMapping(value = "cswrite.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String csswrite(Model model) {	
		log.info("CsController cswrite() " + new Date());
		model.addAttribute("doc_title", "글쓰기");
		
		return "cswrite.tiles";
	}
	
	@RequestMapping(value = "cswriteAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String cswriteAf(CsDto cs, Model model) throws Exception {
		log.info("CsController cswriteAf() " + new Date());
		if(cs.getContent().equals("") || cs.getTitle().equals("")){
			return "cswrite.tiles";
		}
		service.writeCs(cs);
		return "redirect:/cslist.do";
	}
	
	// 디테일뷰
	@RequestMapping(value = "csdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq, Model model) {		
		model.addAttribute("doc_title", "상세글 보기");
		
		service.readCount(seq);	// 조회수 증가		
		
		CsDto cs = service.getCsBbs(seq);
		model.addAttribute("cs", cs);
		
		return "csdetail.tiles";
	}
	
	//삭제
	@RequestMapping(value = "csdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs(int seq, Model model) {		
		service.deleteBbs(seq);
		return "redirect:/cslist.do";		
	}
	
	//수정
	@RequestMapping(value = "csupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(int seq, Model model){	
		model.addAttribute("doc_title", "글수정");
		
		CsDto cs = service.getCsBbs(seq);		
		model.addAttribute("cs", cs);	
		
		return "csupdate.tiles";
	}
	
	@RequestMapping(value = "csupdateAf.do", method = RequestMethod.POST)
	public String bbsupdateAf(CsDto cs,Model model) {		
		service.updateBbs(cs);
		return "redirect:/cslist.do";
	}
	//답글
	@RequestMapping(value = "answer.do", method = RequestMethod.GET)
	public String answer(int seq, Model model) {
		
		model.addAttribute("doc_title", "답글추가");
		
		CsDto cs = service.getCsBbs(seq);
		model.addAttribute("cs", cs);
		
		return "answer.tiles";
	}
	
	@RequestMapping(value = "answerAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String answerAf(CsDto cs, Model model) {
		boolean b = service.reply(cs);
		return "redirect:/cslist.do";
	}
}
