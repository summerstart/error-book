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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class class_orderactivity extends Activity {
	//1.声明xml文件中的控件的变量
		private Button btnDO;
		private Spinner spnPrefer1;
		private Spinner spnPrefer2;
	    private TextView textViewRegister;
	    private EditText errortitle;
	    private Spinner Spots;
	    private Spinner Master;
	   String[] master=new String[]{"完全不会","掌握较差","基本掌握","掌握较好","完全掌握"};
	    String[] spots=new String[]{"函数求极限","函数求导","函数的极值","分部求积分法","求定积分","齐次方程的求解"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.class_order);
	 findViews();
	 }
	private void findViews() {
			// TODO Auto-generated method stub	
		Spots=(Spinner)findViewById(R.id.SpinnerOne);
		Master=(Spinner)findViewById(R.id.SpinnerTwo);
	 spnPrefer2=(Spinner)findViewById(R.id.SpinnerTwo);
	 spnPrefer1=(Spinner)findViewById(R.id.SpinnerOne);
	 errortitle=(EditText) findViewById(R.id.editText1);
	 btnDO=(Button) findViewById(R.id.btn_ok);
	// 创建ArrayAdapter
			ArrayAdapter<String> adapterspots = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, spots);
		  ArrayAdapter<String> adaptermaster = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, master);
			// 设置Spinner先是格式
			adapterspots
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adaptermaster
		         .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// 设置Spinner的数据源
			spnPrefer1.setAdapter(adapterspots);
			spnPrefer2.setAdapter(adaptermaster);
			// 设置listener事件
			spnPrefer1.setOnItemSelectedListener(spnPrefer1Listener1);
			spnPrefer2.setOnItemSelectedListener(spnPrefer1Listener1);
		// 3.为button组件加入click事件的监听，触发时执行定义方法
	
	btnDO.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			 String spots =(Spots).getSelectedItem().toString().trim();
			 String master =(Master).getSelectedItem().toString().trim();
			 Log.i("TAG",spots+"_"+master);
				error_service uService=new error_service(class_orderactivity.this);
				boolean flag=uService.select(spots, master);
				if(flag){
					//jumpToMenu();	
					//将查询结果显示在edittext里面
					 //String name = select.cursor.getString(cursor.getColumnIndex("列的名称"));
					
					Log.i("TAG","查询成功");
					Toast.makeText(class_orderactivity.this, "查询成功", Toast.LENGTH_LONG).show();
					Intent intent=new Intent(class_orderactivity.this,classify.class);
					startActivity(intent);
					//MainActivity.this.finish();
				}else{
					Log.i("TAG","查询失败");
					Toast.makeText(class_orderactivity.this, "查询失败", Toast.LENGTH_LONG).show();
				}
		}	
	});	
	}
		
		// 选择知识点
		private Spinner.OnItemSelectedListener spnPrefer1Listener1 = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {
            //String sel = parent.getSelectedItem().toString();
            //调用In_error表中的掌握程度        
			}
						@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"请选择章节！", 0).show();

			}
		};
		private Spinner.OnItemSelectedListener spnPrefer1Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {
				String sel = parent.getSelectedItem().toString();
				
			}			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"请选择类型！", 0).show();
			}
		};
}