package com.example.book;


import com.example.book.user.In_error;
import com.example.book.utils.error_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Input_error1 extends Activity { 
	 private EditText texterror;
	 private EditText experience;
	 private EditText analysis;
	Button keep;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.input_error1);
		findViews();
		keep.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String error=texterror.getText().toString().trim();
				String txtexperience=experience.getText().toString().trim();
				String txtanalysis=analysis.getText().toString().trim();
				Log.i("TAG",error+"_"+txtexperience+"_"+txtanalysis);
				error_service eService=new error_service(Input_error1.this);
				In_error u=new In_error();
				u.setTexterror(error);
				u.setExperience(txtexperience);
				u.setAnalysis(txtanalysis);
		    	eService.entering(u);
				System.out.print("rrrrrr");
				Toast.makeText(Input_error1.this, "±£´æ³É¹¦", Toast.LENGTH_LONG).show();
				Intent intent=new Intent();
				intent.setClass(Input_error1.this,main.class);
				startActivity(intent);
			}
		});
		
	}
	private void findViews() {
		texterror=(EditText) findViewById(R.id.Text_Error);
		experience=(EditText) findViewById(R.id.Txt_Experience);
		analysis=(EditText) findViewById(R.id.Answer_Analysis);
		keep=(Button) findViewById(R.id.Text_Keep);
	}
	
}


