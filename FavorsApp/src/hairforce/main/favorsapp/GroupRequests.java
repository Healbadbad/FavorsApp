package hairforce.main.favorsapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GroupRequests extends Activity implements OnClickListener{

	private ListView requestsListView;
	private ArrayAdapter<String> listAdapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_requests);
		
		requestsListView = (ListView) findViewById(R.id.requestList);
		
		String requests[] = {"Test1", "Test2", "Test3", "Numbers", "Walls", "Dicks"}; // Put the requests here in however you import them
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, )
		
		
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	

		
		
		



}
