package hairforce.main.data;


import java.util.ArrayList;

public class User {
	private int id;
	private ArrayList<Favor> favors;
	private ArrayList<Group> groups;

	public User(int id, String username) {
		this.id = id;
		this.favors = new ArrayList<Favor>();
		this.groups = new ArrayList<Group>();
	}

	public void importFavors() {
		// TODO get the favors from a database
	}

	public void importGroups() {
		// TODO get the groups from a database
	}

	public int getId() {
		return this.id;
	}

	public ArrayList<Favor> getFavors() {
		return this.favors;
	}

	public ArrayList<Group> getGroups() {
		return this.groups;
	}
}
