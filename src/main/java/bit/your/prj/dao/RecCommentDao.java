package bit.your.prj.dao;

import java.util.List;

import bit.your.prj.dto.RecCommentDto;
import bit.your.prj.param.RecCommentParam;

public interface RecCommentDao {
	public List<RecCommentDto> reccommentlist(int bbsid) throws Exception;
	public List<RecCommentParam> reccomment(RecCommentParam param) throws Exception;

	public int reccommentadd(RecCommentDto reccommentdto) throws Exception;
	
	public int updatereccomment(RecCommentDto reccommentdto) throws Exception;

	public int deletereccomment(int seq) throws Exception;
	
	public int reccommentcount(int seq) throws Exception;
	
	public int rereply(RecCommentDto reccommentDto) throws Exception;
	
	public int updatere(RecCommentDto reccommentdto) throws Exception;
}
