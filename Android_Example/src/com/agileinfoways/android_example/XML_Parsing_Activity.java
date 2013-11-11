package com.agileinfoways.android_example;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.agileinfoways.bean.Study;
import com.agileinfoways.xm.sax.StudyParser_Sax;
import com.agileinfoways.xml.pull.StudyParser_Pull;

public class XML_Parsing_Activity extends Activity implements OnClickListener 
{
	Button sax_btn, pull_btn;
	TextView parser_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xml);

		sax_btn = (Button) findViewById(R.id.sax_btn);
		pull_btn = (Button) findViewById(R.id.pull_btn);
		parser_text = (TextView) findViewById(R.id.parser_text);
	}

	@Override
	protected void onResume() 
	{
		super.onResume();
		sax_btn.setOnClickListener(this);
		pull_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		switch (v.getId()) 
		{
		case R.id.sax_btn:
			Study study = null;
			try 
			{
				study = StudyParser_Sax.parse(getAssets().open("record_sax.xml"));
			}
			catch (IOException e) 
			{
				Log.d("XML", "onCreate(): parse() failed");
				return;
			}

			String output = "";
			output += "Study ID: " + study.mId + "\n";
			output += "Topic: " + study.mTopic + "\n";
			output += "Content: " + study.mContent + "\n";
			output += "Author: " + study.mAuthor + "\n";
			output += "Date: " + study.mDate + "\n";

			parser_text.setText(output);

			break;
		case R.id.pull_btn:
			Study study_pull = null;
			try 
			{
				study_pull = StudyParser_Pull.parse(getAssets().open("record_pull.xml"));
			} 
			catch (IOException e) 
			{
				Log.d("XML", "onCreate(): parse() failed");
				return;
			}

			String output_pull = "";
			output_pull += "Study ID: " + study_pull.mId + "\n";
			output_pull += "Topic: " + study_pull.mTopic + "\n";
			output_pull += "Content: " + study_pull.mContent + "\n";
			output_pull += "Author: " + study_pull.mAuthor + "\n";
			output_pull += "Date: " + study_pull.mDate + "\n";

			parser_text.setText(output_pull);
			break;
		}
	}
}
