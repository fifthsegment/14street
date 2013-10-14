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
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

public class Pizza_veggies extends Activity {
	Point p;
	public final static String[] pizza_veggies_list_static={"Onions","Tomatoes","Capsicum","Jalapenoes",
		"Mushrooms","Red Chilli","Green Chilli","Olives"};
	ListView veggies_list;
	ArrayAdapter<String> adaptor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pizza_veggies);
		veggies_list=(ListView) findViewById(R.id.pizza_veggies_list);
		final ArrayAdapter<String> adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,pizza_veggies_list_static);
		veggies_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		veggies_list.setAdapter(adaptor);
		Button select_veggies=(Button) findViewById(R.id.pizza_veggies_veggies);
		Button select_sauce=(Button) findViewById(R.id.pizza_veggies_sauce);
		Button select_toppings=(Button) findViewById(R.id.pizza_veggies_toppings);
		Button select_flavor=(Button) findViewById(R.id.pizza_veggies_flavor);
		Button select_size=(Button) findViewById(R.id.pizza_veggies_size);
		Button select_reset=(Button) findViewById(R.id.pizza_veggies_reset);
		Button select_done=(Button) findViewById(R.id.pizza_veggies_done);
		Button select_selectBtn=(Button) findViewById(R.id.pizza_veggies_select);
	
		select_veggies.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    
		    }
		}); 

   		select_sauce.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	/*Intent intent_sauce=new Intent(Pizza_veggies.this, Pizza_sauce.class);
		        startActivity(intent_sauce);*/
		    	Intent i = new Intent(Pizza_veggies.this, Pizza_sauce.class);
		    	i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		    	startActivity(i);
		    }
		}); 
   		select_toppings.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	/*Intent intent_toppings=new Intent(Pizza_veggies.this, Pizza_toppings.class);
		        startActivity(intent_toppings);*/
		    	Intent i = new Intent(Pizza_veggies.this, Pizza_toppings.class);
		    	i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		    	startActivity(i);
		    }
		}); 
   		select_flavor.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		      	/*Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza_flavor.class);
		        startActivity(intent_flavor);*/
		    	Intent i = new Intent(Pizza_veggies.this, Pizza_flavor.class);
		    	i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		    	startActivity(i);
		    }
		}); 
   		select_size.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	   
	    		        //Inform the user the button has been clicked
	    		    	Intent intent_size=new Intent(Pizza_veggies.this, Pizza.class);
	    		        startActivity(intent_size);
	    		  
		    }
		}); 
    	final AlertDialog.Builder builder = new AlertDialog.Builder(this);

   		select_reset.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
            	Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
        		vibe.vibrate(50);
        		Intent home=new Intent(Pizza_veggies.this, Category.class);
                startActivity(home);
        	
		        builder.setTitle("Confirm");
		        builder.setMessage("Are you sure?");

		        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

		            public void onClick(DialogInterface dialog, int which) {
		                // Do nothing but close the dialog

						order.pizza_size=" ";
						order.pizza_toppings=" ";
						order.pizza_veggies=" ";
						order.pizza_flavor=" ";
						order.pizza_flavor2=" ";
						order.pizza_sauce=" ";
    		           	Intent intent_reset=new Intent(Pizza_veggies.this, Pizza.class);
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
   		
    	final AlertDialog.Builder errbox = new AlertDialog.Builder(this);

   		select_done.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	int x = 0;
		    	SparseBooleanArray checked = veggies_list.getCheckedItemPositions();
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
		        		order.pizza_veggies=selectedItems.get(i);
		        	else
		        	order.pizza_veggies = order.pizza_veggies.concat("/"+selectedItems.get(i));
		       		        }
		        if(true){

		           /* if(order.pizza_veggies==" ")
			        {
			            errbox.setMessage("Please select pizza veggies").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	
			               }
			               })
			            .show();
			            x=1;

		        }*/
		            if(order.pizza_sauce==" ")
			        {
			            errbox.setMessage("Please select pizza sauce").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza_sauce.class);
			   		        startActivity(intent_flavor);
			               }
			               })
			            .show();
			            x=1;


		        }
		           /* if(order.pizza_toppings==" ")
			        {
			            errbox.setMessage("Please select pizza Toppings").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	   order.pizza_toppings="/";
			            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza_toppings.class);
			   		        startActivity(intent_flavor);
			               }
			               })
			            .show();
			            x=1;
			            

		        }*/

		        if(order.pizza_flavor==" ")
		        {
		            errbox.setMessage("Please select pizza flavor").setTitle("Order Not Completed Yet")
		            .setCancelable(true)
		            .setNeutralButton(android.R.string.ok,
		               new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int whichButton){
		            	   order.pizza_flavor="/";

		            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza_flavor.class);
		   		        startActivity(intent_flavor);
		               }
		               })
		            .show();
		            x=1;

		        }

		            
		            if(order.pizza_size==" ")
			        {
			            errbox.setMessage("Please select pizza size").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	   order.pizza_size="/";
			            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza.class);
			   		        startActivity(intent_flavor);
			               }
			               })
			            .show();
			            x=1;


		        }
		       }
		            if(x!=1){

		            	if(order.pizza_flavor==" ")
		            		order.pizza=order.pizza.concat("Size="+order.pizza_size+";Flavor="+order.pizza_flavor+";Toppings="+order.pizza_toppings+";Sauce="+order.pizza_sauce+";Veggies="+order.pizza_veggies);
		            	else
		            		order.pizza=order.pizza.concat("Size="+order.pizza_size+";Flavor1="+order.pizza_flavor+";Flavor2="+order.pizza_flavor2+";Toppings="+order.pizza_toppings+";Sauce="+order.pizza_sauce+";Veggies="+order.pizza_veggies);
		       // order.pizza_veggies=outputStrArr[0];
		        Intent intent_confirm=new Intent(Pizza_veggies.this, Confirm_order.class);
		        startActivity(intent_confirm);
		            }
		    }
		}); 
    	//new AlertDialog.Builder(this)

   		select_selectBtn.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	int x = 0;
		    	SparseBooleanArray checked = veggies_list.getCheckedItemPositions();
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
		        		order.pizza_veggies=selectedItems.get(i);
		        	else
		        	order.pizza_veggies = order.pizza_veggies.concat("/"+selectedItems.get(i));
		       		        }
		        if(true){

		           /* if(order.pizza_veggies==" ")
			        {
			            errbox.setMessage("Please select pizza veggies").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	
			               }
			               })
			            .show();
			            x=1;

		        }*/
		            if(order.pizza_sauce==" ")
			        {
			            errbox.setMessage("Please select pizza sauce").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	   order.pizza_toppings="/";

			            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza_sauce.class);
			   		        startActivity(intent_flavor);
			               }
			               })
			            .show();
			            x=1;


		        }
		           /* if(order.pizza_toppings==" ")
			        {
			            errbox.setMessage("Please select pizza Toppings").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	   order.pizza_toppings="/";
			            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza_toppings.class);
			   		        startActivity(intent_flavor);
			               }
			               })
			            .show();
			            x=1;
			            

		        }
*/
		        if(order.pizza_flavor==" ")
		        {
		            errbox.setMessage("Please select pizza flavor").setTitle("Order Not Completed Yet")
		            .setCancelable(true)
		            .setNeutralButton(android.R.string.ok,
		               new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int whichButton){
		            	   order.pizza_flavor="/";

		            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza_flavor.class);
		   		        startActivity(intent_flavor);
		               }
		               })
		            .show();
		            x=1;

		        }

		            
		            if(order.pizza_size==" ")
			        {
			            errbox.setMessage("Please select pizza size").setTitle("Order Not Completed Yet")
			            .setCancelable(true)
			            .setNeutralButton(android.R.string.ok,
			               new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int whichButton){
			            	   order.pizza_size="/";
			            	   Intent intent_flavor=new Intent(Pizza_veggies.this, Pizza.class);
			   		        startActivity(intent_flavor);
			               }
			               })
			            .show();
			            x=1;


		        }
		       }
		            if(x!=1){
		            	
		            	if(order.pizza_flavor==" ")
		            		order.pizza=order.pizza.concat("Size="+order.pizza_size+";Flavor="+order.pizza_flavor+";Toppings="+order.pizza_toppings+";Sauce="+order.pizza_sauce+";Veggies="+order.pizza_veggies);
		            	else
		            		order.pizza=order.pizza.concat("Size="+order.pizza_size+";Flavor1="+order.pizza_flavor+";Flavor2="+order.pizza_flavor2+";Toppings="+order.pizza_toppings+";Sauce="+order.pizza_sauce+";Veggies="+order.pizza_veggies);

		            	// order.pizza_veggies=outputStrArr[0];
		        Intent intent_confirm=new Intent(Pizza_veggies.this, Confirm_order.class);
		        startActivity(intent_confirm);
		            }
		    }
		}); 

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pizza_veggies, menu);
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
		Intent home=new Intent(Pizza_veggies.this, Category.class);
        startActivity(home);
	
	}
	
}





