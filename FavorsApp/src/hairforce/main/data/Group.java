package hairforce.main.data;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Group extends Linker{

	private String name;
	private String password;
	private ArrayList<User> members;

	public Group(String name, String password) {
		this.name = name;
		this.password = password;
		this.members = new ArrayList<User>();
		Network network = new Network();
		network.doInBackground("newgroup", this.name + "&"+this.password);
	}
	
	public void importUsers() {
		Network network = new Network();
		network.parent = null;
	}
	
	public void loadUsers(String blah) {
		Gson gson = Utility.getGson();
		this.members.add(gson.fromJson(blah, User.class));
	}
	public String getName() {
		return this.name;
	}

	public ArrayList<User> getMembers() {
		return this.members;
	}
	
	public boolean checkPassword(String givenPassword) {
		return password.equals(givenPassword);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
