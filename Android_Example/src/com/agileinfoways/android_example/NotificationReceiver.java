package com.agileinfoways.android_example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationReceiver extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);

		TextView tv = new TextView(this);
		tv.setText("Yo!");
		
		setContentView(tv);
	}
}