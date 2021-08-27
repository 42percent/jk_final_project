
package bit.your.prj.controller;


import java.io.PrintWriter;

import java.util.Date;


import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;

import bit.your.prj.dto.MemberDto;
import bit.your.prj.oauth.bo.NaverLoginBO;
import bit.your.prj.service.MemberService;



@Controller
public class MemberController {
	
	static Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@RequestMapping(value = "login.do",  method = {RequestMethod.GET, RequestMethod.POST})
	public String login() {
		log.info("MemberController login() " + new Date());
		
		return "login.tiles";
		
	}
	
	@RequestMapping(value = "regi.do",  method = {RequestMethod.GET, RequestMethod.POST})
	public String regi(MemberDto dto) {
		log.info("MemberController regi() " + new Date());

		
		return "regi.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "getId.do",  method = {RequestMethod.GET, RequestMethod.POST})
	public String getId(MemberDto mem) {	
		log.info("MemberController getId() " + new Date());
		
		int count = service.getId(mem);
		String msg = "";
		if(count > 0) {
			msg = "YES";
		}else {
			msg = "NO";
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "getnickname.do",  method = {RequestMethod.GET, RequestMethod.POST})
	public String getnickname(MemberDto mem) {	
		log.info("MemberController getnickname() " + new Date());
		
		int count = service.getnickname(mem);
		String msg = "";
		if(count > 0) {
			msg = "YES";
		}else {
			msg = "NO";
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "loginAf.do",  method = {RequestMethod.GET, RequestMethod.POST})
	public void loginAf(MemberDto dto, HttpServletRequest req, Model model, HttpServletResponse resp) throws Exception {
		log.info("MemberController loginAf() " + new Date());
		
		MemberDto login = service.login(dto);
		if(login != null && !login.getId().equals("")) {
			System.out.println("로그인되었습니다");
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60 * 60 * 24);
			
			 resp.setContentType("text/html; charset=utf-8");
		      PrintWriter out = resp.getWriter();
		      out.println("<script>alert('로그인 성공하였습니다!'); location.href='home.do'; </script> ");
		      out.close();
		      out.flush();

			
		}else {
			System.out.println("로그인 실패하였습니다");
			      resp.setContentType("text/html; charset=utf-8");
			      PrintWriter out = resp.getWriter();
			      out.println("<script>alert('로그인 실패하였습니다'); location.href='login.do'; </script> ");
			      out.close();
			      out.flush();
			
		}
		
		
		}
		@RequestMapping(value = "regiAf.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String regiAf(MemberDto dto, Model model, HttpServletRequest request) {
			log.info("MemberController regiAf() " + new Date());

			boolean b = service.addmember(dto);
			
			if(b) {
				System.out.println("회원가입되었습니다");
				return "login.tiles";
			}else {
			
			System.out.println("가입되지 않았습니다");		
			return "regi.tiles";		

	}
		}
		
		@RequestMapping(value = "findid.do",  method = {RequestMethod.GET, RequestMethod.POST})
		public String findid() {
			log.info("MemberController findid() " + new Date());
			return "findid.tiles";
		}
		
		@RequestMapping(value = "findidAf.do",  method = {RequestMethod.GET, RequestMethod.POST})
		public String findidAf(MemberDto dto, Model model) {
			log.info("MemberController findid() " + new Date());
			MemberDto mem = service.findid(dto);
			
			if(mem == null) { 
				model.addAttribute("check", 1);
			} else { 
				model.addAttribute("check", 0);
				model.addAttribute("id", mem.getId());
			}
			
			return "findid.tiles";
		}
		
		/* 비밀번호 찾기 */
		@RequestMapping(value = "findpw.do",  method = RequestMethod.GET)
		public String findpw() {
			log.info("MemberController findpw() " + new Date());
			return "findpw.tiles";
		}
		

		@RequestMapping(value="findpw.do", method = RequestMethod.POST)
		public String findpwAf(@ModelAttribute MemberDto mem, HttpServletResponse resp) throws Exception{
			log.info("MemberController findpwAf() " + new Date());
			
			service.findpw(resp, mem);
			
			
		return "login.tiles";
		}
	
		

			/* 이메일 인증 */
			@ResponseBody
			@RequestMapping(value="mailCheck.do", method = {RequestMethod.GET, RequestMethod.POST})
			public String mailCheckGET(String email) throws Exception{
				log.info("MemberController mailcheck() " + new Date());
				
				log.info("인증번호" + email);
						
				/* 인증번호(난수) 생성 */
				Random random = new Random();
				int checkNum = random.nextInt(888888) + 111111;
				System.out.println(checkNum);
				/* 이메일 보내기 */
				String setFrom = "yourrecipe202@gmail.com";
				String toMail = email;
				String title = "회원가입 인증 이메일 입니다.";
				String content = 
						"YOUR(Your Own Uniqe Recipe)을 방문해주셔서 감사합니다." +
						"<br><br>" + 
						"인증 번호는 " +
						checkNum + "입니다." + 
						"<br>" + 
						"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";		
				
				try {
					
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
					helper.setFrom(setFrom);
					helper.setTo(toMail);
					helper.setSubject(title);
					helper.setText(content,true);
					mailSender.send(message);
					
				}catch(Exception e) {
					e.printStackTrace();
				}		
				
				String num = Integer.toString(checkNum);
				
				return num;
				
			}
			
			  
			
		
		
		@RequestMapping(value="info.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String info(HttpSession session, Model model, HttpServletRequest request)  {
			log.info("MemberController info() " + new Date());

			//세션 객체 안에 있는 ID정보 저장
			MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		    String id = login.getId();
			
			//서비스안의 회원정보보기 메서드 호출
			MemberDto dto = service.readmember(id);
			//정보저장 후 페이지 이동
			model.addAttribute("mem", dto);
			
			return "info.tiles";
		}
		
		@RequestMapping(value="info_update.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String info_update(HttpSession session, Model model, HttpServletRequest request) {
			log.info("MemberController info_update() " + new Date());

			//세션 객체 안에 있는 ID정보 저장
			MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		    String id = login.getId();
			
			//서비스안의 회원정보보기 메서드 호출
			MemberDto dto = service.readmember(id);
			
			model.addAttribute("mem", dto);
		    
			return "info_update.tiles";
		}
		
		@RequestMapping(value="info_updateAf.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String info_updateAf(HttpSession session, Model model, HttpServletRequest request, MemberDto dto) {
			log.info("MemberController info_updateAf() " + new Date());

			//세션 객체 안에 있는 ID정보 저장
			MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		    String id = login.getId();
			
			//서비스안의 회원정보보기 메서드 호출
			MemberDto mem = service.readmember(id);
			
			model.addAttribute("mem", dto);
		
		    service.updatemember(dto);
		
	
		return "info.tiles";
		}
		
	
		
		@RequestMapping(value="info_del.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String info_update(HttpSession session, HttpServletRequest request, Model model, MemberDto dto) {
			log.info("MemberController info_del() " + new Date());
			
			//세션 객체 안에 있는 ID정보 저장
			MemberDto login = (MemberDto)request.getSession().getAttribute("login");
		    String id = login.getId();
		    
		    MemberDto mem = service.readmember(id);
			
			model.addAttribute("mem", dto);
		    
		    if(id == null) {
		    	return "redirect:/login.do";
		    }
			
			
		return "info_del.tiles";
		
		}
		
		@RequestMapping(value="info_delAf.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String info_updateAf(MemberDto mem, HttpSession session) throws Exception {
			log.info("MemberController info_delAf() " + new Date());

			log.info("del전달정보" + mem);
			
		service.deletemember(mem);
		
		// 세션초기화
		session.invalidate();
		
		return "home.tiles";
		

		
		
		}
		

		@RequestMapping(value="logout.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String logout(HttpSession session) {
			log.info("MemberController logout() " + new Date());
			
		session.invalidate();
		
		return "redirect:/home.do";
		
		}
		
		
		
		
		
		
		
		
		
		
		
//		/*남규 추가 api 로그인관련------------------------------------------------------------------------------------------------------------0822*/
//	    
//		//네이버
//	    private NaverLoginBO naverLoginBO;
//	    private String apiResult = null;
//
//		
//	    @Autowired
//	    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
//	        this.naverLoginBO = naverLoginBO;
//	    }
//	    
//	    
//	    
//	    
//		@RequestMapping(value = "login.do",  method = {RequestMethod.GET, RequestMethod.POST})
//	    public String naverLogin(Model model, HttpSession session) {
//			log.info("MemberController logintesttttt () " + new Date());
//
//			//* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 *//*
//	        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//	        // 네이버
//	        model.addAttribute("naverUrl", naverAuthUrl);
//
//	        return "login.tiles";
//	    }
//	    
//	    @RequestMapping(value = "callback-naver.do", method = { RequestMethod.GET, RequestMethod.POST })
//	    public String naverCallback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws Exception {
//
//	        OAuth2AccessToken oauthToken;
//	        // 1. 로그인 사용자 정보를 읽어온다.
//	        oauthToken = naverLoginBO.getAccessToken(session, code, state);
//
//	        apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
//	        /**
//	         * apiResult json 구조 {"resultcode":"00", "message":"success",
//	         * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
//	         **/
//
//	        // 2. String형식인 apiResult를 json형태로 바꿈
//	        JSONParser parser = new JSONParser();
//	        Object obj = parser.parse(apiResult);
//	        JSONObject jsonObj = (JSONObject) obj;
//
//
//	        // 3. 데이터 파싱
//	        // Top레벨 단계 _response 파싱
//	        JSONObject response_obj = (JSONObject)jsonObj.get("response");
//	        // response의 id값 파싱
//	        String id = (String)response_obj.get("id");
//
//	        //신규회원인지 기존회원인지 검사
//	        boolean result = service.idCheck(id);
//
//	        if(result){
//	            MemberDto dto = service.getMember(id);
//	            System.out.println("로그인 = " + dto.toString());
//	            session.setMaxInactiveInterval(1800); // 1800 = 60s*30 (30분)
//	            session.setAttribute("login",dto);
//	            return "home.tiles";
//	        }
//
//	        //model.addAttribute("sns_type","naver");
//	        model.addAttribute("info", response_obj);
//	        return "snsregi.tiles";
//
//	    }
//		//네이버끝
//		
//		
//		
//		
//		@RequestMapping(value = "addMember.do", method = { RequestMethod.POST, RequestMethod.GET })
//	    public String addMember(HttpSession session, MemberDto dto) {
//
//	        if(dto.getSns_Type().equals("none")){
//	            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//	            String encPassword = encoder.encode(dto.getPwd());
//	            dto.setPwd(encPassword);
//	        }
//
//	        if(!dto.getSns_Type().equals("none")) {
//	            session.setAttribute("login", dto);
//	        }
//
//	        service.addmember(dto);
//
//	        return "redirect:/home.do";
//	    }
//		
//		
//		
		
		
		
		
}

