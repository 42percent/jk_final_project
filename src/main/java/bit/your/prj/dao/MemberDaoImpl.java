package bit.your.prj.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.MemberDto;


@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession session;
	String ns = "Member.";
	
	@Override
	public MemberDto login(MemberDto mem) {		
		return session.selectOne(ns + "login", mem);
	}


	@Override
	public boolean addmember(MemberDto mem) {
		int n = session.insert(ns + "addmember", mem);
		return n>0?true:false;
	}

	@Override
	public int getId(MemberDto mem) {		
		return session.selectOne(ns + "getId", mem);		
	}



	@Override
	public int getnickname(MemberDto mem) {
		return session.selectOne(ns + "getnickname", mem);
	}


	@Override
	public MemberDto findid(MemberDto mem) {
		return session.selectOne(ns + "findid", mem);
	}


	@Override
	public int updatepwd(MemberDto mem) throws Exception {
		return session.update(ns + "updatepwd", mem);
	}


	@Override
	public MemberDto readmember(String id) throws Exception {
		return session.selectOne(ns + "readmember", id);
	}
	
	@Override
	public void updatemember(MemberDto mem) throws Exception {
		session.update(ns + "updatemember", mem);
		
	}


	@Override
	public void deletemember(MemberDto mem) throws Exception {
		int check = session.update(ns + "deletemember", mem);
		
	}
	
	
	/*---------------------------api---------------------------------------------------------------------------------0813*/

	@Override
	public boolean idCheck(String id) {
		return session.selectOne(ns + "idCheck", id);
	}


	@Override
	public boolean nicknameCheck(String nickname) {
		return session.selectOne(ns + "nicknameCheck", nickname);
	}


	@Override
	public boolean emailCheck(String email) {
		return session.selectOne(ns + "emailCheck", email);
	}


	@Override
	public MemberDto getMember(String id) {
		return session.selectOne(ns+"getMember",id);
	}

	/////////////////////////////////////////////
	
	
	
	
	


	

	




}