package com.example.book;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class review_set extends Activity {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ������
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	           		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.review_set);
	 }

}
