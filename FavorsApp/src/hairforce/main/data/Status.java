package hairforce.main.data;


public enum Status {
	PENDING("pending"), COMPLETED("completed"), ACCEPTED("accepted");
	
	private String status;

	private Status(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
//	public void changeStatus(Status newStatus) { 
//		this.status = newStatus.status;
//	}
//
	public boolean isEqual(Status s) {
		return this.status == s.status;
	}
}
