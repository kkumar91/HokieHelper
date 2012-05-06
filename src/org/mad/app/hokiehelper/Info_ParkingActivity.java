package org.mad.app.hokiehelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Info_ParkingActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking);

		int choice = getIntent().getExtras().getInt("chosen");
		TextView chosen = (TextView) findViewById(R.id.chosen);
		TextView info = (TextView) findViewById(R.id.current_selection);
		switch (choice) {
		case 0:
			chosen.setText("Parking information for Student without permit:");
			info.setText(R.string.student);
			break;
		case 1:
			chosen.setText("Parking information for Resident Student with permit:");
			info.setText(R.string.resident);
			break;
		case 2:
			chosen.setText("Parking information for Commuter or Graduate Student with permit:");
			info.setText(R.string.gradorcomm);
			break;
		case 3:
			chosen.setText("Parking information for Faculty or Staff with permit:");
			info.setText(R.string.facultystaff);
			break;
		case 4:
			chosen.setText("Parking information for Visitor:");
			info.setText(R.string.visitor);
			break;
		}
	}
}
