package bit.your.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.your.prj.dao.RecCommentDao;
import bit.your.prj.dto.RecCommentDto;
import bit.your.prj.param.RecCommentParam;

@Service
public class RecCommentServiceImpl implements RecCommentService{
	
	@Autowired
	RecCommentDao dao;

	@Override
	public List<RecCommentDto> reccommentlist(int bbsid) throws Exception {
		return dao.reccommentlist(bbsid);
	}

	@Override
	public int reccommentadd(RecCommentDto reccommentdto) throws Exception {
		return dao.reccommentadd(reccommentdto);
	}

	@Override
	public int updatereccomment(RecCommentDto reccommentdto) throws Exception {
		return dao.updatereccomment(reccommentdto);
	}

	@Override
	public int deletereccomment(int seq) throws Exception {
		return dao.deletereccomment(seq);
	}

	@Override
	public int reccommentcount(int seq) throws Exception {
		return dao.reccommentcount(seq);
	}

	@Override
	public int rereply(RecCommentDto reccommentDto) throws Exception {
		return dao.rereply(reccommentDto);
	}

	@Override
	public int updatere(RecCommentDto reccommentdto) throws Exception {
		return dao.updatereccomment(reccommentdto);
	}

	@Override
	public List<RecCommentParam> reccomment(RecCommentParam param) throws Exception {
		return dao.reccomment(param);
	}


	
	
}
