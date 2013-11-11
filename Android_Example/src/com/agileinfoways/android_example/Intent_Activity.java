package com.agileinfoways.android_example;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class Intent_Activity extends Activity 
{
	Button implicit_intent_btn, explicit_intent_btn, activity_result_btn;
	int REQUEST_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);

		implicit_intent_btn = (Button) findViewById(R.id.implicit_intent_btn);
		explicit_intent_btn = (Button) findViewById(R.id.explicit_intent_btn);
		activity_result_btn = (Button) findViewById(R.id.activity_result_btn);

		ViewContacts();
		activityResult();
		
		//We will call second activity.
		
		explicit_intent_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent i=new Intent(Intent_Activity.this,Android_Example_Activity.class);
				startActivity(i);
			}
		});

	}

	@SuppressWarnings("unused")
	private void ViewContacts() {
		try {

			implicit_intent_btn.setOnClickListener(new OnClickListener() {

				@SuppressWarnings("deprecation")
				public void onClick(View v) {
					Intent contacts = new Intent();
					contacts.setAction(android.content.Intent.ACTION_VIEW);
					contacts.setData(People.CONTENT_URI);
					startActivity(contacts);
				}
			});
		} catch (ActivityNotFoundException anfe) {
			Log.e("ViewContacts", "Viewing of Contacts failed", anfe);
		}
	}

	//Activity For Result intent
	
	private void activityResult() {

		activity_result_btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				
				Intent i = new Intent(Intent_Activity.this,Result_Intent_Activity.class);
				startActivityForResult(i, REQUEST_CODE);

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		Log.d("CheckStartActivity", "onActivityResult and resultCode = "+ resultCode);
		
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 1) 
		{
			Toast.makeText(this, "Pass", Toast.LENGTH_LONG).show();
		} 
		else 
		{
			Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
		}
	}
}