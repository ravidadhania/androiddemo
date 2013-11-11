package com.agileinfoways.android_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Result_Intent_Activity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Result_Intent_Activity", "OnCreate ");
		
		Intent in = new Intent();
		setResult(1, in);// Here I am Setting the Requestcode 1, you can put
							// according to your requirement
		finish();
	}
}
