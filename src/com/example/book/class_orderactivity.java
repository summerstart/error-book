package com.example.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.book.user.In_error;
import com.example.book.utils.Text_error;
import com.example.book.utils.UserService;
import com.example.book.utils.error_service;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class class_orderactivity extends  ListActivity implements OnClickListener{
	//1.声明xml文件中的控件的变量
		private Button btnDO;
		private Button select;
		private Spinner spnPrefer1;
		private Spinner spnPrefer2;
	    private SimpleAdapter sa;
	    private SQLiteDatabase db = null;
	   private EditText error_content;
	   private List list=null;
	   private ListView listt;
	   String[] master=new String[]{"完全不会","掌握较差","基本掌握","掌握较好","完全掌握"};
	    String[] spots=new String[]{"第一章","第二章","第三章","第四章","第五章","第六章","第七章"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.class_order);	
	   
	  listt=(ListView) findViewById(R.id.list);
	   
	   spnPrefer1=(Spinner)findViewById(R.id.SpinnerOne);
	   spnPrefer2=(Spinner)findViewById(R.id.SpinnerTwo);
	   btnDO=(Button) findViewById(R.id.btn_ok);
	   btnDO.setOnClickListener(mainlistner);
	   select=(Button) findViewById(R.id.select);
	   select.setOnClickListener(this);
	   Text_error myHelper = new Text_error(class_orderactivity.this);
		db = myHelper.getWritableDatabase();
	//设置适配器，用于显示数据库内容
		/*list = chaxun();
			 System.out.println("heheheheheehe  " + list.get(0));
			sa = new SimpleAdapter(class_orderactivity.this, list, R.layout.item,
				new String[] { "text_error" }, new int[] { R.id.item_list });
			setListAdapter(sa);*/
		

	// 创建ArrayAdapter
			ArrayAdapter<String> adapterspots = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, spots);
			ArrayAdapter<String> adaptermasters = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, master);
			// 设置Spinner先是格式
			adapterspots
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adaptermasters
			.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// 设置Spinner的数据源
			spnPrefer1.setAdapter(adapterspots);
			spnPrefer2.setAdapter(adaptermasters);
			// 设置listener事件
			spnPrefer1.setOnItemSelectedListener(spnPrefer1Listener1);
			spnPrefer2.setOnItemSelectedListener(spnPrefer1Listener2);
	
}
	 public List chaxun() {

			ArrayList list = new ArrayList();
			//游标选择操作
			
			String txt_section=spnPrefer1.getSelectedItem().toString();
			//Log.i("TAG",txt_error);
			error_service eService=new error_service(class_orderactivity.this);
			boolean flag=eService.select(txt_section);
			if(flag){
				//jumpToMenu();	
				Log.i("TAG","查找成功");
				Toast.makeText(class_orderactivity.this, "查找成功", Toast.LENGTH_LONG).show();
				//SQLiteDatabase sdb=terror.getReadableDatabase();
				String sql="select texterror from  Text_error1 where section=?";
				Cursor cursor=db.rawQuery(sql,null);	
				//Cursor cursor = db.rawQuery("select texterror from  Text_error1 where section=?", null);
				while (cursor.moveToNext()) {
					HashMap hm = new HashMap();//hashmap读取并存储数据库内容
					hm.put("text_error", cursor.getString(0));
					list.add(hm);
					System.out.println("heheheheheehe  " + cursor.getString(0));
					}
				return list; 
			}else{
				Log.i("TAG","查找失败");
				Toast.makeText(class_orderactivity.this, "查找失败", Toast.LENGTH_LONG).show();
				return null;
			}
			
			
			}

			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
					case R.id.select:
						list = chaxun();
						sa = new SimpleAdapter(class_orderactivity.this, list, R.layout.item,
							new String[] { "text_error" }, new int[] {
									R.id.item_list });
					 	sa.notifyDataSetChanged();
					 	setListAdapter(sa);
				   
					 	break;
				}
	  }
	 private Button.OnClickListener mainlistner = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(class_orderactivity.this,main.class);
				startActivity(intent);							
			}
		};
		private Spinner.OnItemSelectedListener spnPrefer1Listener1 = new Spinner.OnItemSelectedListener() {
			
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
		private Spinner.OnItemSelectedListener spnPrefer1Listener2 = new Spinner.OnItemSelectedListener() {
			
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