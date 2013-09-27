package com.home.androidhacks;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.AndroidCharacter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView _list;
	String[] items = new String[]{"Hack01","Hack02","Hack03"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		_list = (ListView)findViewById(R.id.list);
		
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,items);
		_list.setAdapter(adapter);
		_list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				/*
				Intent intent=null;
				switch(arg2){
				case 0:
					intent = new Intent(MainActivity.this,Hack01.class);
					break;
				}
				startActivity(intent);
				*/
				String className ="com.home.androidhacks."+ items[arg2];
				Class<?> c = null;
				if (className!=null){
					try{
						c = Class.forName(className);
						
					}catch(Exception e){
						//nothing;
					}
					Intent intent = new Intent(MainActivity.this,c);
					startActivity(intent);
				}
			}});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
