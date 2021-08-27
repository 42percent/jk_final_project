package bit.your.prj.controller;

import java.io.File;
import java.util.Map;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bit.your.prj.util.PdsUtil;
import bit.your.prj.dto.LikeDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.RecCommentDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.RecipeParam;
import bit.your.prj.service.RecipeService;



@Controller
public class RecipeController {
	
	@Autowired
	RecipeService service;
	
	@RequestMapping(value = "recipe.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String recipelist(Model model, RecipeParam  param) {
		model.addAttribute("doc_title", "레시피목록");
		
		int sn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + sn * 12;	// 1  11
		int end = (sn + 1) * 12;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<RecipeDto> list = service.getRecipeList(param);
		model.addAttribute("recipelist", list);
		
		int totalCount = service.getRecCount(param);
		model.addAttribute("totalCount", totalCount);
		
		model.addAttribute("pageNumber", param.getPageNumber()+1);
		
		model.addAttribute("search", param.getSearch());
		model.addAttribute("choice", param.getChoice());
		
		return "recipelist.tiles";
	}
	
	@RequestMapping(value = "recipewrite.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String recipewrite(Model model) {
		model.addAttribute("doc_title", "레시피쓰기");
		return "recipewrite.tiles";		
	}
	
	@RequestMapping(value = "upload.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String recipeupload(RecipeDto dto, @RequestParam(value = "fileload", required = false) MultipartFile fileload,
		HttpServletRequest req){
		
		String bestimg = fileload.getOriginalFilename();
		dto.setBestimg(bestimg);	// DB에 저장하기 위해서 원파일명을 넣어 준다
		
		String fupload = req.getServletContext().getRealPath("/upload");
		
		System.out.println("fupload:" + fupload);
		
		String newbestimg = PdsUtil.getNewFileName(dto.getBestimg());
		dto.setNewbestimg(newbestimg);
		
		File file = new File(fupload + "/" + newbestimg);
		
		try {
			// 실제로 업로드
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());			 				
			// DB에 저장
			service.uploadre(dto);
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
			return "redirect:/recipe.do";
	}

	@ResponseBody
	   @RequestMapping(value="contentImageSend.do", method = RequestMethod.POST)
	   public void contentImageSend(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   response.setContentType("text/html;charset=utf-8");
	      PrintWriter out = response.getWriter();
	      // 업로드할 폴더 경로
	      String realFolder = request.getSession().getServletContext().getRealPath("/upload/contentImage");
	   
	      // 업로드할 파일 이름
	      String org_filename = file.getOriginalFilename();
	      String str_filename = PdsUtil.getNewFileName(org_filename);
	   
	   //   System.out.println("원본 파일명 : " + org_filename);
	   //   System.out.println("저장할 파일명 : " + str_filename);
	   
	      String filepath = realFolder + "\\"+ str_filename;
	   //   System.out.println("파일경로 : " + filepath);
	   
	      File f = new File(filepath);
	      if (!f.exists()) {
	      f.mkdirs();
	      }
	      file.transferTo(f);
	      out.println("upload/contentImage/"+str_filename);
	      out.close();

	   }
	
	@RequestMapping(value = "redetail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String redetail(int seq, Model model, HttpServletRequest request){
		model.addAttribute("doc_title", "레시피 보기");
		
		System.out.println("seq>>>>>>>>>>"+seq);
		
		service.readCount(seq);
		
		// dto 취득
		RecipeDto recipedto = service.getRecipe(seq);
		model.addAttribute("recipe", recipedto);
		
		
		/*------------------ 좋아요------------------ */
		int likecount = service.getLikeCount(seq);		
		model.addAttribute("likecount", likecount);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa"+likecount);
		
		List<LikeDto> likelist = service.getlist(seq);	//게시글 번호 가져와서 게시글에 좋아요 누른 유저리스트
		System.out.println("likelist>>>>>>>>" + likelist.toString());
		//model.addAttribute("likelist", likelist);
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		String id = login.getId();
		boolean likecheck = likelist.toString().contains(id);
		System.out.println("likecheck" + likecheck);
		model.addAttribute("likecheck", likecheck);
		
		
		return "redetail.tiles";
	}
	
	@RequestMapping(value = "reupdate.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String reupdate(int seq, Model model) {
		model.addAttribute("doc_title", "레시피 수정");
		
		RecipeDto recipedto = service.getRecipe(seq);
		model.addAttribute("recipe", recipedto);
		
		return "reupdate.tiles";
	}
	
	@RequestMapping(value = "recipeupdateAf.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String recipeupdateAf(	RecipeDto recipedto, 
			String namefile, String newnamefile,	// 기존의 파일 명,
			HttpServletRequest req,
			@RequestParam(value = "fileload", required = false)MultipartFile fileload) {
		
		recipedto.setBestimg(fileload.getOriginalFilename());
		
		// 파일 경로
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
		//String fupload = "c:\\tmp";
		
		// 수정할 파일이 있음
		if(recipedto.getBestimg() != null && !recipedto.getBestimg().equals("")) {
			
			String f = recipedto.getBestimg();
			String newfilename = PdsUtil.getNewFileName(f);
			
			recipedto.setBestimg(f);
			recipedto.setNewbestimg(newfilename);
			
			File file = new File(fupload + "/" + newfilename);			
			
			try {
				// 실제 업로드
				FileUtils.writeByteArrayToFile(file, fileload.getBytes());
				
				// db 경신
				service.updaterecipe(recipedto);		
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}
		else {	// 수정할 파일 없음
			
			// 기존의 파일명으로 설정
			recipedto.setBestimg(namefile);
			recipedto.setNewbestimg(newnamefile);
			
			// DB
			service.updaterecipe(recipedto);	
		}
		return "redirect:/recipe.do";
	}
	
	@RequestMapping(value = "recipedelete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String recipedelete(int seq) {
		service.deleterecipe(seq);
		
		return "redirect:/recipe.do";
	}
	
	
	
	//////////////////효제추가/////////////////
	@RequestMapping(value = "myrecipe.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String myrecipe(Model model, HttpServletRequest request) {
		
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
	    String id = login.getId();

	    List<RecipeDto> list = service.myrecipelist(id);
	 	System.out.println(id);
	 	
	 	model.addAttribute("myrecipelist", list);
	 	System.out.println(list);
	 	

		return "myrecipe.tiles";
		
		
	}
	
	@RequestMapping(value = "like_recipe.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String like_recipe(Model model, HttpServletRequest request) {
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
	    String id = login.getId();
	    
	    List<Map<String, Object>> list = service.likerecipe(id); 
	 	System.out.println(id);
	 	
	 	
	 	model.addAttribute("likerecipe", list);
	 	System.out.println(list);
	
		
		return "like_recipe.tiles";
	}
}


















