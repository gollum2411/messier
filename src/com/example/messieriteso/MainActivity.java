package com.example.messieriteso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

import com.example.messieriteso.beans.Object;
import com.example.messieriteso.database.DataBaseHandler;
import com.example.messieriteso.database.ObjectControl;



public class MainActivity extends Activity {
	
	protected ListView list;
	protected BinderData binder;
	protected DataBaseHandler dh;
	protected ArrayList<Object> object_list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		dh = DataBaseHandler.getInstance(this);
		
		try {
			dh.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ObjectControl obj_ctrl = new ObjectControl();
		
		object_list = obj_ctrl.getObjectsWhere(null, null, dh);
		
		list = (ListView) findViewById(R.id.list);
		
		BinderData binder = new BinderData(this, object_list);
		
		
		Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

		list.setAdapter(binder);

		Log.i("AFTER", "<<------------- After SetAdapter-------------->>");
		
		list.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent i = new Intent();
				i.setClass(MainActivity.this, object_activity.class);

				// parameters
				i.putExtra("position", String.valueOf(position + 1));
				
				
				i.putExtra("messier", object_list.get(position).getMessier());
				i.putExtra("ngc", object_list.get(position).getNgc());
				i.putExtra("common", object_list.get(position).getCommon());
				i.putExtra("picture_id", object_list.get(position).getPicture_id());
				i.putExtra("type", object_list.get(position).getType());
				i.putExtra("distance", object_list.get(position).getDistance());
				i.putExtra("constellation", object_list.get(position).getConstellation());
				i.putExtra("apparentm", object_list.get(position).getApparentm());

				// start the object activity
				startActivity(i);
			}
		});
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
