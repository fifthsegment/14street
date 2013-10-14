package com.example.newpizza;

import java.util.ArrayList;

import com.newPizza.order.order;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Pizza_flavor2 extends Activity {
	public final static String[] pizza_flavor_list_static={"Cheese","Chicken Fajita",
		"Chicken Tikka","Ground Beef","Pepperoni","Turkey Chunks","Vegetarian"};
	//ArrayList<String> products = new ArrayList<String>();
	ListView flavor_list;
	ListView flavor_list2;

	ArrayAdapter<String> adaptor;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
				this.requestWindowFeature(Window.FEATURE_NO_TITLE);

				//Remove notification bar
				this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_pizza_flavor2);
				
				flavor_list=(ListView) findViewById(R.id.pizza_flavor2_list1);
				adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,pizza_flavor_list_static);
				flavor_list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				flavor_list.setAdapter(adaptor);

				flavor_list2=(ListView) findViewById(R.id.pizza_flavor2_list2);
				adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,pizza_flavor_list_static);
				flavor_list2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				flavor_list2.setAdapter(adaptor);

				
				//final String flavor;
			 	Button select_veggies=(Button) findViewById(R.id.pizza_flavor2_veggies);
	    		Button select_sauce=(Button) findViewById(R.id.pizza_flavor2_sauce);
	    		Button select_toppings=(Button) findViewById(R.id.pizza_flavor2_toppings);
	    		Button select_flavor=(Button) findViewById(R.id.pizza_flavor2_flavor);
	    		Button select_size=(Button) findViewById(R.id.pizza_flavor2_size);
	    		Button select_reset=(Button) findViewById(R.id.pizza_flavor2_reset);
	    		Button select_done=(Button) findViewById(R.id.pizza_flavor2_done);
	    		Button select_selectBtn=(Button) findViewById(R.id.pizza_flavor2_select);
	    		select_veggies.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {
	    		        //Inform the user the button has been clicked
	    		    	Intent intent_veggies=new Intent(Pizza_flavor2.this, Pizza_veggies.class);
	    		        startActivity(intent_veggies);
	    		    }
	    		}); 

	       		select_sauce.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {
	    		        //Inform the user the button has been clicked
	    		    	Intent intent_sauce=new Intent(Pizza_flavor2.this, Pizza_sauce.class);
	    		        startActivity(intent_sauce);
	    		    }
	    		}); 
	       		select_toppings.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {
	    		        //Inform the user the button has been clicked
	    		    	Intent intent_toppings=new Intent(Pizza_flavor2.this, Pizza_toppings.class);
	    		        startActivity(intent_toppings);
	    		    }
	    		}); 
	       		select_flavor.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {
	    		        //Inform the user the button has been clicked
	    		    	
	    		    }
	    		}); 
	       		select_size.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {
	    		        //Inform the user the button has been clicked
	    		    	   
	    	    		        //Inform the user the button has been clicked
	    	    		    	Intent intent_size=new Intent(Pizza_flavor2.this, Pizza.class);
	    	    		        startActivity(intent_size);
	    	    		  
	    		    }
	    		}); 
		    	final AlertDialog.Builder builder = new AlertDialog.Builder(this);

	       		select_reset.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {
	    		    	order.pizza_size=" ";
    		    		order.pizza_toppings=" ";
    		    		order.pizza_veggies=" ";
    		    		order.pizza_flavor=" ";
    		    		order.pizza_flavor2=" ";
    		    		order.pizza_sauce=" ";
    		    		
    		        	Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
    		    		vibe.vibrate(50);

	    		        builder.setTitle("Confirm");
	    		        builder.setMessage("Are you sure?");

	    		        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

	    		            public void onClick(DialogInterface dialog, int which) {
	    		                // Do nothing but close the dialog

	        		           	Intent intent_reset=new Intent(Pizza_flavor2.this, Pizza.class);
	        		        startActivity(intent_reset);

	    		                dialog.dismiss();
	    		            }

	    		        });

	    		        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

	    		            @Override
	    		            public void onClick(DialogInterface dialog, int which) {
	    		                // Do nothing
	    		                dialog.dismiss();
	    		            }
	    		        });

	    		        AlertDialog alert = builder.create();
	    		        alert.show();
	    		    }
	    		}); 
	        	final AlertDialog.Builder message = new AlertDialog.Builder(this);

	       		select_done.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {
	    		    	SparseBooleanArray checked = flavor_list.getCheckedItemPositions();
	    		        ArrayList<String> selectedItems = new ArrayList<String>();
	    		        for (int i = 0; i < checked.size(); i++) {
	    		            // Item position in adapter
	    		            int position = checked.keyAt(i);
	    		            // Add sport if it is checked i.e.) == TRUE!
	    		            if (checked.valueAt(i))
	    		                selectedItems.add(adaptor.getItem(position));
	    		        }
	    		 
	    		 
	    		        for (int i = 0; i < selectedItems.size(); i++) {
	    		        	order.pizza_flavor = selectedItems.get(i);
	    		        }
	    		        
	    		        
	    		        
	    		        SparseBooleanArray checked2 = flavor_list2.getCheckedItemPositions();
	    		        ArrayList<String> selectedItems2 = new ArrayList<String>();
	    		        for (int i = 0; i < checked2.size(); i++) {
	    		            // Item position in adapter
	    		            int position = checked2.keyAt(i);
	    		            // Add sport if it is checked i.e.) == TRUE!
	    		            if (checked.valueAt(i))
	    		                selectedItems2.add(adaptor.getItem(position));
	    		        }
	    		 
	    		 
	    		        for (int i = 0; i < selectedItems2.size(); i++) {
	    		        	order.pizza_flavor2 = selectedItems2.get(i);
	    		        }
	    		 
	    		    	/*if(x>0)
	    		    	{
	    		    		finish();

	    		    	}
	    		    	else{*/
	    		        if(order.pizza_flavor2==" "||order.pizza_flavor==" ")
	    		        {
	    		        
	    					Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
	    					vibe.vibrate(50);
	    		
	    			    	message.setMessage("").setTitle("Please select 2 flavors for your seleccted pizza")
	    			            .setCancelable(true)
	    			            .setNeutralButton(android.R.string.ok,
	    			               new DialogInterface.OnClickListener() {
	    			               public void onClick(DialogInterface dialog, int whichButton){
	    			               }
	    			               })
	    			            .show();
	    		        }
	    		        else{
	    		    	Intent intent_toppings=new Intent(Pizza_flavor2.this,Pizza_toppings.class);
	    		        startActivity(intent_toppings);
	    		        }
	    		    	//}
	    		         		        
	    		    }
	    		}); 
	       		select_selectBtn.setOnClickListener( new View.OnClickListener() {
	    		    @Override
	    		    public void onClick(View v) {

	    		    	SparseBooleanArray checked = flavor_list.getCheckedItemPositions();
	    		        ArrayList<String> selectedItems = new ArrayList<String>();
	    		        for (int i = 0; i < checked.size(); i++) {
	    		            // Item position in adapter
	    		            int position = checked.keyAt(i);
	    		            // Add sport if it is checked i.e.) == TRUE!
	    		            if (checked.valueAt(i))
	    		                selectedItems.add(adaptor.getItem(position));
	    		        }
	    		 
	    		 
	    		        for (int i = 0; i < selectedItems.size(); i++) {
	    		        	order.pizza_flavor = selectedItems.get(i);
	    		        }
	    		        
	    		        
	    		        
	    		        SparseBooleanArray checked2 = flavor_list2.getCheckedItemPositions();
	    		        ArrayList<String> selectedItems2 = new ArrayList<String>();
	    		        for (int i = 0; i < checked2.size(); i++) {
	    		            // Item position in adapter
	    		            int position = checked2.keyAt(i);
	    		            // Add sport if it is checked i.e.) == TRUE!
	    		            if (checked.valueAt(i))
	    		                selectedItems2.add(adaptor.getItem(position));
	    		        }
	    		 
	    		 
	    		        for (int i = 0; i < selectedItems2.size(); i++) {
	    		        	order.pizza_flavor2 = selectedItems2.get(i);
	    		        }
	    		 
	    		    	/*if(x>0)
	    		    	{
	    		    		finish();

	    		    	}
	    		    	else{*/
	    		        if(order.pizza_flavor2==" " ||order.pizza_flavor==" " )
	    		        {

	    			    	message.setMessage("You Must Select 2 Flavors For Your Selected Pizza").setTitle("Select 2 Flavors")
	    			            .setCancelable(true)
	    			            .setNeutralButton(android.R.string.ok,
	    			               new DialogInterface.OnClickListener() {
	    			               public void onClick(DialogInterface dialog, int whichButton){
	    			               }
	    			               })
	    			            .show();
	    		        }
	    		        else{
	    		    	Intent intent_toppings=new Intent(Pizza_flavor2.this,Pizza_toppings.class);
	    		        startActivity(intent_toppings);
	    		    	}
	    		         		        
	    		    }	    		
	    		    }); 


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pizza_flavor2, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		order.pizza_size=" ";
		order.pizza_toppings=" ";
		order.pizza_veggies=" ";
		order.pizza_flavor=" ";
		order.pizza_flavor2=" ";
		order.pizza_sauce=" ";
    	Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
		vibe.vibrate(50);
	
		Intent home=new Intent(Pizza_flavor2.this, Category.class);
        startActivity(home);
	}
}
