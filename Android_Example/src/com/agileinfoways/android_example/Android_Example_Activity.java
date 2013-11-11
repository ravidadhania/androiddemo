package com.agileinfoways.android_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.agileinfoways.gcm.GCMRegister_Activity;
import com.agileinfoways.sharedpref.Shared_Pref_Activity;

public class Android_Example_Activity extends Activity implements
		OnClickListener {

	Button intent_btn,date_picker_btn, time_picker_btn, spinner_btn, webview_btn,
			popup_btn, button_design_btn, seekbar_btn, list_view, json_btn,
			xml_btn, tab_btn, map_btn, alert_btn, shared_btn, gcm_btn,
			facebook_btn, noti_btn,content_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android_example);

	
		intent_btn = (Button) findViewById(R.id.intent_btn);
		date_picker_btn = (Button) findViewById(R.id.date_picker_btn);
		time_picker_btn = (Button) findViewById(R.id.time_picker_btn);
		spinner_btn = (Button) findViewById(R.id.spinner_btn);
		webview_btn = (Button) findViewById(R.id.web_view_btn);
		popup_btn = (Button) findViewById(R.id.popup_btn);
		button_design_btn = (Button) findViewById(R.id.button_event_design_btn);
		seekbar_btn = (Button) findViewById(R.id.seekbar_btn);
		list_view = (Button) findViewById(R.id.list_view_btn);
		json_btn = (Button) findViewById(R.id.json_btn);
		xml_btn = (Button) findViewById(R.id.xml_btn);
		tab_btn = (Button) findViewById(R.id.tab_btn);
		map_btn = (Button) findViewById(R.id.map_btn);
		alert_btn = (Button) findViewById(R.id.alert_btn);
		shared_btn = (Button) findViewById(R.id.shared_btn);
		gcm_btn = (Button) findViewById(R.id.gcm_btn);
		facebook_btn = (Button) findViewById(R.id.facebook_btn);
		noti_btn= (Button) findViewById(R.id.noti_btn);
		content_btn= (Button) findViewById(R.id.content_btn);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		intent_btn.setOnClickListener(this);
		date_picker_btn.setOnClickListener(this);
		time_picker_btn.setOnClickListener(this);
		spinner_btn.setOnClickListener(this);
		webview_btn.setOnClickListener(this);
		popup_btn.setOnClickListener(this);
		button_design_btn.setOnClickListener(this);
		seekbar_btn.setOnClickListener(this);
		list_view.setOnClickListener(this);
		json_btn.setOnClickListener(this);
		xml_btn.setOnClickListener(this);
		tab_btn.setOnClickListener(this);
		map_btn.setOnClickListener(this);
		alert_btn.setOnClickListener(this);
		gcm_btn.setOnClickListener(this);
		facebook_btn.setOnClickListener(this);
		noti_btn.setOnClickListener(this);
		shared_btn.setOnClickListener(this);
		content_btn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.android__example_, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.intent_btn:
			Intent intent = new Intent(
					Android_Example_Activity.this, Intent_Activity.class);
			startActivity(intent);
			break;
		case R.id.date_picker_btn:
			Intent intent_date_picker = new Intent(
					Android_Example_Activity.this, Date_Picker_Activity.class);
			startActivity(intent_date_picker);
			break;
		case R.id.time_picker_btn:
			Intent intent_time_picker = new Intent(
					Android_Example_Activity.this, Time_Picker_Activity.class);
			startActivity(intent_time_picker);
			break;
		case R.id.spinner_btn:
			Intent intent_spinner = new Intent(Android_Example_Activity.this,
					Spinner_Activity.class);
			startActivity(intent_spinner);
			break;

		case R.id.web_view_btn:
			Intent intent_webveiw = new Intent(Android_Example_Activity.this,
					WebView_Activity.class);
			startActivity(intent_webveiw);
			break;
		case R.id.popup_btn:
			Intent intent_popup = new Intent(Android_Example_Activity.this,
					Context_Menu_Activity.class);
			startActivity(intent_popup);
			break;
		case R.id.button_event_design_btn:
			Intent intent_button = new Intent(Android_Example_Activity.this,
					Button_Custom_Activity.class);
			startActivity(intent_button);
			break;
		case R.id.seekbar_btn:
			Intent intent_seekbar = new Intent(Android_Example_Activity.this,
					Seekbar_Activity.class);
			startActivity(intent_seekbar);
			break;
		case R.id.list_view_btn:
			Intent intent_listView = new Intent(Android_Example_Activity.this,
					View_Activity.class);
			startActivity(intent_listView);
			break;

		case R.id.json_btn:
			Intent intent_json = new Intent(Android_Example_Activity.this,
					Json_Parsing_Activity.class);
			startActivity(intent_json);
			break;

		case R.id.xml_btn:
			Intent intent_xml = new Intent(Android_Example_Activity.this,
					XML_Parsing_Activity.class);
			startActivity(intent_xml);
			break;

		case R.id.tab_btn:
			Intent intent_tab = new Intent(Android_Example_Activity.this,
					Tab_Activity.class);
			startActivity(intent_tab);
			break;

		/*case R.id.map_btn:
			Intent intent_map = new Intent(Android_Example_Activity.this,
					Mapview_Activity.class);
			startActivity(intent_map);
			break;*/
		case R.id.alert_btn:
			Intent intent_alert = new Intent(Android_Example_Activity.this,
					AlertDialog_Activity.class);
			startActivity(intent_alert);
			break;
		case R.id.shared_btn:
			Intent intent_shared = new Intent(Android_Example_Activity.this,
					Shared_Pref_Activity.class);
			startActivity(intent_shared);
			break;
		case R.id.gcm_btn:
			Intent intent_gcm = new Intent(Android_Example_Activity.this,
					GCMRegister_Activity.class);
			startActivity(intent_gcm);
			break;
		case R.id.facebook_btn:
			Intent intent_facebook = new Intent(Android_Example_Activity.this,
					Facebook_Key_Activity.class);
			startActivity(intent_facebook);
			break;
		case R.id.noti_btn:
			Intent intent_noti = new Intent(Android_Example_Activity.this,
					Notification_Activity.class);
			startActivity(intent_noti);
			break;
			
		case R.id.content_btn:
			Intent intent_content = new Intent(
					Android_Example_Activity.this, Content_Provider_Activity.class);
			startActivity(intent_content);
			break;

		}

	}

}
