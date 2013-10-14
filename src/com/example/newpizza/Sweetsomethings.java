package com.example.newpizza;

import java.util.ArrayList;

import com.newPizza.order.order;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Sweetsomethings extends Activity {

	public final static String[] sweetsomething_list_static={"Chocolate Cake (Full) - Rs 2099",
		"Chocolate Cake (Slice) - Rs 249"};
	ListView sweetsomething_list;
	ArrayAdapter<String> adaptor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sweetsomethings);
		Button reset_button_drinks= (Button) findViewById(R.id.sweetsomethings_reset);
		Button done_button_drinks= (Button) findViewById(R.id.sweetsomethings_done);
		sweetsomething_list=(ListView) findViewById(R.id.sweetsomethings_menu);
		final ArrayAdapter<String> adaptor=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,sweetsomething_list_static);
		sweetsomething_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		sweetsomething_list.setAdapter(adaptor);
		
		done_button_drinks.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	SparseBooleanArray checked = sweetsomething_list.getCheckedItemPositions();
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
    		        		a = a.concat("\n"+selectedItems.get(i));
    		        }
		       if(order.sweetsomething_order==" ")
		    	   order.sweetsomething_order=order.sweetsomething_order.concat(a);
		       else
		    	   order.sweetsomething_order=order.sweetsomething_order.concat("\n"+a);

		    	   

		    	
		    	Intent intent_confirm=new Intent(Sweetsomethings.this, Confirm_order.class);
		        startActivity(intent_confirm);
		    }
		}); 

    	final AlertDialog.Builder builder = new AlertDialog.Builder(this);

		reset_button_drinks.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	
		    	order.sweetsomething_order=" ";
				Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
				vibe.vibrate(50);
				Intent home=new Intent(Sweetsomethings.this, Category.class);
		        startActivity(home);		    }
		}); 

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sweetsomethings, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		order.sweetsomething_order=" ";
		Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
		vibe.vibrate(50);
		Intent home=new Intent(Sweetsomethings.this, Category.class);
        startActivity(home);
	}

}
