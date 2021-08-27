package bit.your.prj.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.your.prj.dto.CMCDto;
import bit.your.prj.service.CMCService;

@RestController
public class CMCController {
	
	@Inject
	private CMCService service;
	
	@RequestMapping(value = "getCMCList.do", method = RequestMethod.POST)
	public List<CMCDto> getCMCList(@RequestParam("seq_class")int seq) throws Exception{
		
		return service.getCMCList(seq);
	}
	
	/*
	 * @RequestMapping(value = "getCMCList.do", method = RequestMethod.POST) public
	 * List<CMCDto> getCMCPagingList(CParam param) throws Exception {
	 * 
	 * return service.getCMCPagingList(param);
	 * 
	 * }
	 */
	
	@RequestMapping(value = "writeCMC.do", method = RequestMethod.POST)
	public Map<String, Object> writeCMC(@RequestBody CMCDto dto) throws Exception {
		Map<String, Object> result = new HashMap<>();		
		System.out.println("result" + result);
		
		try {			
			service.writeCMC(dto); 			
			result.put("status", "OK");			
		} catch (Exception e) {			
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	
	@RequestMapping(value = "writeReCMC.do", method = RequestMethod.POST)
	public Map<String, Object> writeReCMC(@RequestBody CMCDto dto) throws Exception {
		Map<String, Object> result = new HashMap<>();		
		System.out.println(dto.toString()+"-----------------------");
		try {			
			service.writeCMC(dto);
			System.out.println(dto.toString()+"-----------------------");
			result.put("status", "OK");
			
		} catch (Exception e) {			
			e.printStackTrace();
			result.put("status", "False");
		}

		return result;
	}
	
	@RequestMapping(value = "updatereCMC.do", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> updatere(@RequestBody CMCDto dto) throws Exception {
	Map<String, Object> result = new HashMap<>();
		try {
			service.updatere(dto);
			result.put("status", "OK");
	
		} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "False");
		}
		return result;
	}
	
	@RequestMapping(value = "updateCMC.do", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> updateCMC(@RequestBody CMCDto dto) throws Exception {
	Map<String, Object> result = new HashMap<>();
		
		try {
			service.updateCMC(dto);
			result.put("status", "OK");
		} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "False");
		}
		return result;
	}
	
	@RequestMapping(value = "deleteCMC.do", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> deleteCMC(@RequestParam("seq") int seq) throws Exception {
	Map<String, Object> result = new HashMap<>();
		
		try {
			service.deleteCMC(seq);
			result.put("status", "OK");
		} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "False");
		}
		return result;
	}
	
	
}
