package hairforce.main.favorsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class CreateRequests extends Fragment implements OnClickListener {
	
	int DATE_PICKER_DIALOG_CONSTANT = 999;
	private String expiration_date;

	public static Fragment newInstance() {
		CreateRequests fragment = new CreateRequests();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.create_requests, container, false);
		
		rootView.findViewById(R.id.pick_date_button).setOnClickListener(this);
		rootView.findViewById(R.id.send_request_button).setOnClickListener(this);
			
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	private void showDatePickerDialog(View v, CreateRequests createRequests) {
	    DatePickerFragment newFragment = new DatePickerFragment();
	    newFragment.setTargetFragment(this, this.DATE_PICKER_DIALOG_CONSTANT);
	    newFragment.show(getFragmentManager(), "DatePicker");
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.pick_date_button:
			showDatePickerDialog(v, this);
			break;
			
		case R.id.send_request_button:
			
			EditText item = (EditText) getView().findViewById(R.id.item_requesting);
			EditText cost = (EditText) getView().findViewById(R.id.item_cost);
			
			String item_value = item.getText().toString();
			String cost_value = cost.getText().toString();
			String date_value = this.expiration_date;
					
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		((Button) getView().findViewById(R.id.pick_date_button)).setText(data.getIntExtra("month", 0) + "/" + data.getIntExtra("day", 0) + "/" + data.getIntExtra("year", 0));
		this.expiration_date = ((Button) getView().findViewById(R.id.pick_date_button)).getText().toString();

	}
}