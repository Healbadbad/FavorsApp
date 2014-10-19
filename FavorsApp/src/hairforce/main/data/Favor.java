package hairforce.main.data;

public class Favor {

	private String itemName;
	private User buyer;
	private User requester;
	private int approxCostInCents;
	private Status status;
	private Group group;
	private int month;
	private int day;
	private int year;

	public Favor(String itemName, int approxCostInCents, String expirationDate, User requester, Group group) {
		this.itemName = itemName;
		this.buyer = null;
		this.requester = requester;
		this.approxCostInCents = approxCostInCents;
		String[] date = expirationDate.split("/");
		this.month = Integer.parseInt(date[0]);
		this.day = Integer.parseInt(date[1]);
		this.year = Integer.parseInt(date[2]);

		this.status = Status.PENDING;
		this.group = group;
		String end = this.itemName + "@" + String.valueOf(this.approxCostInCents) + "@" + this.requester + "@"
				+ this.month + "@" + this.day + "@" + this.year;
		new Network().doInBackground("newrequest", this.group.toString(), end);
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

	public String getExperationDate() {
		return this.month + "/" + this.day + "/" + this.year;
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
