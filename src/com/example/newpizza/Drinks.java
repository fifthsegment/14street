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


public class Drinks extends Activity {
	public final static String[] drink_list_static={"Apple Juice-Rs 60","Coke 1.5L- Rs 100",
			"Coke 500mL-Rs 60","Diet Coke 1.5L - Rs 100","Diet Coke 500ml - Rs 65",
			"Fanta 1.5L - Rs 100","Fanta 500ml - Rs 60","Mango Juice - Rs 60",
			"Minute Maid Orange - Rs 60","Minute Maid Tropical - Rs 60",
			"Orange Juice - Rs 60","Peach Juice - Rs 60","Pineapple Juice - Rs 60",
			"Red Bull - Rs 175","Sprite 1.5L - Rs 100","Sprite 500ml - Rs 60",
			"Sprite Zero 1.5L - Rs 100","Water (500ml) - Rs 40"};
	ListView drinks_list;
	ArrayAdapter<String> adaptor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drinks);
		Button reset_button_drinks= (Button) findViewById(R.id.drinks_reset);
		Button done_button_drinks= (Button) findViewById(R.id.drinks_done);
		drinks_list=(ListView) findViewById(R.id.drinks_menu);
		final ArrayAdapter<String> adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,drink_list_static);
		drinks_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		drinks_list.setAdapter(adaptor);
		done_button_drinks.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	SparseBooleanArray checked = drinks_list.getCheckedItemPositions();
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
		        if(order.drinks_order==" ")
			    	   order.drinks_order=order.drinks_order.concat(a);
			       else
			    	   order.drinks_order=order.drinks_order.concat(","+a);		    	
		    	Intent intent_confirm=new Intent(Drinks.this, Confirm_order.class);
		        startActivity(intent_confirm);
		    }
		}); 

		reset_button_drinks.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	Intent home=new Intent(Drinks.this, Drinks.class);
		        startActivity(home);
		    			    }
		}); 

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drinks, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		Intent home=new Intent(Drinks.this, Category.class);
        startActivity(home);
	}
}
