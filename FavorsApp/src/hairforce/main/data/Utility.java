package hairforce.main.data;

import com.google.gson.Gson;

public class Utility {
	private static Gson gson = null;
	
	public static Gson getGson() {
		if(gson == null) {
			gson = new Gson();
		}
		return gson;
	}
}
