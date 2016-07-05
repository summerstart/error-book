package com.example.book;


import com.example.book.user.In_error;
import com.example.book.utils.error_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Input_error1 extends Activity { 
	 private EditText texterror;
	 private EditText experience;
	 private EditText analysis;
	Button keep;
	private Spinner spnPreferlevel;
	String[] level=new String[]{"完全不会","掌握较差","基本掌握","掌握较好","完全掌握"}; 
	private Spinner levels;
	private TextView levelss;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.input_error1);
		spnPreferlevel=(Spinner)findViewById(R.id.SpinnerThirteen);
		ArrayAdapter<String> adapterlevel = new ArrayAdapter<String>(this,
 				android.R.layout.simple_spinner_item,level);
		adapterlevel
	      .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnPreferlevel.setAdapter(adapterlevel);
		spnPreferlevel.setOnItemSelectedListener(spnPreferencelevelListener);	
		
		levels=(Spinner) findViewById(R.id.SpinnerThirteen);
		
		findViews();
		keep.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				String level=levels.getSelectedItem().toString().trim();
				String error=texterror.getText().toString().trim();
				String txtexperience=experience.getText().toString().trim();
				String txtanalysis=analysis.getText().toString().trim();
				Log.i("TAG",level+"_"+error+"_"+txtexperience+"_"+txtanalysis);
				error_service eService=new error_service(Input_error1.this);
				In_error u=new In_error();
				u.setLeveltext(level);
				u.setTexterror(error);
				u.setExperience(txtexperience);
				u.setAnalysis(txtanalysis);
		    	eService.entering(u);
				System.out.print("rrrrrr");
				Toast.makeText(Input_error1.this, "保存成功", Toast.LENGTH_LONG).show();
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
		levels=(Spinner)findViewById(R.id.SpinnerThirteen);
	}
	private Spinner.OnItemSelectedListener spnPreferencelevelListener = new Spinner.OnItemSelectedListener() {
		
		 //定义Spinner的监听事件函数
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//弹出所选择的对应章节信息
			String sel=parent.getSelectedItem().toString();
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};
	
}


