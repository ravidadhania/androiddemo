package com.agileinfoways.android_example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Custom_Dialog_Activity extends Activity 
{
	Button yes_btn,cancel_btn;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_dialog);

		yes_btn = (Button) findViewById(R.id.yes_btn);
		cancel_btn = (Button) findViewById(R.id.cancel_btn);
		
		yes_btn.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Custom_Dialog_Activity.this.finish();
			}
		});

		cancel_btn.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Custom_Dialog_Activity.this.finish();
			}
		});
	}
}