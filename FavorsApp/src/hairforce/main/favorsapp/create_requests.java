package hairforce.main.favorsapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class create_requests extends Activity implements OnClickListener {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_requests);
		((Button) findViewById(R.id.send_request_button)).setOnClickListener(this);
		((Button) findViewById(R.id.pick_date_button)).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		
		case R.id.pick_date_button:
			showDatePickerDialog(v);
		
		case R.id.send_request_button:
			
			EditText item = (EditText) findViewById(R.id.item_requesting);
			EditText cost = (EditText) findViewById(R.id.item_cost);
					
		}
		
	}
	
	public void showDatePickerDialog(View v) {
	    DatePickerFragment newFragment = new DatePickerFragment();
	    newFragment.show(newFragment.getFragmentManager(), "datePicker");
	}

}

