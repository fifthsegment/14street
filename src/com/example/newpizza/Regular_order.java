package com.example.newpizza;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Regular_order extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regular_order);
		ImageView fb= (ImageView) findViewById(R.id.panic_fb);
		ImageView twitter= (ImageView) findViewById(R.id.main_twitter);
		ImageView gplus= (ImageView) findViewById(R.id.main_gplus);
		ImageView order= (ImageView) findViewById(R.id.main_order);
		
		fb.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    }
		}); 

   		twitter.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	
		    }
		}); 
   		gplus.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    
		    }
		}); 
   	 
   		order.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	   
	    		        //Inform the user the button has been clicked
	    		    	Intent intent_size=new Intent(Regular_order.this, Category.class);
	    		        startActivity(intent_size);
	    		  
		    }
		}); 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regular_order, menu);
		return true;
	}

}
