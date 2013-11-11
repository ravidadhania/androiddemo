package com.agileinfoways.android_example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.agileinfoways.bean.User_Bean;
import com.agileinfoways.list.ViewAdpter;

public class View_Activity extends Activity {
    /** Called when the activity is first created. */
	ViewAdpter adpter;
	List<User_Bean> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
      
        list=new ArrayList<User_Bean>();
       User_Bean user1=new User_Bean("Jack1","USA","94845545");
       User_Bean user2=new User_Bean("Jack2","USA","94845545");
       User_Bean user3=new User_Bean("Jack3","USA","94845545");
       User_Bean user4=new User_Bean("Jack4","USA","94845545");
       
       list.add(user1);
       list.add(user2);
       list.add(user3);
       list.add(user4);
      
        ListView listview=(ListView)findViewById(R.id.listView1);
        adpter=new ViewAdpter(View_Activity.this, R.layout.listview_item, list);
        listview.setAdapter(adpter);
        
        
    }
    public void detail(View v)
    {
    	LinearLayout l= (LinearLayout) v.getParent();
    	TextView t=(TextView) l.getChildAt(0);
    	String name=t.getText().toString();
    	Toast.makeText(View_Activity.this, name, Toast.LENGTH_LONG).show();
    }
}