package com.example.newpizza;

import com.newPizza.order.order;

import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Category extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		Button select_drinks=(Button) findViewById(R.id.drinks_button);
		Button select_sidelines=(Button) findViewById(R.id.sidelines_button);
		Button select_sweetsomething=(Button) findViewById(R.id.sweets_button);
		Button select_pizza=(Button) findViewById(R.id.pizza_button);
		Button select_deal=(Button) findViewById(R.id.deals_button);
		Button select_your_order=(Button) findViewById(R.id.button1);
	
   		Button select_exit=(Button) findViewById(R.id.button_exit);

   		select_exit.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent = new Intent(Category.this, MainActivity.class);
		        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        intent.putExtra("Exit me", true);
		        startActivity(intent);
		        finish();
		    	
		    }
		});
   		
		select_drinks.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_drinks=new Intent(Category.this, Drinks.class);
		        startActivity(intent_drinks);
		    }
		});
		select_your_order.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	order.full_order=order.last_order;
		    	order.x++;
		    	Intent intent_drinks=new Intent(Category.this, Confirm_order.class);
		        startActivity(intent_drinks);
		    	}
		    
		});
		
		select_sidelines.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_sidelines=new Intent(Category.this, Sidelines.class);
		        startActivity(intent_sidelines);
		    }
		});
		select_sweetsomething.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_sidelines=new Intent(Category.this, Sweetsomethings.class);
		        startActivity(intent_sidelines);
		    }
		});
		
		select_drinks.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_drinks=new Intent(Category.this, Drinks.class);
		        startActivity(intent_drinks);
		    }
		});
		select_pizza.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_pizza=new Intent(Category.this, Pizza.class);
		        startActivity(intent_pizza);
		    }
		});

		select_deal.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_deals=new Intent(Category.this, Deals.class);
		        startActivity(intent_deals);
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
		vibe.vibrate(500);
	}

}
