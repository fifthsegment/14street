package com.example.newpizza;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import com.newPizza.order.order;


public class Panic extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_panic);
		ImageView fb= (ImageView) findViewById(R.id.panic_fb);
		ImageView twitter= (ImageView) findViewById(R.id.panic_twitter);
		ImageView gplus= (ImageView) findViewById(R.id.panic_twitter);
		ImageView order= (ImageView) findViewById(R.id.panic_order);
		ImageView panic= (ImageView) findViewById(R.id.panic_panic);
		
		fb.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/14thstreetpizza"));
		    	startActivity(browserIntent);
		    }
		}); 

   		twitter.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/14thstreetpizza"));
		    	startActivity(browserIntent);
		    }
		}); 
   		gplus.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/104180590689524206732/about"));
		    	startActivity(browserIntent);
		    }
		}); 
   		panic.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	com.newPizza.order.order.full_order=com.newPizza.order.order.last_order;
		    	Intent intent_size=new Intent(Panic.this, Confirm_order.class);
		        startActivity(intent_size);
		  
		    	 
		    	
		    }
		}); 
   		order.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	   
	    		        //Inform the user the button has been clicked
	    		    	Intent intent_size=new Intent(Panic.this, Category.class);
	    		        startActivity(intent_size);
	    		  
		    }
		}); 

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.panic, menu);
		return true;
	}

}
