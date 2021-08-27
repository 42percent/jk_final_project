package bit.your.prj.visit;

public class VisitCountDto {

	private int visit_id;
    private String visit_ip;
    private String visit_agent;
	
    public VisitCountDto() {
	}

	public int getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}

	public String getVisit_ip() {
		return visit_ip;
	}

	public void setVisit_ip(String visit_ip) {
		this.visit_ip = visit_ip;
	}

	public String getVisit_agent() {
		return visit_agent;
	}

	public void setVisit_agent(String visit_agent) {
		this.visit_agent = visit_agent;
	}

	@Override
	public String toString() {
		return "VisitCountDto [visit_id=" + visit_id + ", visit_ip=" + visit_ip + ", visit_agent=" + visit_agent + "]";
	}
    
    
    
}
