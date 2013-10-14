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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm_order extends Activity  implements
AdapterView.OnItemSelectedListener {
String selection;
String[] items = { "1", "2", "3", "4", 
	"5", "6",
	"7", "8", "9", "10" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
				this.requestWindowFeature(Window.FEATURE_NO_TITLE);

				//Remove notification bar
				this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
				//if(com.newPizza.order.order.x==0)
					//	order.full_order= "PIZZA\n"+order.pizza+"\nSIDELINES\n"+order.sidelines_order+"\nDRINKS\n"+order.drinks_order+"\nSWEETSOMETHINGS\n"+order.sweetsomething_order+"\nDEALS\n"+order.deals_order;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_order);
		
		//selection = (TextView) findViewById(R.id.textView1);

		Spinner spin = (Spinner) findViewById(R.id.spinner);
		spin.setOnItemSelectedListener(this);

		ArrayAdapter aa = new ArrayAdapter(
				this,
				android.R.layout.simple_spinner_item, 
				items);

		aa.setDropDownViewResource(
		   android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(aa);

		
		
		Button confirm=(Button) findViewById(R.id.order_confirmText);
		Button add_itmes=(Button) findViewById(R.id.order_add_other);
		final TextView txt=(TextView) findViewById(R.id.display_order_view);
		txt.setMovementMethod(new ScrollingMovementMethod());


		if(order.pizza!=" ")
			txt.setText(order.pizza);
		else if(order.sidelines_order!=" ")
			txt.setText(order.sidelines_order);
		else if(order.drinks_order!=" ")
			txt.setText(order.drinks_order);
		else if(order.sweetsomething_order!=" ")
			txt.setText(order.sweetsomething_order);
		else if(order.deals_order!=" ")
			txt.setText(order.deals_order);

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
		    	if(order.pizza!=" ")
		    	{

					order.pizza=order.pizza+"   x"+selection+"\n";
					
		    	}
				else if(order.sidelines_order!=" ")
				{
		    		if(order.sidelines_order.contains("\n"))
		    			order.sidelines_order=order.sidelines_order+"   x"+selection+" each\n";

		    		else
		    			order.sidelines_order=order.sidelines_order+"   x"+selection+"\n";
				}
				else if(order.drinks_order!=" ")
				{
					if(order.drinks_order.contains("\n"))
						order.drinks_order=order.drinks_order+"   x"+selection+" each\n";
					else
						order.drinks_order=order.drinks_order+"   x"+selection+"\n";
				}
				else if(order.sweetsomething_order!=" ")
				{
					if(order.sweetsomething_order.contains("\n"))
						order.sweetsomething_order=order.sweetsomething_order+"   x"+selection+" each\n";
					else
						order.sweetsomething_order=order.sweetsomething_order+"   x"+selection+"\n";
				}
				else if(order.deals_order!=" ")
				{
					if(order.deals_order.contains("\n"))
						order.deals_order=order.deals_order+"   x"+selection+" each\n";

					else
						order.deals_order=order.deals_order+"   x"+selection+"\n";
				}

		    	Intent intent_sidelines=new Intent(Confirm_order.this, Category.class);
		        startActivity(intent_sidelines);
		    }
		});

		confirm.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	if(order.pizza!=" ")
		    	{

					order.pizza=order.pizza+"   x"+selection+"\n";
					
		    	}
				else if(order.sidelines_order!=" ")
				{
		    		if(order.sidelines_order.contains("\n"))
		    			order.sidelines_order=order.sidelines_order+"   x"+selection+" each\n";

		    		else
		    			order.sidelines_order=order.sidelines_order+"   x"+selection+"\n";
				}
				else if(order.drinks_order!=" ")
				{
					if(order.drinks_order.contains("\n"))
						order.drinks_order=order.drinks_order+"   x"+selection+" each\n";
					else
						order.drinks_order=order.drinks_order+"   x"+selection+"\n";
				}
				else if(order.sweetsomething_order!=" ")
				{
					if(order.sweetsomething_order.contains("\n"))
						order.sweetsomething_order=order.sweetsomething_order+"   x"+selection+" each\n";
					else
						order.sweetsomething_order=order.sweetsomething_order+"   x"+selection+"\n";
				}
				else if(order.deals_order!=" ")
				{
					if(order.deals_order.contains("\n"))
						order.deals_order=order.deals_order+"   x"+selection+" each\n";

					else
						order.deals_order=order.deals_order+"   x"+selection+"\n";
				}
		    	Intent intent_sidelines=new Intent(Confirm_order.this, Final_order.class);
		        startActivity(intent_sidelines);
		    
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

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {

		selection=items[position];
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

		
	}
	 


}
