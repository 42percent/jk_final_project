package bit.your.prj.controller;

import java.io.IOException;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.your.prj.dto.CCDto;
import bit.your.prj.dto.MarketDto;
import bit.your.prj.dto.MemberDto;
import bit.your.prj.dto.RecipeDto;
import bit.your.prj.param.Param;
import bit.your.prj.service.AdService;

@Controller
public class AdController {
	
	static Logger log = LoggerFactory.getLogger(AdController.class);
	
	@Autowired
	AdService service;
	
	// 회원정보 List , paging
	@RequestMapping(value = "allmemlist.do", method = RequestMethod.GET)
	public String allmemlist(Model model, Param param ) {
		log.info("AdController allmemlist() " + new Date());
		
		int sn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + sn * 10;	// 1  11
		int end = (sn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<MemberDto> list = service.allmemlist(param);
		model.addAttribute("allmemlist",list);
		
		int totalCount = service.getMemCount(param);
		model.addAttribute("totalCount", totalCount);
		System.out.println("토탈카운트"+totalCount);
		
		model.addAttribute("pageNumber", param.getPageNumber() + 1);
		
		model.addAttribute("search", param.getSearch());
		model.addAttribute("choice", param.getChoice());
		
		
		return "allmemlist.tiles";
	}
 
	//회원정보 excel다운로드
	@RequestMapping(value = "excelDown.do")
	public void excelDown(HttpServletResponse response) throws Exception{
		
		List<MemberDto> list = service.excellist();
		
		// 워크북 생성
	    Workbook wb = new HSSFWorkbook();
	    Sheet sheet = wb.createSheet("회원정보");
	    Row row = null;
	    Cell cell = null;
	    int rowNo = 0;
		
	    // 테이블 헤더 스타일
	    CellStyle headStyle = wb.createCellStyle();

	    // 가는 경계선 설정
	    headStyle.setBorderTop(BorderStyle.THIN);
	    headStyle.setBorderBottom(BorderStyle.THIN);
	    headStyle.setBorderLeft(BorderStyle.THIN);
	    headStyle.setBorderRight(BorderStyle.THIN);

	    // 헤더 배경색
	    headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
	    headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    // 가운데 정렬
	    headStyle.setAlignment(HorizontalAlignment.CENTER);

	    // 데이터 격자
	    CellStyle bodyStyle = wb.createCellStyle();
	    bodyStyle.setBorderTop(BorderStyle.THIN);
	    bodyStyle.setBorderBottom(BorderStyle.THIN);
	    bodyStyle.setBorderLeft(BorderStyle.THIN);
	    bodyStyle.setBorderRight(BorderStyle.THIN);

	    // 헤더 생성
	    row = sheet.createRow(rowNo++);
	    cell = row.createCell(0);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("번호");
	    cell = row.createCell(1);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("아이디");
	    cell = row.createCell(2);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("이름");
	    cell = row.createCell(3);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("닉네임");
	    cell = row.createCell(4);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("생년월일");
	    cell = row.createCell(5);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("성별");
	    cell = row.createCell(6);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("이메일");
	    cell = row.createCell(7);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("주소");
	    cell = row.createCell(8);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("회원상태");
	    cell = row.createCell(9);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("가입일자");

	    // 데이터 부분 생성
	    for(MemberDto dto : list) {
	        row = sheet.createRow(rowNo++);
	        cell = row.createCell(0);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getSeq());
	        cell = row.createCell(1);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getId());
	        cell = row.createCell(2);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getName());
	        cell = row.createCell(3);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getNickname());
	        cell = row.createCell(4);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getBirth());
	        cell = row.createCell(5);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getGender());
	        cell = row.createCell(6);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getEmail());
	        cell = row.createCell(7);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getAddress1());
	        cell = row.createCell(8);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getAuth());
	        cell = row.createCell(9);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(dto.getJoindate().substring(0, 11));
	    }
	    
	    // 컨텐츠 타입과 파일명 지정
	    response.setContentType("ms-vnd/excel");
	    response.setHeader("Content-Disposition", "attachment;filename=AllMemberList.xls");

	    // 엑셀 출력
	    wb.write(response.getOutputStream());
	    wb.close();		
	}
	
	@RequestMapping(value = "sellchart.do", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("AdController sellchart()");
		
		// 회원성별 통계
		int mencount = service.getMenCount();
		int womencount = service.getWomenCount();
		// 총 카운트 
		int allmemcount = service.getAllMemCount();
		int allrecipecount = service.getAllRecipeCount();
		int allclasscount = service.getAllClassCount();
		int allmarketcount = service.getAllMarketCount();
		
		model.addAttribute("mencount",mencount);
		model.addAttribute("womencount",womencount);
		model.addAttribute("allmemcount",allmemcount);
		model.addAttribute("allrecipecount",allrecipecount);
		model.addAttribute("allclasscount",allclasscount);
		model.addAttribute("allmarketcount",allmarketcount);
		
		// 매출통계
		String jan = service.jan();
		model.addAttribute("jan",jan);
		
		String feb = service.feb();
		model.addAttribute("feb",feb);
		
		String mar = service.mar();
		model.addAttribute("mar",mar);
		
		String apr = service.apr();
		model.addAttribute("apr",apr);
		
		String may = service.may();
		model.addAttribute("may",may);
		
		String jun = service.jun();
		model.addAttribute("jun",jun);
		
		String jul = service.jul();
		model.addAttribute("jul",jul);
		
		String aug = service.aug();
		model.addAttribute("aug",aug);
		
		String sep = service.sep();
		model.addAttribute("sep",sep);
		
		String oct = service.oct();
		model.addAttribute("oct",oct);
		
		String nov = service.nov();
		model.addAttribute("nov",nov);
		
		String dec = service.dec();
		model.addAttribute("dec",dec);
		
		// 분류별 매출내역
		String meat = service.meat();
		model.addAttribute("meat",meat);
		String seefood = service.seefood();
		model.addAttribute("seefood",seefood);
		String vegetable = service.vegetable();
		model.addAttribute("vegetable",vegetable);
		String fruit = service.fruit();
		model.addAttribute("fruit",fruit);
		String mealkit = service.mealkit();
		model.addAttribute("mealkit",mealkit);
		
		return "sellchart.tiles";
	}
	
	//통계 끝
	
	// 레시피 
	@RequestMapping(value = "allrecipelist.do", method = RequestMethod.GET)
	public String allrecipelist(Model model, Param param ) {
		log.info("AdController allrecipelist() " + new Date());
		
		int sn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + sn * 10;	// 1  11
		int end = (sn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<RecipeDto> list = service.allrecipelist(param);
		model.addAttribute("allrecipelist",list);
		System.out.println(list);
		
		int totalCount = service.getRecipeCount(param);
		model.addAttribute("totalCount", totalCount);
		System.out.println("토탈카운트"+totalCount);
		
		model.addAttribute("pageNumber", param.getPageNumber() + 1);
		
		model.addAttribute("search", param.getSearch());
		model.addAttribute("choice", param.getChoice());
		
		
		return "allrecipelist.tiles";
	}
	
	// 레시피 끝
	
	// 쿠킹클래스
	@RequestMapping(value = "allclasslist.do", method = RequestMethod.GET)
	public String allclasslist(Model model, Param param ) {
		log.info("AdController allrecipelist() " + new Date());
		
		int sn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + sn * 10;	// 1  11
		int end = (sn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<CCDto> list = service.allclasslist(param);
		model.addAttribute("allclasslist",list);
		System.out.println(list);
		
		int totalCount = service.getClassCount(param);
		model.addAttribute("totalCount", totalCount);
		System.out.println("토탈카운트"+totalCount);
		
		model.addAttribute("pageNumber", param.getPageNumber() + 1);
		
		model.addAttribute("search", param.getSearch());
		model.addAttribute("choice", param.getChoice());
		
		
		return "allclasslist.tiles";
	}
	// 쿠킹클래스
	
	
	
	// 판매리스트
	@RequestMapping(value = "allmarketlist.do", method = RequestMethod.GET)
	public String allmarketlist(Model model, Param param ) {
		log.info("AdController allmarketlist() " + new Date());
		
		int sn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + sn * 10;	// 1  11
		int end = (sn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<MarketDto> list = service.allmarketlist(param);
		model.addAttribute("allmarketlist",list);
		System.out.println(list);
		
		int totalCount = service.getMarketCount(param);
		model.addAttribute("totalCount", totalCount);
		System.out.println("토탈카운트"+totalCount);
		
		model.addAttribute("pageNumber", param.getPageNumber() + 1);
		
		model.addAttribute("search", param.getSearch());
		model.addAttribute("choice", param.getChoice());
		
		
		return "allmarketlist.tiles";
	}
	
	
	
	
}
