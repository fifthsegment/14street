package com.example.newpizza;

import java.io.IOException;
import java.io.OutputStreamWriter;

import com.newPizza.order.order;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm_order extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
				this.requestWindowFeature(Window.FEATURE_NO_TITLE);

				//Remove notification bar
				this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

				order.full_order= "PIZZA: "+order.pizza+",SIDELINES: "+order.sidelines_order+",DRINKS: "+order.drinks_order+"SWEETSOMETHINGS: "+order.sweetsomething_order+"DEALS: "+order.deals_order;
				

				order.pizza_size=" ";
				order.pizza_toppings=" ";
				order.pizza_veggies=" ";
				order.pizza_flavor=" ";
				order.pizza_sauce=" ";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_order);
		
		Button confirm=(Button) findViewById(R.id.order_confirmText);
		Button add_itmes=(Button) findViewById(R.id.order_add_other);
		TextView txt=(TextView) findViewById(R.id.display_order_view);
		txt.setText(order.full_order);
		/*confirm.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_sidelines=new Intent(Confirm_order.this, Sidelines.class);
		        startActivity(intent_sidelines);
		    }
		});*/
		add_itmes.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent intent_sidelines=new Intent(Confirm_order.this, Category.class);
		        startActivity(intent_sidelines);
		    }
		});
    	final AlertDialog.Builder message = new AlertDialog.Builder(this);

		confirm.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	
		    	writeToFile(order.full_order);
		    	if(order.no_of_orders>=7)
		    	{
		    		Intent i = new Intent(Intent.ACTION_SEND);
			    	i.setType("message/rfc822");
			    	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"11besemidrees@gmail.com@gmail.com"});
			    	i.putExtra(Intent.EXTRA_SUBJECT, "14th street Urgent order by panic");
			    	i.putExtra(Intent.EXTRA_TEXT   , order.full_order);
			    	try {
			    	    startActivity(Intent.createChooser(i, "Send mail..."));
			    	} catch (android.content.ActivityNotFoundException ex) {
			    	    Toast.makeText(Confirm_order.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
			    	}
		    	}
		    	else{
		    	Intent i = new Intent(Intent.ACTION_SEND);
		    	i.setType("message/rfc822");
		    	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mujtabaidrees@gmail.com"});
		    	i.putExtra(Intent.EXTRA_SUBJECT, "14th street normal order");
		    	i.putExtra(Intent.EXTRA_TEXT   , order.full_order);
		    	try {
		    	    startActivity(Intent.createChooser(i, "Send mail..."));
		    	} catch (android.content.ActivityNotFoundException ex) {
		    	    Toast.makeText(Confirm_order.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		    	}
		    	}
		    	order.full_order=" ";
		    	order.pizza_size=" ";
		    	order.drinks_order=" ";
		    	order.sidelines_order=" ";
		    	order.sweetsomething_order=" ";
		    	order.deals_order=" ";
		    	order.full_order=" ";
		    	order.pizza_toppings=" ";
		    	order.pizza_veggies=" ";
		    	order.pizza_flavor=" ";
		    	order.pizza_sauce=" ";
		    	order.pizza=" ";
		    	//order.last_order="";
		    	
		    	message.setMessage("Your Order has been dispatched").setTitle("Thanks For Choosing 14th Street Pizza")
		            .setCancelable(true)
		            .setNeutralButton(android.R.string.ok,
		               new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int whichButton){
		            	   Intent intent_flavor=new Intent(Confirm_order.this, Category.class);
		   		        startActivity(intent_flavor);
		               }
		               })
		            .show();
		          
		        //Inform the user the button has been clicked
		    	/*
		    	Intent intent_sidelines=new Intent(Confirm_order.this, Category.class);
		        startActivity(intent_sidelines);*/
		    }
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirm_order, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		Intent home=new Intent(Confirm_order.this, Category.class);
        startActivity(home);
	}
	 public void writeToFile(String content) {
	        
		 try {


	        	String separator = System.getProperty("line.separator");
	        	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("abc.txt", Context.MODE_APPEND));
	        	
	        	outputStreamWriter.write(order.full_order);
	        	outputStreamWriter.append(separator); // this will add new line ;
	        
	            outputStreamWriter.close();
	            	        }
	        catch (IOException e) {
	            Log.e("error:", "File write failed: " + e.toString());
	        } 

}
	 


}
