package com.agileinfoways.android_example;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class Context_Menu_Activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu);
		/**
		 * A Button that acts as the view element for the popup menu.
		 */
		final Button btn = (Button) findViewById(R.id.popupMenuBtn);
		/**
		 * Step 1: Create a new instance of popup menu
		 */
		final PopupMenu popupMenu = new PopupMenu(this, btn);
		/**
		 * Step 2: Inflate the menu resource. Here the menu resource is defined
		 * in the res/menu project folder
		 */
		popupMenu.inflate(R.menu.context__menu_);
		/**
		 * Step 3: Call show() method on the popup menu to display the menu when
		 * the button is clicked.
		 */
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				popupMenu.show();
			}
		});
		/**
		 * Handle menu item clicks
		 */
		popupMenu
				.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						case R.id.menu_red:
							btn.setBackgroundColor(android.R.color.holo_red_dark);
							break;
						case R.id.menu_blue:
							btn.setBackgroundColor(android.R.color.holo_blue_bright);
							break;
						case R.id.menu_green:
							btn.setBackgroundColor(android.R.color.holo_green_light);
							break;
						}
						return true;
					}
				});

	}
}
