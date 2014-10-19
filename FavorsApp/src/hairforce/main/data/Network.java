package hairforce.main.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class Network extends AsyncTask<String, String, String> {
	public static final String BASE_URL = "http://favors-hairforce.rhcloud.com/";
	public Linker parent;
	public boolean isFavor;

	@Override
	protected String doInBackground(String... params) {
		String urlPath = BASE_URL;
		for (String string : params) {
			urlPath += string + "/";
		}
		try {
			URL url = new URL(urlPath);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String html = "";
			String inputLine = null;
			while ((inputLine = br.readLine()) != null) {
				html += inputLine;
			}
			return html;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		if (this.parent.getClass() == User.class) {
			if (isFavor) {
				((User) this.parent).loadFavors(result);
			} else {
				((User) this.parent).loadGroups(result);
			}
		}
		((Group)(this.parent)).loadUsers(result);
	}
}
