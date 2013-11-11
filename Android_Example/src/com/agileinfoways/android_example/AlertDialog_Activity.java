package com.agileinfoways.android_example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertDialog_Activity extends Activity 
{
	final Context context = this;
	private Button alert_btn, custom_alert_btn, custom_dialog_btn;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alertdialog);

		alert_btn = (Button) findViewById(R.id.alert_btn);
		custom_alert_btn = (Button) findViewById(R.id.custom_alert_btn);
		custom_dialog_btn = (Button) findViewById(R.id.custom_dialog_btn);
		// add button listener
		alert_btn.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) 
			{
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				// set title
				alertDialogBuilder.setTitle("Your Title");
				// set dialog message
				alertDialogBuilder
						.setMessage("Click yes to exit!")
						.setCancelable(false)
						.setPositiveButton("Yes",new DialogInterface.OnClickListener() 
						{
							public void onClick(DialogInterface dialog,int id) 
							{
								// if this button is clicked, close
								// current activity
								AlertDialog_Activity.this.finish();
							}
						})
						.setNegativeButton("No",new DialogInterface.OnClickListener() 
						{
							public void onClick(DialogInterface dialog,int id) 
							{
								dialog.cancel();
							}
						});

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
				// show it
				alertDialog.show();
			}
		});

		// add button listener
		custom_alert_btn.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) 
			{
				// custom dialog
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.activity_custom_alert);
				dialog.setTitle("Title...");
				// set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("Android custom dialog example!");
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						dialog.dismiss();
					}
				});

				dialog.show();
			}
		});

		// add button listener
		custom_dialog_btn.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent custom_intent = new Intent(AlertDialog_Activity.this,Custom_Dialog_Activity.class);
				startActivity(custom_intent);
			}
		});
	}
}