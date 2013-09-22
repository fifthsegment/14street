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
import android.widget.ListView;

public class Pizza_toppings extends Activity {
	public final static String[] pizza_toppings_list_static={"Extra Meat","Extra Cheese",
		"Sweet Corn","Pineapple"};
	ListView toppings_list;
	ArrayAdapter<String> adaptor;
	int x=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
				this.requestWindowFeature(Window.FEATURE_NO_TITLE);

				//Remove notification bar
				this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_pizza_toppings);
				 toppings_list=(ListView) findViewById(R.id.pizza_toppings_list);
				 adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,pizza_toppings_list_static);
				 toppings_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				 toppings_list.setAdapter(adaptor);
				 if(order.pizza_toppings!=" ")
		    			x++;

				 Button select_veggies=(Button) findViewById(R.id.pizza_toppings_veggies);
		    		Button select_sauce=(Button) findViewById(R.id.pizza_toppings_sauce);
		    		Button select_toppings=(Button) findViewById(R.id.pizza_toppings_toppings);
		    		Button select_flavor=(Button) findViewById(R.id.pizza_toppings_flavor);
		    		Button select_size=(Button) findViewById(R.id.pizza_toppings_size);
		    		Button select_reset=(Button) findViewById(R.id.pizza_toppings_reset);
		    		Button select_done=(Button) findViewById(R.id.pizza_toppings_done);
		    		Button select_selectBtn=(Button) findViewById(R.id.pizza_toppings_select);
		    		select_veggies.setOnClickListener( new View.OnClickListener() {
		    		    @Override
		    		    public void onClick(View v) {
		    		        //Inform the user the button has been clicked
		    		    	Intent intent_veggies=new Intent(Pizza_toppings.this, Pizza_veggies.class);
		    		        startActivity(intent_veggies);
		    		    }
		    		}); 

		       		select_sauce.setOnClickListener( new View.OnClickListener() {
		    		    @Override
		    		    public void onClick(View v) {
		    		        //Inform the user the button has been clicked
		    		    	Intent intent_sauce=new Intent(Pizza_toppings.this, Pizza_sauce.class);
		    		        startActivity(intent_sauce);
		    		    }
		    		}); 
		       		select_toppings.setOnClickListener( new View.OnClickListener() {
		    		    @Override
		    		    public void onClick(View v) {
		    		        //Inform the user the button has been clicked
		    		  
		    		    }
		    		}); 
		       		select_flavor.setOnClickListener( new View.OnClickListener() {
		    		    @Override
		    		    public void onClick(View v) {
		    		        //Inform the user the button has been clicked
		    		      	/*Intent intent_flavor=new Intent(Pizza_toppings.this, Pizza_flavor.class);
		    		        startActivity(intent_flavor);*/
		    		    	Intent i = new Intent(Pizza_toppings.this, Pizza_flavor.class);
		    		    	i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		    		    	startActivity(i);

		    		    }
		    		}); 
		       		select_size.setOnClickListener( new View.OnClickListener() {
		    		    @Override
		    		    public void onClick(View v) {
		    		        //Inform the user the button has been clicked
		    		    	   
		    	    		        //Inform the user the button has been clicked
		    	    		    	Intent intent_size=new Intent(Pizza_toppings.this, Pizza.class);
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
		        		           	Intent intent_reset=new Intent(Pizza_toppings.this, Pizza.class);
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
		    		    	SparseBooleanArray checked = toppings_list.getCheckedItemPositions();
		    		        ArrayList<String> selectedItems = new ArrayList<String>();
		    		        for (int i = 0; i < checked.size(); i++) {
		    		            // Item position in adapter
		    		            int position = checked.keyAt(i);
		    		            // Add sport if it is checked i.e.) == TRUE!
		    		            if (checked.valueAt(i))
		    		                selectedItems.add(adaptor.getItem(position));
		    		        }
		    		 
		    		        String[] outputStrArr = new String[selectedItems.size()];
		    		 //String a="";
		    		        for (int i = 0; i < selectedItems.size(); i++) {
		    		        	if(i==0)
		    		        		order.pizza_toppings=selectedItems.get(i);
		    		        	else
		    		        		order.pizza_toppings = order.pizza_toppings.concat("/"+selectedItems.get(i));
		    		        }
		    		       // order.pizza_toppings=outputStrArr[0];
		    		        
		    		    	if(x>0)
		    		    	{
		    		    		finish();

		    		    	}
		    		    	else{
		    		    	Intent intent_toppings=new Intent(Pizza_toppings.this,Pizza_sauce.class);
		    		        startActivity(intent_toppings);
		    		    	}
		    		  
		    		         		        
		    		    }
		    		}); 
		       		select_selectBtn.setOnClickListener( new View.OnClickListener() {
		    		    @Override
		    		    public void onClick(View v) {
		    		    	SparseBooleanArray checked = toppings_list.getCheckedItemPositions();
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
		    		        	
			    		        	if(i==0)
			    		        		order.pizza_toppings=selectedItems.get(i);
			    		        	else
			    		        		order.pizza_toppings = order.pizza_toppings.concat("/"+selectedItems.get(i));
			    		        }
		    		        
		    		       // order.pizza_toppings=outputStrArr[0];

		    		    	if(x>0)
		    		    	{
		    		    		finish();

		    		    	}
		    		    	else{
		    		    	Intent intent_toppings=new Intent(Pizza_toppings.this,Pizza_sauce.class);
		    		        startActivity(intent_toppings);
		    		    	}
		    		  
		    		    }
		    		}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pizza_toppings, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		Intent home=new Intent(Pizza_toppings.this, Category.class);
        startActivity(home);
	}

}
