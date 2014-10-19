package hairforce.main.data;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class User extends Linker{
	private String name;
	private String FBtoken;
	private ArrayList<Favor> favors;
	private ArrayList<Group> groups;

	public User(String name, Group group, String FBtoken) {
		this.name = name;
		this.FBtoken = FBtoken;
		this.favors = new ArrayList<Favor>();
		this.groups = new ArrayList<Group>();
		this.groups.add(group);
		Network network = new Network();
		network.execute("newperson", group.toString(), FBtoken);
	}

	public void importFavors(Group group) {
		// MyType target = new MyType
		Network network = new Network();
		network.parent = this;
		network.isFavor = true;
		network.execute("myrequests", group.toString(), this.FBtoken);
	}

	public void importGroups() {
		Network network = new Network();
		network.parent = this;
		network.isFavor = false;
		network.execute("mygroups", this.name, this.FBtoken);
	}

	public void loadFavors(String blah) {
		Gson gson = Utility.getGson();
		this.favors.add(gson.fromJson(blah, Favor.class));
	}
	
	public void loadGroups(String blah) {
		Gson gson = Utility.getGson();
		this.groups.add(gson.fromJson(blah, Group.class));		
	}

	public String getName() {
		return this.name;
	}

	public String getFBToken() {
		return this.FBtoken;
	}

	public ArrayList<Favor> getFavors() {
		return this.favors;
	}

	public ArrayList<Group> getGroups() {
		return this.groups;
	}

}
