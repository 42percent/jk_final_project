package bit.your.prj.dto;

public class CMDto {
	
	private int seq; 		//시퀀스
	private int seq_class;	//수업 시퀀스
	private String nickname;//참연한 사람의 닉네임
	private String gender;  //참여한 사람의 성별
	
	public CMDto() {
	}

	public CMDto(int seq, int seq_class, String nickname, String gender) {
		super();
		this.seq = seq;
		this.seq_class = seq_class;
		this.nickname = nickname;
		this.gender = gender;
	}

	public CMDto(int seq_class, String nickname, String gender) {
		super();
		this.seq_class = seq_class;
		this.nickname = nickname;
		this.gender = gender;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getSeq_class() {
		return seq_class;
	}

	public void setSeq_class(int seq_class) {
		this.seq_class = seq_class;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CMDto [seq=" + seq + ", seq_class=" + seq_class + ", nickname=" + nickname + ", gender=" + gender + "]";
	}	
	
}
