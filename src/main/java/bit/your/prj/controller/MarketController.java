package bit.your.prj.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.CartDto;
import bit.your.prj.dto.IncomeDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MarketParam;
import bit.your.prj.service.MarketService;
import bit.your.prj.util.PdsUtil;

@Controller
public class MarketController {

	static Logger log = LoggerFactory.getLogger(MarketController.class);
	
	@Autowired
	MarketService service;
	
	
	@RequestMapping(value = "marketmain.do", method = RequestMethod.GET)
	public String marketlist(Model model, HttpServletRequest request) {
		
		List<MarketDto> list = service.getMarketlist();
		model.addAttribute("marketlist", list);
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login"); 
		
		int cartCount = service.getCartCount(login.getId());
		
		model.addAttribute("cartCount",cartCount);
		
		return "marketmain.tiles";
	}
	
	@RequestMapping(value = "marketdetail.do", method = RequestMethod.GET)
	public String marketdetail(int seq, Model model, HttpServletRequest request){
		
		MarketDto mkdto = service.getMarket(seq);
		
		List<MarketDto> list = service.getCalist(mkdto.getCanum());
		
		// 디테일 들어갈때 세션에서 id값 가져와서 보내줌
		   MemberDto login = (MemberDto)request.getSession().getAttribute("login"); 
		   
		 int cartCount = service.getCartCount(login.getId());
		
		 model.addAttribute("dto",mkdto);
		 model.addAttribute("marketlist", list);
		 model.addAttribute("login",login);
		 model.addAttribute("cartCount",cartCount);
		 //System.out.println(login.toString());
		
		//System.out.println("dto>>>>>>"+mkdto.toString());
		//System.out.println("list>>>>>>"+list.toString());
		
		return "marketdetail.tiles";
	}
	
	@RequestMapping(value = "marketlist.do", method = RequestMethod.GET)
	public String marketlist(Model model, int canum, HttpServletRequest request) {
		
		List<MarketDto> list = service.getCalist(canum);
		model.addAttribute("calist", list);
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		int cartCount = service.getCartCount(login.getId());
		
		model.addAttribute("cartCount",cartCount);
		
		return "marketlist.tiles";
		
	}
	
	@RequestMapping(value = "newMarketList.do", method = RequestMethod.GET)
	public String newMarketList(Model model, HttpServletRequest request) {
		
		List<MarketDto> list = service.newMarketList();
		model.addAttribute("newMarketList", list);
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		int cartCount = service.getCartCount(login.getId());
		
		model.addAttribute("cartCount",cartCount);
		
		return "newMarketList.tiles";
	}
	
	@RequestMapping(value = "marketwrite.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String marketwrite() {
		return "marketwrite.tiles";
	}
	

	@RequestMapping(value = "marketupload.do", method = RequestMethod.POST)
	public String marketupload( MarketDto dto,
								@RequestParam(value = "fileload", required = false)
								MultipartFile fileload,
								@RequestParam(value = "fileload2", required = false)
								MultipartFile fileload2,
								HttpServletRequest req)
								{

		// filename(원본) 취득
		String content = fileload.getOriginalFilename();
		dto.setContent(content);
		String filename2 = fileload2.getOriginalFilename();
		dto.setMainpt(filename2);
		
		// upload 경로설정
		
		// server
		//String fupload = req.getServletContext().getRealPath("/upload");
		
		//폴더
		String fupload = "/Users/p.nam9/Desktop/your/your/src/main/webapp/marketimage";
		
		System.out.println("fupload:" + fupload);
		
		// 파일명 변경
		String newfilename = PdsUtil.getNewFileName(dto.getMainpt());
		dto.setNewmainpt(newfilename);
		
		String newfilename2 = PdsUtil.getNewFileName2(dto.getContent());
		dto.setContent(newfilename2);
		
		File file = new File(fupload + "/" + newfilename);
		File file2 = new File(fupload + "/" + newfilename2);
		
		//실제 업로드
		try {
			FileUtils.writeByteArrayToFile(file, fileload2.getBytes());
			FileUtils.writeByteArrayToFile(file2, fileload.getBytes());
			
			//DB 저장
			service.uploadMarket(dto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/marketmain.do";
	}
	

	@ResponseBody
	@RequestMapping(value = "addcart.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String addcart(Model model, String id, int itemnum, int count, String address) {
		
		
		MarketDto item = service.getItem(itemnum);
		
		//System.out.println(item.toString());
		
		CartDto dto = new CartDto(id, item.getCanum(), itemnum, 
								  item.getNewmainpt(), item.getTitle(), 
								  count, item.getPrice(), address);
		
		//System.out.println("dto.toString>>>>>>>>>>>>"+dto.toString());
		
		service.addCart(dto);
		int Count = service.getCartCount(id);
		int cartCount = Count + 1;
		model.addAttribute("cartCount",cartCount);
		
		
		return "";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "getCartCount.do", method = {RequestMethod.GET, RequestMethod.POST})
	public int getCartCount(Model model, String id) {
		
		int cartCount = service.getCartCount(id);
		System.out.println("cartCount>>>>>>>>>>>>"+cartCount);
		return cartCount;
	}
	
	@RequestMapping(value = "getSearchList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String getSearchList(Model model, MarketParam search, HttpServletRequest request) {
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		
		System.out.println("search>>>>>>>>>"+search);
		
		List<MarketDto> list = service.getSearchList(search);
		
		int cartCount = service.getCartCount(login.getId());
		
		
		model.addAttribute("searchList",list);
		model.addAttribute("login",login);
		model.addAttribute("cartCount",cartCount);
		
		
		return "getSearchList.tiles";
	}
	
	@RequestMapping(value = "goCart.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String getCartList(Model model, HttpServletRequest request) {
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		
		List<CartDto> list = service.getCartList(login.getId());
		
		int cartCount = service.getCartCount(login.getId());
		
		//System.out.println("CartList>>>>>>>"+ list.toString());
		
		model.addAttribute("cartList",list);
		model.addAttribute("login",login);
		model.addAttribute("cartCount",cartCount);
		
		return "getCartList.tiles";
		
	}

	
	@RequestMapping(value = "order.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String order(Model model, HttpServletRequest request) {
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		
		List<IncomeDto> list = service.getIncome(login.getId());
		
		//System.out.println(list);
		
		model.addAttribute("orderList",list);
		
		return "order.tiles";
	}
	@ResponseBody
	@RequestMapping(value = "delCart.do", method = {RequestMethod.GET, RequestMethod.POST})
	public List<CartDto> delCart(int seq, HttpServletRequest request) {
		
		//System.out.println("seq>>>>"+seq);
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		
		service.delCart(seq);
		
		return service.getCartList(login.getId());
	}
	
	@ResponseBody
	@RequestMapping(value = "countUp.do", method = {RequestMethod.GET, RequestMethod.POST})
	public boolean countUp(int seq, int count) {
		
		
		return service.itemCountUp(seq);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "countDown.do", method = {RequestMethod.GET, RequestMethod.POST})
	public boolean countDown(int seq, int count) {
		
		
		return service.itemCountDown(seq);
	}
	
	@ResponseBody
	@RequestMapping(value = "delAllItem.do", method = {RequestMethod.GET, RequestMethod.POST})
	public boolean delAllItem(String id) {
		
		
		return service.delAllItem(id);
	}
	

	
	@PostMapping("getData.do")
	public String getData(@RequestParam(value="dataList", required=false) List<String> dataList,
											@RequestParam(value="orderNum", required=false) String orderNum, HttpServletRequest request){
		
		MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		//System.out.println(dataList);
		//System.out.println(orderNum);
		// INCOME 테이블에 들어갈 데이터 -> SEQ, ORDERNUM, TITLE, COUNT, PRICE, CANUM, PDATE, ID
		for(String a : dataList) {
			int seq = Integer.parseInt(a);
			//int num = Integer.parseInt(orderNum); orderNum을 스트링으로 넣기
			//System.out.println(seq);
			CartDto cart = service.getCartItem(seq);
			//System.out.println(cart);
			IncomeDto dto = new IncomeDto();
			dto.setOrdernum(orderNum);
			dto.setTitle(cart.getTitle());
			dto.setMainpt(cart.getMainpt());
			dto.setPrice(cart.getPrice());
			dto.setCanum(cart.getCanum());
			dto.setId(login.getId());
			dto.setCount(cart.getCount());
			service.insertIncome(dto);
		};
			service.delAllItem(login.getId());
		
		return "OK";
	 }

	
	
	


	
	
	
	

	
}
