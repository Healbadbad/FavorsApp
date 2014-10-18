package hairforce.main.data;

public class Favor {

	
	private int id;
	private String itemName;
	private User buyer;
	private User requester;
	private int approxCostInCents;
	private long startTime;
	private long endTime;
	private Status status;
	private Group group;

	public Favor(int id, String itemName, User buyer, User requester, int approxCostInCents, long startTime, long endTime, Status status, Group group) {
		this.id = id;
		this.itemName = itemName;
		this.buyer = buyer;
		this.requester = requester;
		this.approxCostInCents = approxCostInCents;
		this.startTime=  startTime;
		this.endTime = endTime;
		this.status = status;
		this.group = group;
	}
}
