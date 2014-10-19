package hairforce.main.data;

public class Favor {

	private String Item;
	private User Responder;
	private User Requester;
	private int Price;
	private Status statuscode;
	private Group group;
	private String ExpirationDate;

	public Favor(String itemName, int approxCostInCents, String expirationDate, User requester, Group group) {
		this.Item = itemName;
		this.Responder = null;
		this.Requester = requester;
		this.Price = approxCostInCents;
		this.ExpirationDate = expirationDate.replaceAll("/", "_");
		this.statuscode = Status.PENDING;
		this.group = group;
		String end = this.Item + "@" + String.valueOf(this.Price) + "@" + this.Requester + "@"
				+ this.ExpirationDate;
		new Network().doInBackground("newrequest", this.group.toString(), end);
	}

	public String getItemName() {
		return this.Item;
	}

	public User getBuyer() {
		return this.Responder;
	}

	public User getRequester() {
		return this.Requester;
	}

	public int getApproxCostInCents() {
		return this.Price;
	}

	public String getExperationDate() {
		return this.ExpirationDate;
	}

	public void changeStatus(Status newStatus) {
		this.statuscode = newStatus;
	}

	public Status getStatus() {
		return this.statuscode;
	}

	public Group getGroup() {
		return this.group;
	}

	public void foundBuyer(User buyer) {
		this.Responder = buyer;
	}

}
