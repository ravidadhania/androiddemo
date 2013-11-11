package com.agileinfoways.android_example;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.agileinfoways.bean.JSON_Object;
import com.agileinfoways.parsing.Json_Parsing;

public class Json_Parsing_Activity extends Activity {

	private ProgressDialog pdia;
	List<JSON_Object> list;
	private static String url = "http://74.208.77.106/jt/android/json.txt";

	// JSON Node names
	private static final String TAG_CONTACTS = "contacts";
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_EMAIL = "email";
	private static final String TAG_ADDRESS = "address";
	private static final String TAG_GENDER = "gender";
	private static final String TAG_PHONE = "phone";
	private static final String TAG_PHONE_MOBILE = "mobile";
	private static final String TAG_PHONE_HOME = "home";
	private static final String TAG_PHONE_OFFICE = "office";

	// contacts JSONArray
	JSONArray contacts = null;
	String set_text = "";
	TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);
		list = new ArrayList<JSON_Object>();
		tv = (TextView) findViewById(R.id.json_txt);
		new Json_parsing().execute();
	}

	private class Json_parsing extends AsyncTask<String, Void, String> 
	{
		@Override
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pdia = new ProgressDialog(Json_Parsing_Activity.this);
			pdia.setMessage("Loading...");
			pdia.show();
		}

		@Override
		protected String doInBackground(String... params) 
		{
			// Creating JSON Parser instance
			Json_Parsing jParser = new Json_Parsing();

			// getting JSON string from URL
			JSONObject json = jParser.getJSONFromUrl_JsonObject(url);

			try {
				// Getting Array of Contacts
				contacts = json.getJSONArray(TAG_CONTACTS);

				// looping through All Contacts
				for (int i = 0; i < contacts.length(); i++) {
					JSONObject c = contacts.getJSONObject(i);

					// Storing each json item in variable
					String id = c.getString(TAG_ID);
					String name = c.getString(TAG_NAME);
					String email = c.getString(TAG_EMAIL);
					String address = c.getString(TAG_ADDRESS);
					String gender = c.getString(TAG_GENDER);

					// Phone number is agin JSON Object
					JSONObject phone = c.getJSONObject(TAG_PHONE);
					String mobile = phone.getString(TAG_PHONE_MOBILE);
					String home = phone.getString(TAG_PHONE_HOME);
					String office = phone.getString(TAG_PHONE_OFFICE);

					set_text += " \n id : " + id + " \n name : " + name + " \n email : "
							+ email + " \n  \n";

				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			pdia.dismiss();
			tv.setText(set_text);

		}

	}
}