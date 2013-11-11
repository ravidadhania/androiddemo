package com.agileinfoways.android_example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

public class Facebook_Key_Activity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gcm);
		
		TextView tv=(TextView)findViewById(R.id.txt_regid);
		
		PackageInfo info;
		try 
		{
		    info = getPackageManager().getPackageInfo("com.agileinfoways.android_example", PackageManager.GET_SIGNATURES);
		    for (Signature signature : info.signatures) 
		    {
		        MessageDigest md;
		        md = MessageDigest.getInstance("SHA");
		        md.update(signature.toByteArray());
		        String something = new String(Base64.encode(md.digest(), 0));
		        //String something = new String(Base64.encodeBytes(md.digest()));
		        tv.setText(something);
		        Log.e("hash key", something);
		    }
		} 
		catch (NameNotFoundException e1) 
		{
		    Log.e("name not found", e1.toString());
		} 
		catch (NoSuchAlgorithmException e) 
		{
		    Log.e("no such an algorithm", e.toString());
		} 
		catch (Exception e) 
		{
		    Log.e("exception", e.toString());
		}
	}
}