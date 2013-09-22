package com.example.newpizza;

import java.util.ArrayList;


import com.newPizza.order.order;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Pizza_flavor extends Activity {
	public final static String[] pizza_flavor_list_static={"Cheese","Chicken Fajita",
		"Chicken Tikka","Ground Beef","Pepperoni","Turkey Chunks","Vegetarian"};
	//ArrayList<String> products = new ArrayList<String>();
	ListView flavor_list;
	ArrayAdapter<String> adaptor;
	int x=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if(order.pizza_flavor!=" ")
			x++;
   		
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pizza_flavor);
		flavor_list=(ListView) findViewById(R.id.pizza_flavor_list);
		adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,pizza_flavor_list_static);
		flavor_list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		flavor_list.setAdapter(adaptor);
		
		//final String flavor;
		 	Button select_veggies=(Button) findViewById(R.id.pizza_flavor_veggies);
    		Button select_sauce=(Button) findViewById(R.id.pizza_flavor_sauce);
    		Button select_toppings=(Button) findViewById(R.id.pizza_flavor_toppings);
    		Button select_flavor=(Button) findViewById(R.id.pizza_flavor_flavor);
    		Button select_size=(Button) findViewById(R.id.pizza_flavor_size);
    		Button select_reset=(Button) findViewById(R.id.pizza_flavor_reset);
    		Button select_done=(Button) findViewById(R.id.pizza_flavor_done);
    		Button select_selectBtn=(Button) findViewById(R.id.pizza_flavor_select);
    		select_veggies.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    	Intent intent_veggies=new Intent(Pizza_flavor.this, Pizza_veggies.class);
    		        startActivity(intent_veggies);
    		    }
    		}); 

       		select_sauce.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    	Intent intent_sauce=new Intent(Pizza_flavor.this, Pizza_sauce.class);
    		        startActivity(intent_sauce);
    		    }
    		}); 
       		select_toppings.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    	Intent intent_toppings=new Intent(Pizza_flavor.this, Pizza_toppings.class);
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
    	    		    	Intent intent_size=new Intent(Pizza_flavor.this, Pizza.class);
    	    		        startActivity(intent_size);
    	    		  
    		    }
    		}); 
	    	final AlertDialog.Builder builder = new AlertDialog.Builder(this);

       		select_reset.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		    	

    		        builder.setTitle("Confirm");
    		        builder.setMessage("Are you sure?");

    		        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

    		            public void onClick(DialogInterface dialog, int which) {
    		                // Do nothing but close the dialog

    						order.pizza_size=" ";
    						order.pizza_toppings=" ";
    						order.pizza_veggies=" ";
    						order.pizza_flavor=" ";
    						order.pizza_sauce=" ";
        		           	Intent intent_reset=new Intent(Pizza_flavor.this, Pizza.class);
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
    		 
    		        String[] outputStrArr = new String[selectedItems.size()];
    		 
    		        for (int i = 0; i < selectedItems.size(); i++) {
    		            outputStrArr[i] = selectedItems.get(i);
    		        }
    		        order.pizza_flavor=outputStrArr[0];
    		    	if(x>0)
    		    	{
    		    		finish();

    		    	}
    		    	else{
    		    	Intent intent_toppings=new Intent(Pizza_flavor.this,Pizza_toppings.class);
    		        startActivity(intent_toppings);
    		    	}
    		         		        
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
    		 
    		        String[] outputStrArr = new String[selectedItems.size()];
    		 
    		        for (int i = 0; i < selectedItems.size(); i++) {
    		        	//String a=selectedItems.get(i);
    		        	order.pizza_flavor = selectedItems.get(i);
    		        }
    		    	if(x>0)
    		    	{
    		    		finish();

    		    	}
    		    	else{
    		    	Intent intent_toppings=new Intent(Pizza_flavor.this,Pizza_toppings.class);
    		        startActivity(intent_toppings);
    		    	}
    		    }
    		}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pizza_flavor, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		Intent home=new Intent(Pizza_flavor.this, Category.class);
        startActivity(home);
	}
}
