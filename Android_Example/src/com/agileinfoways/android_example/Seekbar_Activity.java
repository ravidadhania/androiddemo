package com.agileinfoways.android_example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

/*Our activity implements SeekBar.OnSeekBarChangeListener; Basically SeekBar.OnSeekBarChangeListener is a 
 * public static interface that is used to listen the SeekBar events. The SeekBar.OnSeekBarChangeListener
 *  interface allows us to override the below methods.

 onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) – Used to notify that the progress level has changed.
 onStartTrackingTouch(SeekBar seekBar) – Used to notify that the user has started a touch gesture.
 onStopTrackingTouch(SeekBar seekBar) – Used to notify that the user has finished a touch gesture.*/

public class Seekbar_Activity extends Activity 
{
	private SeekBar volumeControl = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seekbar);

		volumeControl = (SeekBar) findViewById(R.id.volume_bar);
		volumeControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			int progressChanged = 0;
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) 
			{
				progressChanged = progress;
			}

			public void onStartTrackingTouch(SeekBar seekBar) 
			{}

			public void onStopTrackingTouch(SeekBar seekBar) 
			{
				Toast.makeText(Seekbar_Activity.this,"seek bar progress:" + progressChanged,Toast.LENGTH_SHORT).show();
			}
		});
	}
}