package hairforce.main.data;

import com.google.gson.Gson;
import java.util.ArrayList;

public class User {
	private String FBtoken;
	private ArrayList<Favor> favors;
	private ArrayList<Group> groups;

	public User(String name, Group group, String FBtoken) {
		this.FBtoken = FBtoken;
		this.favors = new ArrayList<Favor>();
		this.groups = new ArrayList<Group>();
		this.groups.add(group);
		new Network().doInBackground("newperson", group.toString(), FBtoken);
	}

	public void importFavors(Group group) {
		
		Gson gson = new Gson();
//		MyType target = new MyType
		new Network().doInBackground("myrequests", group.toString(),this.FBtoken);
	}

	public void importGroups() {
		// TODO get the groups from a database
	}

	public String getName() {
		return this.FBtoken;
	}

	public ArrayList<Favor> getFavors() {
		return this.favors;
	}

	public ArrayList<Group> getGroups() {
		return this.groups;
	}
}
