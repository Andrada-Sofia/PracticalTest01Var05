package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;


public class PracticalTest01Var05MainActivity extends Activity {
	
	 private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 int nrInstr = 0;
	 private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	 
	  private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	     EditText mainText = (EditText)PracticalTest01Var05MainActivity.this.findViewById(R.id.main_text);
	      
	     String directions = mainText.getText().toString();
	     
	     if(view.getId() == R.id.north_button){
	    	 directions = directions.concat("North").concat(", ");
	    	
	    	 mainText.setText(directions);
	     }
	     
	     if(view.getId() == R.id.south_button){
	    	 directions = directions.concat("South").concat(", ");
	    	
	    	 mainText.setText(directions);
	     }
	     
	     if(view.getId() == R.id.east_button){
	    	 directions = directions.concat("East").concat(", ");
	    	 mainText.setText(directions);
	     }
	     
	     if(view.getId() == R.id.west_button){
	    	 directions = directions.concat("West").concat(", ");
	    	 mainText.setText(directions);
	     }
	     
	     if(view.getId() == R.id.navigate_sec_activity_button){
	    	 Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var05SecondaryActivity");
	          intent.putExtra("number_of_clicks",
	            String.valueOf(nrInstr
	            ));
	          startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
	     
	     }
	     
	    }
	  } 
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);
        
        EditText mainText = (EditText) findViewById(R.id.main_text);
        mainText.setText("");
        
        Button northButton = (Button)findViewById(R.id.north_button);
        northButton.setOnClickListener(buttonClickListener);
        
        Button southButton = (Button)findViewById(R.id.south_button);
        southButton.setOnClickListener(buttonClickListener);
        
        Button eastButton = (Button)findViewById(R.id.east_button);
        eastButton.setOnClickListener(buttonClickListener);
        
        Button westButton = (Button)findViewById(R.id.west_button);
        westButton.setOnClickListener(buttonClickListener);
        
        if (savedInstanceState.containsKey("Count"))
      	  nrInstr = savedInstanceState.getInt("Count");
        else
        	nrInstr = 0;
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
      
    	super.onSaveInstanceState(savedInstanceState);
      EditText mainText = (EditText)findViewById(R.id.main_text);
      
      savedInstanceState.putString("mainText", mainText.getText().toString());
      savedInstanceState.putInt("Count", nrInstr);
      
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      
      super.onRestoreInstanceState(savedInstanceState);
      EditText mainText = (EditText)findViewById(R.id.main_text);    
      if (savedInstanceState.getString("mainText") != null) {
          mainText.setText(savedInstanceState.getString("mainText"));
          
          
      } 
      if (savedInstanceState.containsKey("Count")){
    	  nrInstr = savedInstanceState.getInt("Count");
      }
    }
    
    
    
}
