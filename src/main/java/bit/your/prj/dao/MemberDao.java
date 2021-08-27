package bit.your.prj.dao;


import bit.your.prj.dto.MemberDto;

public interface MemberDao {

	MemberDto login(MemberDto mem);
	int getId(MemberDto mem);
	boolean addmember(MemberDto mem);	
	int getnickname(MemberDto mem);
	
	MemberDto findid(MemberDto mem);
	
	int updatepwd(MemberDto mem) throws Exception;
	
	MemberDto readmember(String id) throws Exception;
	
	void updatemember(MemberDto mem) throws Exception;
	void deletemember(MemberDto mem) throws Exception;



	/*------------------------------------------------------------------------------------------------------------*/
	
	/* api 관련 */
	boolean idCheck(String id);
	boolean nicknameCheck(String nickname);
	boolean emailCheck(String email);
	MemberDto getMember(String id);

	
}
