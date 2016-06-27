package com.example.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class classify extends Activity {
	 /*
	 private Button btnChinese,btnmath, btnenglish;
		private Button btnphysics,btnchemistry, btnbiology;*/
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
		
		/* btnChinese = (Button) findViewById(R.id.button_Chinese);
		 btnmath = (Button) findViewById(R.id.button_math);
		 btnenglish = (Button) findViewById(R.id.button_english);
		 btnphysics = (Button) findViewById(R.id.button_physics);
		 btnchemistry = (Button) findViewById(R.id.button_chemistry);
		 btnbiology = (Button) findViewById(R.id.button_biology);*/
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.classify);
	     
	    /* OnClickListener btnChineseListener = null;
		btnChinese.setOnClickListener( btnChineseListener);     
	     btnChinese.setOnClickListener(new OnClickListener() 
		   {
	    	public void onClick(View v)
			     
			       {
				       Intent intent = new Intent();
		               intent.setClass(classify.this,main.class);
		               startActivity(intent);
			       }
		      });*/
	 
	 }

}
