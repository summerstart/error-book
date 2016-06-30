package com.example.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class back extends Activity {
	private  Button btnDO;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	/* requestWindowFeature(Window.FEATURE_NO_TITLE);//»•µÙ±ÍÃ‚
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	           		WindowManager.LayoutParams.FLAG_FULLSCREEN);*/		 
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.back);
	     btnDO=(Button)findViewById(R.id.back_ok);
	     btnDO.setOnClickListener(back);
	 }
	 private Button.OnClickListener back = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(back.this,main.class);
				startActivity(intent);
			}
		};


}
