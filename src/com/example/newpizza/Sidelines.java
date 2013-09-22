package com.example.newpizza;

import java.util.ArrayList;

import com.newPizza.order.order;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Sidelines extends Activity {
	public final static String[] sidelines_list_static={"Cheesy Bread - Rs 129",
		"Chicken Wings (BBQ) - Rs 229","Chicken Wings (Crispy) - Rs 229",
		"Chicken Wings (Spicy) - Rs 229","Chicky Bites (NonSpicy) - Rs 229",
		"Chicky Bites (Spicy) - Rs 229","Garlic Bread - Rs 129",
		"Potato Skins - Rs 129","Potato Wedges - Rs 129"};
	ListView sidelines_list;
	ArrayAdapter<String> adaptor;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sidelines);
		Button reset_button_sidelines= (Button) findViewById(R.id.sidelines_reset);
		Button done_button_sidelines= (Button) findViewById(R.id.sidelines_done);
		
		sidelines_list=(ListView) findViewById(R.id.sidelines_menu);
		final ArrayAdapter<String> adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,sidelines_list_static);
		sidelines_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		sidelines_list.setAdapter(adaptor);
		done_button_sidelines.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	SparseBooleanArray checked = sidelines_list.getCheckedItemPositions();
		        ArrayList<String> selectedItems = new ArrayList<String>();
		        for (int i = 0; i < checked.size(); i++) {
		            // Item position in adapter
		            int position = checked.keyAt(i);
		            // Add sport if it is checked i.e.) == TRUE!
		            if (checked.valueAt(i))
		                selectedItems.add(adaptor.getItem(position));
		        }
		 
		        String a = null;
		 
		        for (int i = 0; i < selectedItems.size(); i++) {
		        	
    		        	if(i==0)
    		        		a=selectedItems.get(i);
    		        	else
    		        		a = a.concat(","+selectedItems.get(i));
    		        }
		        
		        if(order.sidelines_order==" ")
			    	   order.sidelines_order=order.sidelines_order.concat(a);
			       else
			    	   order.sidelines_order=order.sidelines_order.concat(","+a);				    	
		    	Intent intent_confirm=new Intent(Sidelines.this, Confirm_order.class);
		        startActivity(intent_confirm);
		    }
		}); 

		reset_button_sidelines.setOnClickListener( new View.OnClickListener() {
			@Override
		    public void onClick(View v) {

			    
			        //Inform the user the button has been clicked
			    	Intent home=new Intent(Sidelines.this, Sidelines.class);
			        startActivity(home);
			}
			    			    
	});

	
}
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.sidelines, menu);
			return true;
		}
		@Override
		public void onBackPressed() {
			Intent home=new Intent(Sidelines.this, Category.class);
	        startActivity(home);
		}
	}