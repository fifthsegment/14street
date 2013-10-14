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
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Final_order extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		if(com.newPizza.order.order.x==0)
		{
				order.full_order= "PIZZA\n"+order.pizza+"\nSIDELINES\n"+order.sidelines_order+"\nDRINKS\n"+order.drinks_order+"\nSWEETSOMETHINGS\n"+order.sweetsomething_order+"\nDEALS\n"+order.deals_order;
		
		}
		if(order.full_order.contains(">"))
		{
			order.full_order.replace(">", "\n");
		}
		order.pizza_size=" ";
		order.pizza_toppings=" ";
		order.pizza_veggies=" ";
		order.pizza_flavor=" ";
		order.pizza_sauce=" ";

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_order);
		Button confirm=(Button) findViewById(R.id.final_order_confirmText);
		TextView txt=(TextView) findViewById(R.id.display_final_order_view);
		final EditText etxt=(EditText) findViewById(R.id.editText_final_order);
		txt.setMovementMethod(new ScrollingMovementMethod());


		txt.setText(order.full_order);

    	final AlertDialog.Builder message = new AlertDialog.Builder(this);

		confirm.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	String Orderr=order.full_order+">";
		    	writeToFile(Orderr);
		    	order.full_order=order.full_order+"\n\nAddress\n"+etxt.getText().toString();
		    	if(order.no_of_orders>=7)
		    	{
		    		Intent i = new Intent(Intent.ACTION_SEND);
			    	i.setType("message/rfc822");
			    	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"info@gdgkarachi.com"});
			    	i.putExtra(Intent.EXTRA_SUBJECT, "14th street Urgent order by panic (Entry By NUST SEECS STUDENTS)");
			    	i.putExtra(Intent.EXTRA_TEXT   , order.full_order);
			    	try {
			    	    startActivity(Intent.createChooser(i, "Send mail..."));
			    	} catch (android.content.ActivityNotFoundException ex) {
			    	    Toast.makeText(Final_order.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}
		    	}
		    	else{
		    	Intent i = new Intent(Intent.ACTION_SEND);
		    	i.setType("message/rfc822");
		    	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"info@gdgkarachi.com"});
		    	i.putExtra(Intent.EXTRA_SUBJECT, "14th street normal order (Entry By NUST SEECS STUDENTS)");
		    	i.putExtra(Intent.EXTRA_TEXT   , order.full_order);
		    	try {
		    	    startActivity(Intent.createChooser(i, "Send mail..."));
		    	} catch (android.content.ActivityNotFoundException ex) {
		    	    Toast.makeText(Final_order.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
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
		    	order.pizza_flavor2=" ";

		    	order.pizza_sauce=" ";
		    	order.pizza=" ";
		    	//order.last_order="";
		    	
		    	message.setMessage("Your Order has been dispatched").setTitle("Thanks For Choosing 14th Street Pizza")
		            .setCancelable(true)
		            .setNeutralButton(android.R.string.ok,
		               new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int whichButton){
		            	   Intent intent_flavor=new Intent(Final_order.this, Category.class);
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

	 public void writeToFile(String content) {
	        
		 try {


	        	String separator = ">\n";
	        	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("pizza_book.txt", Context.MODE_APPEND));
	        	
	        	outputStreamWriter.write(order.full_order);
	        	outputStreamWriter.append(separator); // this will add new line ;
	        
	            outputStreamWriter.close();
	            	        }
	        catch (IOException e) {
	            Log.e("error:", "File write failed: " + e.toString());
	        } 

	 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.final_order, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		Intent home=new Intent(Final_order.this, Category.class);
        startActivity(home);
	}

}
