package com.example.book;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class class_orderactivity extends Activity {
	//1.声明xml文件中的控件的变量
		private Button btnDO;
		private Spinner spnPrefer;
	    private TextView textViewRegister;
	    String[] spots=new String[]{"函数求极限","函数求导","函数的极值","分部求积分法","求定积分","齐次方程的求解"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.class_order);
	 
	 spnPrefer=(Spinner)findViewById(R.id.SpinnerOne);
	// 创建ArrayAdapter
			ArrayAdapter<String> adapterspots = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, spots);
			// 设置Spinner先是格式
			adapterspots
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// 设置Spinner的数据源
			spnPrefer.setAdapter(adapterspots);
			// 设置listener事件
			spnPrefer.setOnItemSelectedListener(spnPreferListener);
	// 2.通过findViewById的方法获取控件组件
	 btnDO = (Button) findViewById(R.id.btn_ok);
     textViewRegister = (TextView) findViewById(R.id.Text_ordername);
	
		// 3.为button组件加入click事件的监听，触发时执行定义方法
		btnDO.setOnClickListener(btnDoListener);
	 }
		// 选择知识点
		private Spinner.OnItemSelectedListener spnPreferListener = new Spinner.OnItemSelectedListener() {
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
	// 实现button的监听函数
		private Button.OnClickListener btnDoListener = new Button.OnClickListener() {
			public void onClick(View v) {
				
				
				Toast.makeText(getApplicationContext(),
						"请选择章节！", 0).show();
				}
			};

}
