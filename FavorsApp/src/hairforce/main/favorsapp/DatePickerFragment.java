package hairforce.main.favorsapp;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
	
	public static String year = "year";
	public static String month = "month";
	public static String day = "day";
	
	private int Year;
	private int Month;
	private int Day;
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker view, int Year, int Month, int Day) {
		this.Year = Year;
		this.Month = Month;
		this.Day = Day;
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		super.onDismiss(dialog);
		Intent i = new Intent();
		i.putExtra(this.year,  this.Year);
		i.putExtra(this.month, this.Month);
		i.putExtra(this.day, this.Day);
		this.getTargetFragment().onActivityResult(this.getTargetRequestCode(), Activity.RESULT_OK, i);
	}
	
	
	
	
	
}
