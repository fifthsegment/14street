package com.example.newpizza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.newPizza.order.order;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		search();
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Thread timedelay=new Thread(){
			public void run(){
				try{
					sleep(2000);
				} catch (InterruptedException e){
					
				}finally {
					if(order.no_of_orders>=7){
					Intent intent=new Intent(MainActivity.this,Panic.class);
					startActivity(intent);
					}
					else
					{

						Intent intent=new Intent(MainActivity.this,Category.class);
						startActivity(intent);
					}
				}
			}
		};
		timedelay.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void search() {
        String receiveString = "";
        //String last="";
        
        
	  try {
		 
          InputStream inputStream = openFileInput("abc.txt");
           
          if ( inputStream != null) {
              InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
              BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
           
              StringBuilder stringBuilder = new StringBuilder();
               
              while ( (receiveString = bufferedReader.readLine() )!= null) {
            	  order.last_order=receiveString;
            	  order.no_of_orders++;
              }
              
              inputStream.close();
              
          }
      }
      catch (FileNotFoundException e) {
          Log.e("err", "File not found: " + e.toString());
      } catch (IOException e) {
          Log.e("err", "Can not read file: " + e.toString());
      }
	}
   

}
