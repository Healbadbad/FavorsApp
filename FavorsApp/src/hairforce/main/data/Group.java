package hairforce.main.data;
import javax.net.ssl.HttpsURLConnection;

import java.util.ArrayList;

public class Group {

	private int id;
	private String name;
	private String password;
	private ArrayList<User> members;

	public Group(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.members = new ArrayList<User>();
		Network network = new Network();
		network.doInBackground("newgroup", this.name + "&"+this.password);
	}
	
	public void importUsers() {
		// TODO find a way to import
	}
	
	public int getId() {
		return this.id;
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
