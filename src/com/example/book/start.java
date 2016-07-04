package com.example.book;

import com.example.book.utils.MySQLite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends Activity{
	private  Button btnDO;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	/* requestWindowFeature(Window.FEATURE_NO_TITLE);//»•µÙ±ÍÃ‚
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	           		WindowManager.LayoutParams.FLAG_FULLSCREEN);*/		 
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.start);
	     btnDO=(Button)findViewById(R.id.text_btn2);
	     btnDO.setOnClickListener(start);
	 }
	 private Button.OnClickListener start = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(start.this,main.class);
				startActivity(intent);
			}
		};


}

