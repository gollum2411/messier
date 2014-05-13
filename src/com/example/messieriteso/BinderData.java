package com.example.messieriteso;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.messieriteso.beans.Object;

public class BinderData extends BaseAdapter {

	LayoutInflater inflater;
	ImageView thumb_image;
	ArrayList<Object> objectCollection;
	ViewHolder holder;
	public BinderData() {
		// TODO Auto-generated constructor stub
	}
	
	public BinderData(Activity act, ArrayList<Object> ob) {
		
		this.objectCollection = ob;
		
		inflater = (LayoutInflater) act
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	

	public int getCount() {
		// TODO Auto-generated method stub
//		return idlist.size();
		return objectCollection.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		 
		View vi=convertView;
	    if(convertView==null){
	     
	      vi = inflater.inflate(R.layout.list_row, null);
	      holder = new ViewHolder();
	     
	      holder.tvMessier = (TextView)vi.findViewById(R.id.tvMessier); // city name
	      holder.tvNgc = (TextView)vi.findViewById(R.id.tvNgc); // city weather overview
	      holder.tvObjectImage =(ImageView)vi.findViewById(R.id.list_image); // thumb image
	 
	      vi.setTag(holder);
	    }
	    else{
	    	holder = (ViewHolder)vi.getTag();
	    }
	    
	      // Setting all values in listview
	      
	      holder.tvMessier.setText(objectCollection.get(position).getMessier());
	      holder.tvNgc.setText(objectCollection.get(position).getNgc());
	     
	      
	      //Setting an image
	      String uri = "drawable/"+ objectCollection.get(position).getPicture_id();
	      int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
	      Drawable image = vi.getContext().getResources().getDrawable(imageResource);
	      holder.tvObjectImage.setImageDrawable(image);
	      
	      return vi;
	}
	
	/*
	 * 
	 * */
	static class ViewHolder{
		
		TextView tvMessier;
		TextView tvNgc;
		ImageView tvObjectImage;
	}
	
}
