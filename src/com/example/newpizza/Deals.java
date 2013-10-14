package com.example.newpizza;

import com.newPizza.order.order;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Deals extends Activity {

    private ViewFlipper viewFlipper;
    private float lastX;
	final Context context = this;
	int count=1;
	int chk=1;
		int x=0;
    	String a=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Remove title bar
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);

    	//Remove notification bar
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deals);
	    Toast.makeText(Deals.this, "Swipe Left & Right", Toast.LENGTH_SHORT).show();

        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
   		Button select_selectBtn=(Button) findViewById(R.id.select_deals);

   		select_selectBtn.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		    	switch(count)
		    	{
		    	case 1:
		    	{
		    		a="Single Slice Deal";
		    		break;
		    	}

		    	case 2:
		    	{
		    		a="Double Slice Deal";
		    		break;
		    	}
		    	case 3:
		    	{
		    		a="Midnight Deal 1";
		    	break;
		    	}
		    	case 4:
		    	{
		    		a="Midnight Deal 2";
		    	break;
		    	}
		    	}

		    	if(order.drinks_order==" ")
			    	   order.deals_order=order.drinks_order.concat(a);
			       else
			    	   order.deals_order=order.drinks_order.concat("\n"+a);		    	
		    	
		    	Intent home=new Intent(Deals.this, Confirm_order.class);
		        startActivity(home);
		    			    }
		}); 

	}
	public boolean onTouchEvent(MotionEvent touchevent) 
    {

                 switch (touchevent.getAction())
                 {
                        // when user first touches the screen to swap
                         case MotionEvent.ACTION_DOWN: 
                         {
                             lastX = touchevent.getX();
                             break;
                        }
                         case MotionEvent.ACTION_UP: 
                         {
                             float currentX = touchevent.getX();
                             
                             // if left to right swipe on screen
                             if (lastX < currentX) 
                             {
                                  // If no more View/Child to flip
                                 if (viewFlipper.getDisplayedChild() == 0)
                                     break;
                                 
                                 // set the required Animation type to ViewFlipper
                                 // The Next screen will come in form Left and current Screen will go OUT from Right 
                                 viewFlipper.setInAnimation(this, R.layout.in_from_left);
                                 viewFlipper.setOutAnimation(this, R.layout.out_to_right);
                                 // Show the next Screen
                                
                                if(count>1)
                                 {
                                	 count--;
                                	 
                                 }
                                 viewFlipper.showNext();
                             }
                             
                             // if right to left swipe on screen
                             if (lastX > currentX)
                             {
                                 if (viewFlipper.getDisplayedChild() == 1)
                                     break;
                                 // set the required Animation type to ViewFlipper
                                 // The Next screen will come in form Right and current Screen will go OUT from Left 
                                 viewFlipper.setInAnimation(this, R.layout.in_from_right);
                                 viewFlipper.setOutAnimation(this, R.layout.out_to_left);
                                 // Show The Previous Screen
                                 
                                	 count++;
                                
                                 
                                 viewFlipper.showPrevious();
                             }
                             break;
                         }
                 }
                 return false;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.deals, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		order.deals_order=" ";
		
    	Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
		vibe.vibrate(50);
		Intent home=new Intent(Deals.this, Category.class);
        startActivity(home);
	}
}
