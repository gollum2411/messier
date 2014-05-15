package com.example.messieriteso;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class object_activity extends Activity {
	
	String position = "1";
	String messier = "";
	String ngc = "";
	String common = "";
	int picture_id = 0;
	String type = "";
	float distance = 0;
	String constellation = "";
	float apparentm = 0;
	ImageButton imgObjectIcon;
	
	TextView tvmessier;
	TextView tvngc;
	TextView tvcommon;
	TextView tvtype;
	TextView tvdistance;
	TextView tvconstellation;
	TextView tvapparentm;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);
        
		try {
			
			//handle for the UI elements 
			imgObjectIcon = (ImageButton) findViewById(R.id.imageButtonAlpha);
			//Text fields
			tvmessier = (TextView) findViewById(R.id.tvMessier);
			tvngc = (TextView) findViewById(R.id.tvNgc);
			tvcommon = (TextView) findViewById(R.id.tvCommon);
			tvtype = (TextView) findViewById(R.id.tvType);
			tvdistance = (TextView) findViewById(R.id.tvDistance);
			tvconstellation = (TextView) findViewById(R.id.tvConstellation);
			tvapparentm = (TextView) findViewById(R.id.tvApparentm);
			// Get position to display
	        Intent i = getIntent();
	        
	        this.position = i.getStringExtra("position");
	        this.messier = i.getStringExtra("messier");
	        this.ngc=	i.getStringExtra("ngc");
	        this.common =  i.getStringExtra("common");
	        this.type =  i.getStringExtra("type");
	        this.picture_id= i.getIntExtra("picture_id",0);
	        this.distance = i.getFloatExtra("distance", 0);
	        this.constellation = i.getStringExtra("constellation");
	        this.apparentm = i.getFloatExtra("apparentm", 0);
	        
	        String uri = "drawable/messier" + picture_id;
	        int imageBtnResource = getResources().getIdentifier(uri, null, getPackageName());
		    Drawable dimgbutton = getResources().getDrawable(imageBtnResource);
		
		    
		    //text elements
		    tvmessier.setText(messier);
		    tvngc.setText(ngc);
		    tvcommon.setText(common);
		    tvtype.setText(type);
		    tvdistance.setText(Float.toString(distance));
		    tvconstellation.setText(constellation);
		    tvapparentm.setText(Float.toString(apparentm));
		    
		    //thumb_image.setImageDrawable(image);
		    imgObjectIcon.setImageDrawable(dimgbutton);
		
			
		}
		
		catch (Exception ex) {
			Log.e("Error", "Loading exception");
		}
		
    }
	 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}