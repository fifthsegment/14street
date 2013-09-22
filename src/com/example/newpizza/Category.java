package com.example.newpizza;

import com.newPizza.order.order;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
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
		Button selectfb=(Button) findViewById(R.id.button2);
		Button selecttwitter=(Button) findViewById(R.id.button3);
		Button selectgplus=(Button) findViewById(R.id.button4);


		select_drinks.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_drinks=new Intent(Category.this, Drinks.class);
		        startActivity(intent_drinks);
		    }
		});
		selectfb.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/14thstreetpizza"));
		    	startActivity(browserIntent);
		    }
		});
		selecttwitter.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/14thstreetpizza"));
		    	startActivity(browserIntent);
		    }
		});
		selectgplus.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/104180590689524206732/about"));
		    	startActivity(browserIntent);
		    }
		});
		select_your_order.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	if(order.full_order==" ");
		    	else{
		    	Intent intent_drinks=new Intent(Category.this, Confirm_order.class);
		        startActivity(intent_drinks);
		    	}
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
		Intent home=new Intent(Category.this, Category.class);
        startActivity(home);
	}

}
