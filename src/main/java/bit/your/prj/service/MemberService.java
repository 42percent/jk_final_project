package bit.your.prj.service;


import javax.servlet.http.HttpServletResponse;

import bit.your.prj.dto.MemberDto;


public interface MemberService {
	
	MemberDto login(MemberDto mem);
	int getId(MemberDto mem);
	boolean addmember(MemberDto mem);
	int getnickname(MemberDto mem);

	MemberDto findid(MemberDto mem);
	
	
    void sendEmail(MemberDto mem, String div) throws Exception;
    void findpw(HttpServletResponse resp, MemberDto mem) throws Exception;

	
	MemberDto readmember(String id);

    void updatemember(MemberDto mem);
	
	void deletemember(MemberDto mem);
	

	
	
	/*------------------------------------------------------------------------------------------------------------0813*/

	/*api관련 */
	boolean idCheck(String id);
	boolean nicknameCheck(String nickname);
	boolean emailCheck(String email);
	MemberDto getMember(String id);



}
