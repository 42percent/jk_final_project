package bit.your.prj.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.your.prj.dto.RecCommentDto;
import bit.your.prj.param.RecCommentParam;
import bit.your.prj.service.RecCommentService;

@RestController
//@RequestMapping(value = "/restBoard")
public class RecCommentController {
	
	@Inject
	private RecCommentService reccommentservice;
	
	@RequestMapping(value = "getReqlyList.do", method = RequestMethod.POST)
		public List<RecCommentDto> reccommentlist(Model model, RecCommentParam param, @RequestParam("bbsid") int bbsid)throws Exception{
		//public List<RecCommentDto> reccommentlist(@RequestParam("bbsid") int bbsid)throws Exception{
		
			int sn = param.getPageNumber();	// 0 1 2 3 4
			int start = 1 + sn * 10;	// 1  11
			int end = (sn + 1) * 10;	// 10 20 
			
			param.setStart(start);
			param.setEnd(end);
		
			int totalCount = reccommentservice.reccommentcount(bbsid);
			model.addAttribute("comtotalCount", totalCount);
			System.out.println("comtotalCount:" + totalCount);
			model.addAttribute("compageNumbe", param.getPageNumber());
			System.out.println("gggggggggg"+ reccommentservice.reccommentlist(bbsid).toString());
			return reccommentservice.reccommentlist(bbsid);
	}
	
	/*
	 * @RequestMapping(value = "commentpaging.do", method = RequestMethod.POST)
	 * public List<RecCommentParam> commentpaging(Model model, RecCommentParam
	 * param, @RequestParam("bbsid") int bbsid)throws Exception{
	 * System.out.println(param.getPageNumber()); int sn = param.getPageNumber(); //
	 * 0 1 2 3 4 int start = 1 + sn * 10; // 1 11 int end = (sn + 1) * 10; // 10 20
	 * 
	 * param.setBbsid(bbsid); param.setStart(start); param.setEnd(end);
	 * //System.out.println(param.getStart()); int totalCount =
	 * reccommentservice.reccommentcount(bbsid);
	 * //System.out.println("ddddddddddddddddddddddddd" + start);
	 * param.setComtotal(totalCount);
	 * //System.out.println("ggggggggggggggggggggggggggggggggggggggggggg" +
	 * reccommentservice.reccomment(param).toString()); return
	 * reccommentservice.reccomment(param); }
	 */
	
	
	@RequestMapping(value = "saveReqly.do", method = RequestMethod.POST)
	public Map<String, Object> saveReply(@RequestBody RecCommentDto reccommentDto) throws Exception {
		Map<String, Object> result = new HashMap<>();		
		
		try {			
			reccommentservice.reccommentadd(reccommentDto);
			result.put("status", "OK");
			
		} catch (Exception e) {			
			e.printStackTrace();
			result.put("status", "False");
		}

		return result;
	}
	@RequestMapping(value = "rereply.do", method = RequestMethod.POST)
	public Map<String, Object> rereply(@RequestBody RecCommentDto reccommentDto) throws Exception {
		Map<String, Object> result = new HashMap<>();	
		
		try {			
			reccommentservice.rereply(reccommentDto);
			result.put("status", "OK");
			
		} catch (Exception e) {			
			e.printStackTrace();
			result.put("status", "False");
		}

		return result;
	}
	
	@RequestMapping(value = "updateReply.do", method = {RequestMethod.GET, RequestMethod.POST})

	public Map<String, Object> updateReply(@RequestBody RecCommentDto reccommentDto) throws Exception {

	Map<String, Object> result = new HashMap<>();
		try {
			reccommentservice.updatereccomment(reccommentDto);
			result.put("status", "OK");
	
		} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "False");
		}
		return result;
	}
	
	@RequestMapping(value = "updatere.do", method = {RequestMethod.GET, RequestMethod.POST})

	public Map<String, Object> updatere(@RequestBody RecCommentDto reccommentDto) throws Exception {

	Map<String, Object> result = new HashMap<>();
		try {
			reccommentservice.updatere(reccommentDto);
			result.put("status", "OK");
	
		} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "False");
		}
		return result;
	}
	
	
	@RequestMapping(value = "deleteReply.do", method = {RequestMethod.GET, RequestMethod.POST})

	public Map<String, Object> deleteReply(@RequestParam("seq") int seq) throws Exception {

	Map<String, Object> result = new HashMap<>();
		try {
			reccommentservice.deletereccomment(seq);
			result.put("status", "OK");
	
		} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "False");
		}
		return result;
	}
	
}






















