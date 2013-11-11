package com.agileinfoways.list;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.agileinfoways.android_example.R;
import com.agileinfoways.bean.User_Bean;

public class ViewAdpter  extends ArrayAdapter<User_Bean>
{
	private int resource;
	private List<User_Bean> list;
	
	public ViewAdpter(Context context, int resorce, List<User_Bean> list) 
	{
		super(context, resorce, list);
		this.resource = resorce;
		this.list = list;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ViewHolder holder;
		if (convertView == null)
		{
			LayoutInflater layoutInflater = LayoutInflater.from(getContext());
			convertView  = layoutInflater.inflate(resource, parent, false);
			holder = new ViewHolder();
            holder.textname = (TextView)convertView.findViewById(R.id.textView1);;
            convertView.setTag(holder);
		}
		else 
		{
			 holder=(ViewHolder)convertView.getTag();
		}
		
		holder.textname.setText(list.get(position).getName().toString().replace("/s","'s"));

		return convertView;
	}
	
	public static class ViewHolder
	{
		private TextView textname;
	}
}
