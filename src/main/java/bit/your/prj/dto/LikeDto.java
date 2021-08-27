package bit.your.prj.dto;

public class LikeDto {

	private int seq;
	private String id;
	private int seq_recipe;
	
	public LikeDto() {
	}

	public LikeDto(int seq, String id, int seq_recipe) {
		super();
		this.seq = seq;
		this.id = id;
		this.seq_recipe = seq_recipe;
	}

	public int getSeq() {
		return seq;
	}

	public String getId() {
		return id;
	}

	public int getSeq_recipe() {
		return seq_recipe;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSeq_recipe(int seq_recipe) {
		this.seq_recipe = seq_recipe;
	}

	@Override
	public String toString() {
		return "LikeDto [seq=" + seq + ", id=" + id + ", seq_recipe=" + seq_recipe + "]";
	}
	
	
}
