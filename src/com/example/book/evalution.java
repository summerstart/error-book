package com.example.book;


import com.example.book.utils.text_evalution;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class evalution extends Activity {
	//1.声明xml文件中的控件的变量
	    private EditText error_date;
	    private EditText error_time ;
		private Button bt1;
		private Spinner spnPrefer1;
		private Spinner spnPrefer2;
		private Spinner spnPrefer3;
		private Spinner spnPrefer4;
	    private TextView textViewRegister;
	   String[] type=new String[]{"选择题","填空题","应用题","问答题","综合题"};
	    String[] section=new String[]{"第一章","第二章","第三章","第四章","第五章","第六章","第七章"};
	    String[] reason=new String[]{"看错了","写错了","已学知识的遗忘","未掌握典型思路","缺乏课后巩固练习","理解能力不够","解题思路狭隘"};
	    String[] point=new String[]{"函数求极限","函数求导","函数的极值","分部求积分法","求定积分","齐次方程的求解"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.review_content);
    // mySQLite = new MySQLite(this, "managedb", 1);
    
     bt1=(Button)findViewById(R.id.rigs_start);
     bt1.setOnClickListener(start);
     error_date=(EditText) findViewById(R.id.radio_year);
     error_time=(EditText) findViewById(R.id.radio_date);
     spnPrefer2=(Spinner)findViewById(R.id.Spinnerfourteen);
	 spnPrefer1=(Spinner)findViewById(R.id.Spinnerthirty);
	 spnPrefer3=(Spinner)findViewById(R.id.Spinnerfifteen);
	 spnPrefer4=(Spinner)findViewById(R.id.Spinnersixteen);
	// 创建ArrayAdapter
			ArrayAdapter<String> adaptertype = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, type);
		  ArrayAdapter<String> adaptersection = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, section);
		  ArrayAdapter<String> adapterreason = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, reason);
		  ArrayAdapter<String> adapterpoint = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, point);
			// 设置Spinner先是格式
			adaptertype
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adaptersection
		         .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adapterreason
			.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	       adapterpoint
             .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// 设置Spinner的数据源
			spnPrefer1.setAdapter(adaptertype);
			spnPrefer2.setAdapter(adaptersection);
			spnPrefer3.setAdapter(adapterreason);
			spnPrefer4.setAdapter(adapterpoint);
			// 设置listener事件
			spnPrefer1.setOnItemSelectedListener(spnPrefer1Listener);
			spnPrefer2.setOnItemSelectedListener(spnPrefer2Listener);
			spnPrefer3.setOnItemSelectedListener(spnPrefer3Listener);
			spnPrefer4.setOnItemSelectedListener(spnPrefer4Listener);
	// 2.通过findViewById的方法获取控件组件
	 //bt1 = (Button) findViewById(R.id.btn_ok);
     //textViewRegister = (TextView) findViewById(R.id.Text_ordername);
	
		// 3.为button组件加入click事件的监听，触发时执行定义方法
        /*bt1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String year=error_date.getText().toString();
				String timestr=error_time.getText().toString();
				Log.i("TAG",year+"_"+timestr);
				text_evalution uService=new text_evalution(evalution.this);
				boolean flag=uService.select(year,timestr );
				if(flag){
					//jumpToMenu();
					Intent intent=new Intent(evalution.this,start.class);
					startActivity(intent);
				}else{
					Log.i("TAG","复习失败");
					Toast.makeText(evalution.this, "查询失败", Toast.LENGTH_LONG).show();
				}
			}
		});*/
	}
	
	 
		// 选择知识点
		private Spinner.OnItemSelectedListener spnPrefer1Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};
	private Spinner.OnItemSelectedListener spnPrefer2Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};
		private Spinner.OnItemSelectedListener spnPrefer3Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};
		private Spinner.OnItemSelectedListener spnPrefer4Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};

		private Button.OnClickListener start = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(evalution.this,start.class);
				startActivity(intent);
			}
		};
}


