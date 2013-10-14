package com.example.newpizza;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class Address extends Activity {
	 private GoogleMap googleMap;
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_address);
	 
	        try {
	            // Loading map
	            initilizeMap();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	    }
	 
	    private void initilizeMap() {
	        if (googleMap == null) {
	            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
	                    R.id.map)).getMap();
	 
	            // check if map is created successfully or not
	            if (googleMap == null) {
	                Toast.makeText(getApplicationContext(),
	                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
	                        .show();
	            }
	        }
	    }
	    
	    @Override
	    protected void onResume() {
	        super.onResume();
	        initilizeMap();
	    }
	/*@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.address, menu);
		return true;
	}*/

}
