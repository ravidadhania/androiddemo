package com.agileinfoways.android_example;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Button_Custom_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button_custom);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.button__custom_, menu);
		return true;
	}

}
