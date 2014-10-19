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

	public Favor(int id, String itemName, User requester, int approxCostInCents, long startTime, long endTime, Status status, Group group) {
		this.id = id;
		this.itemName = itemName;
		this.buyer = null;
		this.requester = requester;
		this.approxCostInCents = approxCostInCents;
		this.startTime=  startTime;
		this.endTime = endTime;
		this.status = status;
		this.group = group;
		String end=  this.itemName + "@" +String.valueOf(this.approxCostInCents) + "@"  + this.requester + "@" + String.valueOf(endTime);
		new Network().doInBackground("newrequest", this.group.toString(), end);
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public User getBuyer() {
		return this.buyer;
	}
	
	public User getRequester() {
		return this.requester;
	}
	
	public int getApproxCostInCents() {
		return this.approxCostInCents;
	}

	public long getStartTime() {
		return this.startTime;
	}
		
	public long getEndTime() {
		return this.endTime;
	}

	public long getTimeLeft() {
		return this.endTime - System.nanoTime();
	}
	
	public long getElapsedTime() {
		return System.nanoTime() - this.startTime;
	}

	public void changeStatus(Status newStatus) {
		this.status = newStatus;
	}
	public Status getStatus() {
		return this.status;
	}
	
	public Group getGroup() {
		return this.group;
	}
	
	public void foundBuyer(User buyer) {
		this.buyer = buyer;
	}


}

