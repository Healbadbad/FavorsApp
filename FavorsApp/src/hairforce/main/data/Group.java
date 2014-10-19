package hairforce.main.data;
import java.util.ArrayList;

public class Group {

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
		// TODO find a way to import
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
