package com.agileinfoways.sharedpref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.agileinfoways.android_example.R;

public class Shared_Pref_Activity extends Activity implements OnClickListener {

    private EditText mInputEditText;
    private TextView mOutputView;
    private Button mSaveButton;
    private Button mShowButton;
    private Button mDeleteButton;
    private Button mClearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref);
        mInputEditText = (EditText) findViewById(R.id.pref_editText);
        mSaveButton = (Button) findViewById(R.id.save_button);
        mShowButton = (Button) findViewById(R.id.show_button);
        mDeleteButton = (Button) findViewById(R.id.delete_button);
        mOutputView = (TextView) findViewById(R.id.pref_textView);
        mClearButton = (Button) findViewById(R.id.clear_button);
        mSaveButton.setOnClickListener(this);
        mShowButton.setOnClickListener(this);
        mDeleteButton.setOnClickListener(this);
        mClearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) 
    {
        String message="";
        switch (v.getId()) 
        {
            case R.id.save_button:
                SavePreferences("PrefDemo", mInputEditText.getText().toString());
                message="Text Saved in Preferences";
                break;
            case R.id.delete_button:
                deletePreferences("PrefDemo");
                message = "Text Deleted from Preferences";
                break;
            case R.id.show_button:
                showPreferences("PrefDemo");
                message="Text Displayed from Preferences";
                break;
            case R.id.clear_button:
                clearAllPreferences();
                message="Removed All Text from All Preferences";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void SavePreferences(String key, String value) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void deletePreferences(String key) 
    {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }
    
    private void clearAllPreferences() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
    private void showPreferences(String key)
    {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedPref = sharedPreferences.getString(key, "");
        mOutputView.setText(savedPref);
    }
}
