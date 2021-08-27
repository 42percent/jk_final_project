package bit.your.prj.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bit.your.prj.util.PdsUtil;
import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.CMDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.param.ClassParam;
import bit.your.prj.service.CCService;

@Controller
public class CCController {
	
	@Autowired
	CCService service;
	
	/*
	@RequestMapping(value = "cclist.do", method = RequestMethod.GET) 
	public String cclist(Model model) {
		model.addAttribute("doc_title", "글목록");
		
		List<CCDto> list = service.getCClist();
		model.addAttribute("cclist", list);
		
		return "cclist.tiles";
	}
	*/
	
	@RequestMapping(value = "cclist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String cclist(Model model, ClassParam param, HttpServletRequest request) { 
		model.addAttribute("doc_title", "글목록");
	 	
		int sn = param.getPageNumber(); 
	 	int start = 1 + sn * 12; 
	 	int end = (sn + 1) * 12;
	 	
	  	param.setStart(start); 
	  	param.setEnd(end);
		
	 	List<CCDto> list = service.getCClist(param);
	 	model.addAttribute("cclist", list);
	 
	 	MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		String nickname = login.getNickname();
		List<Map<String, Object>> list2 = service.getNickNameCM(nickname);
		//System.out.println("list2>>>" + list2);
		model.addAttribute("cmlist", list2);
		
	  	int totalCount = service.getCCCount(param); 
	  	model.addAttribute("totalCount", totalCount);
	    model.addAttribute("pageNumber", param.getPageNumber() + 1);
	    
	    model.addAttribute("check", param.getCheck());
	 	model.addAttribute("search", param.getSearch()); 
	 	model.addAttribute("choice", param.getChoice());
	 	model.addAttribute("category", param.getCategory());
	  	
	 	return "cclist.tiles"; 
	 }
	 
	@RequestMapping(value = "ccwrite.do", method = RequestMethod.GET)
	public String ccwrite(Model model) {
		model.addAttribute("doc_title", "자료 올리기");
		
		return "ccwrite.tiles";
	}
	
	@RequestMapping(value = "ccupload.do", method = RequestMethod.POST)
	public String ccupload(CCDto ccdto,
							@RequestParam("sample2_address") String location1,
							@RequestParam("sample2_detailAddress") String location2,
							//@RequestParam("cdate1") String cdate1,
							//@RequestParam("cdate2") String cdate2,
							@RequestParam(value = "fileload", required = false)
							MultipartFile fileload,
							HttpServletRequest req){
		
		//주소합치기
		String location = location1 + ", " + location2;
		ccdto.setLocation(location);
		
		//ccdto.setCdate1(cdate1);
		//ccdto.setCdate2(cdate2);
		
		// filename(원본) 취득
		String filename = fileload.getOriginalFilename();
		ccdto.setFilename(filename);	// DB에 저장하기 위해서 원파일명을 넣어 준다
		
		// upload 경로설정
		// server
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
	//	String fupload = "d:\\tmp";
		
		System.out.println("fupload:" + fupload);
		
		// 파일명 변경
		String newfilename = PdsUtil.getNewFileName(ccdto.getFilename());
		ccdto.setNewfilename(newfilename);
		
		File file = new File(fupload + "/" + newfilename);
		
		try {
			// 실제로 업로드
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			// DB에 저장
			service.uploadCC(ccdto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/cclist.do";
	}
	
	@RequestMapping(value = "ccdetail.do", method = {RequestMethod.GET, RequestMethod.POST}) 
	public String ccdetail(int seq, Model model, HttpServletRequest request) {
		model.addAttribute("doc_title", "상세글 보기");
			  
		service.readCount(seq); // 조회수 증가
			  
		CCDto cc = service.getCC(seq); 
		model.addAttribute("cc", cc);
		
		int count = service.getCMCount(seq);
		model.addAttribute("cmc", count);
		
		
		List<CMDto> list = service.getCM(seq);
		model.addAttribute("cmlist", list);
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		String nickname = login.getNickname();
		boolean check = list.toString().contains(nickname);
		model.addAttribute("check", check);
		
		return "ccdetail.tiles"; 
	}
	
	@RequestMapping(value = "ccdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(int seq, Model model) {		
		service.deleteCC(seq);
		return "redirect:/cclist.do";		
	}

	@RequestMapping(value = "ccupdate.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String ccupdate(int seq, Model model) {
		model.addAttribute("doc_title", "자료 수정");
		
		// dto 취득
		CCDto ccdto = service.getCC(seq);
		model.addAttribute("cc", ccdto);
		
		return "ccupdate.tiles";
	}
	
	@RequestMapping(value = "ccupdateAf.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String ccupdateAf(	CCDto ccdto, 
								String namefile,	// 기존의 파일 명,
								String newnamefile,
								HttpServletRequest req,
								@RequestParam("sample2_address") String location1,
								@RequestParam("sample2_detailAddress") String location2,
								@RequestParam(value = "fileload", required = false)MultipartFile fileload) {
		
		//주소합치기
		String location = location1 + ", " + location2;
		ccdto.setLocation(location);
		System.out.println(location.toString());

		ccdto.setFilename(fileload.getOriginalFilename());
		
		// 파일 경로
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 수정할 파일이 있음
		if(ccdto.getFilename() != null && !ccdto.getFilename().equals("")) {
			
			String f = ccdto.getFilename();
			String newfilename = PdsUtil.getNewFileName(f);
			
			ccdto.setFilename(f);
			ccdto.setNewfilename(newfilename);
			
			File file = new File(fupload + "/" + newfilename);			
			
			try {
				// 실제 업로드
				FileUtils.writeByteArrayToFile(file, fileload.getBytes());
				
				// DB 갱신
				service.updateCC(ccdto);		
				
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}
		else {	// 수정할 파일 없음
			
			// 기존의 파일명으로 설정
			ccdto.setFilename(namefile);
			
			ccdto.setNewfilename(newnamefile);
			
			// DB
			service.updateCC(ccdto);	
		}
		
		return "redirect:/cclist.do";
	}
	
	@RequestMapping(value = "enterCM.do", method = RequestMethod.GET)
	public String enterCM(Model model, CMDto dto,
									@RequestParam("seq_class") int seq_class,
									@RequestParam("nickname") String nickname,
									@RequestParam("gender") String gender) {		
		model.addAttribute("doc_title", "참여하기");
		dto.setSeq_class(seq_class);
		dto.setNickname(nickname);
		dto.setGender(gender);
		//System.out.println(dto.toString());
		
		service.memberCount(seq_class);
		
		boolean b = service.enterCM(dto);
		
		if(b) {
			System.out.println("성공");
			return "cclist.tiles";
		}
		System.out.println("실패");
			return "cclist.tiles";
	}
	
	@RequestMapping(value="resignCM.do", method = RequestMethod.GET)
	public String resignCM(Model model, CMDto dto,
						 @RequestParam("seq_class") int seq_class,
						 @RequestParam("nickname") String nickname) {
		model.addAttribute("doc_title", "탈퇴하기");
		
		dto.setSeq_class(seq_class);
		dto.setNickname(nickname);
		
		service.memberCountDown(seq_class);
		
		service.resignCM(dto);
		
		return "cclist.tiles";
	}
	
	/////////효제추가/////////
	@RequestMapping(value="managing_cc.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String managing_cc(Model model, HttpServletRequest request) throws Exception {
	    
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
	    String nickname = login.getNickname();
		
	 	List<CCDto> list = service.mycclist(nickname); 
	 	System.out.println(nickname);
	 	
	 	model.addAttribute("mycclist", list);
	 	System.out.println(list);
	 	

		return "managing_cc.tiles";
	
	}
	
	@RequestMapping(value="mycc.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String myclass(Model model, HttpServletRequest request) throws Exception {
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
	    String nickname = login.getNickname();
	    
	    List<Map<String, Object>> list = service.myclass(nickname); 
	 	System.out.println(nickname);
	 	
	 	
	 	model.addAttribute("myclass", list);
	 	System.out.println(list);
		
		return "mycc.tiles";
	}
	
}
