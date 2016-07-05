package com.example.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.book.user.Cuoti;
import com.example.book.utils.MySQLite;
import com.example.book.utils.Text_error;
import com.example.book.utils.error_service;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class start extends Activity{
	private  Button btnDO;
	private List list;
	private SQLiteDatabase db = null;
	private ListView lv;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	/* requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	           		WindowManager.LayoutParams.FLAG_FULLSCREEN);*/		 
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.start);
	     Text_error myHelper = new Text_error(start.this);
	     db = myHelper.getWritableDatabase();
	     Cuoti cuoti = (Cuoti) getIntent().getSerializableExtra("cuoti");
	     list = chaxun(cuoti);
	     btnDO=(Button)findViewById(R.id.text_btn2);
	     btnDO.setOnClickListener(start);
	     lv = (ListView) findViewById(R.id.list);
	     lv.setAdapter(new SimpleAdapter(start.this, list,
					R.layout.item1, new String[] { "text" },
					new int[] { R.id.item_list }));
	 }
	 private Button.OnClickListener start = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(start.this,main.class);
				startActivity(intent);
			}
		};
//		public List chaxun() {
//
//			ArrayList list = new ArrayList();
//			// 游标选择操作
//
//			String txt_section = spnPrefer1.getSelectedItem().toString();
//			error_service eService = new error_service(class_orderactivity.this);
//
//			String txt_level = spnPrefer2.getSelectedItem().toString();
//		
//				String sql = "select text from  Text_error1 where section=?";
//				Cursor cursor = db.rawQuery(sql, new String[] { txt_section });
//				while (cursor.moveToNext()) {
//					HashMap hm = new HashMap();// hashmap读取并存储数据库内容
//					hm.put("text_error", cursor.getString(0));
//					list.add(hm);
//					System.out.println("heheheheheehe  " + cursor.getString(0));
//
//				}
//			
//			return list;
//
//		}

		public List chaxun(Cuoti cuoti) {

			ArrayList list = new ArrayList();
			//游标选择操作
			
			
		
		
				StringBuffer sbBuffer = new StringBuffer();
				List<String> list11 = new ArrayList<String>();
				if (!TextUtils.isEmpty(cuoti.getType())) {
					sbBuffer.append(" type=? and");
					list11.add(cuoti.getType());
				}
				
				if (!TextUtils.isEmpty(cuoti.getSection())) {
					sbBuffer.append(" section=? and");
					list11.add(cuoti.getSection());
				}
				
				if (!TextUtils.isEmpty(cuoti.getReason())) {
					sbBuffer.append(" reason=? and");
					list11.add(cuoti.getReason());
				}
				
				if (!TextUtils.isEmpty(cuoti.getPoint())) {
					sbBuffer.append(" knowledge=? and");
					list11.add(cuoti.getPoint());
				}
				sbBuffer.deleteCharAt(sbBuffer.length()-1);
				sbBuffer.deleteCharAt(sbBuffer.length()-1);
				sbBuffer.deleteCharAt(sbBuffer.length()-1);
				
				String sql="select text from  Text_error1 where "+sbBuffer.toString();
				String str[] = new String[list11.size()];
				for(int i=0;i<list11.size();i++){
					str[i] = list11.get(i);
				}
				Cursor cursor=db.rawQuery(sql,str);	

				while (cursor.moveToNext()) {
					HashMap hm = new HashMap();//hashmap读取并存储数据库内容
					hm.put("text", cursor.getString(0));
					list.add(hm);
					System.out.println("heheheheheehe  " + cursor.getString(0));
					
					}
				return list;
			
			
			}
}

