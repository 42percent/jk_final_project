package bit.your.prj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.your.prj.dto.RecCommentDto;
import bit.your.prj.param.RecCommentParam;

@Repository
public class RecCommentDaoImpl implements RecCommentDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<RecCommentDto> reccommentlist(int bbsid) throws Exception {
		return session.selectList("RecComment.reccommentlist", bbsid);
	}

	@Override
	public int reccommentadd(RecCommentDto reccommentdto) throws Exception {
		return session.insert("RecComment.reccommentadd", reccommentdto);
	}

	@Override
	public int updatereccomment(RecCommentDto reccommentdto) throws Exception {
		return session.update("RecComment.updatereccomment", reccommentdto);
	}

	@Override
	public int deletereccomment(int seq) throws Exception {
		return session.delete("RecComment.deletereccomment", seq);
	}

	@Override
	public int reccommentcount(int seq) throws Exception {
		return session.selectOne("RecComment.reccommentcount", seq);
	}

	@Override
	public int rereply(RecCommentDto reccommentDto) throws Exception {
		return session.insert("RecComment.rereply", reccommentDto);
	}

	@Override
	public int updatere(RecCommentDto reccommentdto) throws Exception {
		return session.update("RecComment.updatere", reccommentdto);
	}

	@Override
	public List<RecCommentParam> reccomment(RecCommentParam param) throws Exception {
		return session.selectList("RecComment.reccomment", param);
	}
	
}
