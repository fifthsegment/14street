package com.example.newpizza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.newPizza.order.order;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Order extends Activity {
	//int no_of_orders=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
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
	    		    	Intent intent_size=new Intent(Order.this, Category.class);
	    		        startActivity(intent_size);
	    		  
		    }
		}); 


		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order, menu);
		return true;
	}
	   

}
