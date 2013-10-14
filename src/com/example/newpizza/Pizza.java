package com.example.newpizza;
import com.newPizza.*;
import com.newPizza.order.order;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Pizza extends Activity 
{
            private ViewFlipper viewFlipper;
            private float lastX;
        	final Context context = this;
        	int count=1;
        	int chk=1;
       		int x=0;
       		int half_flavor=0;

            @Override
            protected void onCreate(Bundle savedInstanceState) 
            {
            	//Remove title bar
            	this.requestWindowFeature(Window.FEATURE_NO_TITLE);

            	//Remove notification bar
            	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_pizza);
               viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
            Button select_veggies=(Button) findViewById(R.id.pizza_size_veggies);
       		Button select_sauce=(Button) findViewById(R.id.pizza_size_sauce);
       		Button select_toppings=(Button) findViewById(R.id.pizza_size_toppings);
       		Button select_flavor=(Button) findViewById(R.id.pizza_size_flavor);
       		Button select_size=(Button) findViewById(R.id.pizza_size_size);
       		Button select_reset=(Button) findViewById(R.id.pizza_size_reset);
       		Button select_done=(Button) findViewById(R.id.pizza_size_done);
       		Button select_selectBtn=(Button) findViewById(R.id.pizza_size_select);

       		ImageView select_Next= (ImageView) findViewById(R.id.imageNext);
       		ImageView select_Prev= (ImageView) findViewById(R.id.imagePrev);

    		if(order.pizza_size!=" ")
    			x++;
    		
    		select_veggies.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    	Intent intent_drinks=new Intent(Pizza.this, Pizza_veggies.class);
    		        startActivity(intent_drinks);
    		    }
    		}); 
       		select_Next.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
                     // Show The Previous Screen
    		    	 
                           // If no more View/Child to flip

   		    	 if (viewFlipper.getDisplayedChild() == 1);
   		    	 else{
                        
                    // set the required Animation type to ViewFlipper
                    // The Next screen will come in form Right and current Screen will go OUT from Left 
                    left_right();
                    // Show The Previous Screen
                    
                   	 count++;
                     viewFlipper.showPrevious();

   		    	 }
                    
   		    	
   		   
   		    }                               
  
                     
    		    
    		}); 
       		select_Prev.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
                    // Show the next Screen
    		    	  if (viewFlipper.getDisplayedChild() == 0);
                      else{
                      
                      // set the required Animation type to ViewFlipper
                      // The Next screen will come in form Left and current Screen will go OUT from Right 
                      right_left();
                      // Show the next Screen
                     
                     if(count>1)
                      {
                     	 count--;
                     	 
                      }
                      viewFlipper.showNext();

                      }
    		    }    
    		}); 

       		
       		select_sauce.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    	Intent intent_drinks=new Intent(Pizza.this, Pizza_sauce.class);
    		        startActivity(intent_drinks);
    		    }
    		}); 
       		select_toppings.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    	Intent intent_drinks=new Intent(Pizza.this, Pizza_toppings.class);
    		        startActivity(intent_drinks);
    		    }
    		}); 
       		select_flavor.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    	Intent intent_drinks=new Intent(Pizza.this, Pizza_flavor.class);
    		        startActivity(intent_drinks);
    		    }
    		}); 
       		select_size.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		        //Inform the user the button has been clicked
    		    
    		    }
    		}); 
	    	final AlertDialog.Builder builder = new AlertDialog.Builder(this);

       		select_reset.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		    	Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
    				vibe.vibrate(50);

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
        		           	Intent intent_drinks=new Intent(Pizza.this, Category.class);
        		        startActivity(intent_drinks);

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
    		        //Inform the user the button has been clicked
    		    	switch(count)
    		    	{
    		    	case 1:
    		    	{
    		    		order.pizza_size="Slice";
    		    		break;
    		    	}

    		    	case 2:
    		    	{
    		    		order.pizza_size="Half";
    		    		break;
    		    	}
    		    	case 3:
    		    	{
    		    		order.pizza_size="Split-Half";
    		    		half_flavor++;
    		    	break;
    		    	}
    		    	case 4:
    		    	{
    		    		order.pizza_size="Half&Half";
    		    		half_flavor++;

    		    	break;
    		    	}
    		    	case 5:
    		    		{
    		    			order.pizza_size="Full";
    		    		break;
    		    		}
    		    	}

    		    	if(half_flavor>0)
    		    	{

        		    	Intent intent_pizza=new Intent(Pizza.this, Pizza_flavor2.class);
        		        startActivity(intent_pizza);
    		    	}
    		    	else{
    		    	Intent intent_pizza=new Intent(Pizza.this, Pizza_flavor.class);
    		        startActivity(intent_pizza);
    		    	}
    		        
    		    }
    		}); 
       		select_selectBtn.setOnClickListener( new View.OnClickListener() {
    		    @Override
    		    public void onClick(View v) {
    		    	
    		        //Inform the user the button has been clicked
    		    	switch(count)
    		    	{
    		    	case 1:
    		    	{
    		    		order.pizza_size="Slice";
    		    		break;
    		    	}

    		    	case 2:
    		    	{
    		    		order.pizza_size="Half";
    		    		break;
    		    	}
    		    	case 3:
    		    	{
    		    		order.pizza_size="Split-Half";
    		    		half_flavor++;
    		    	break;
    		    	}
    		    	case 4:
    		    	{
    		    		order.pizza_size="Half&Half";
    		    		half_flavor++;

    		    	break;
    		    	}
    		    	case 5:
    		    		{
    		    			order.pizza_size="Full";
    		    		break;
    		    		}
    		    	}

    		    	if(half_flavor>0)
    		    	{

        		    	Intent intent_pizza=new Intent(Pizza.this, Pizza_flavor2.class);
        		        startActivity(intent_pizza);
    		    	}
    		    	else{
    		    	Intent intent_pizza=new Intent(Pizza.this, Pizza_flavor.class);
    		        startActivity(intent_pizza);
    		    	}
    		        
    		    }    	
    		    }); 
            }

            

		public void left_right()
		{
			 viewFlipper.setInAnimation(this, R.layout.in_from_left);
             viewFlipper.setOutAnimation(this, R.layout.out_to_right);
            
			}

		public void right_left()
		{
			viewFlipper.setInAnimation(this, R.layout.in_from_right);
            viewFlipper.setOutAnimation(this, R.layout.out_to_left);
            
			}


            // Method to handle touch event like left to right swap and right to left swap
          /*  public boolean onTouchEvent(MotionEvent touchevent) 
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
            }*/
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
        		Intent home=new Intent(Pizza.this, Category.class);
                startActivity(home);
        	}

 }