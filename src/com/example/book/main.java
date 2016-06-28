package com.example.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class main extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
 // TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);//»•µÙ±ÍÃ‚
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
           		WindowManager.LayoutParams.FLAG_FULLSCREEN);
 super.onCreate(savedInstanceState);
 setContentView(R.layout.main);
	 }

}