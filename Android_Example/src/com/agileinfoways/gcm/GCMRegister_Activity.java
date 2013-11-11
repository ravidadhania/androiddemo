package com.agileinfoways.gcm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.agileinfoways.android_example.R;
import com.google.android.gcm.GCMRegistrar;

public class GCMRegister_Activity extends Activity 
{
	//ProgressDialog pd;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gcm);

		TextView txt_regid=(TextView)findViewById(R.id.txt_regid);
		
		// Make sure the device has the proper dependencies.
		GCMRegistrar.checkDevice(GCMRegister_Activity.this);
		GCMRegistrar.checkManifest(GCMRegister_Activity.this);
		CommonUtilities.regId = GCMRegistrar.getRegistrationId(GCMRegister_Activity.this);
		GCMRegistrar.register(GCMRegister_Activity.this, CommonUtilities.SENDER_ID);
		Log.e("Reg ID", CommonUtilities.regId);
		
		txt_regid.setText(CommonUtilities.regId);
	}
}