package com.example.book;

import com.example.book.utils.MySQLite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class main extends Activity {
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	//private Button bt5;
	private Button bt6;
	private Button bt7;
	private Button bt8;
	private Button bt9;
	private Button bt10;
	public static MySQLite mySQLite;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mySQLite = new MySQLite(this, "managedb", 1);
		
		bt1=(Button)findViewById(R.id.btn_order);
		bt1.setOnClickListener(class_orderactivity);
		bt2=(Button)findViewById(R.id.btn_hard);
		bt2.setOnClickListener(class_hard);
		bt3=(Button)findViewById(R.id.btn_spot);
		bt3.setOnClickListener(class_knowledge);
		bt4=(Button)findViewById(R.id.btn_wrong);
		bt4.setOnClickListener(class_type);
		//bt5=(Button)findViewById(R.id.btn_more);
		//bt5.setOnClickListener(Input_more);
		bt6=(Button)findViewById(R.id.btn_one);
		bt6.setOnClickListener(Input_error);
		//bt7=(Button)findViewById(R.id.btn_set);
		//bt7.setOnClickListener(review_set);
		bt8=(Button)findViewById(R.id.btn_content);
		bt8.setOnClickListener(evalution);
		bt9=(Button)findViewById(R.id.btn_back);
		bt9.setOnClickListener(back);
		bt10=(Button)findViewById(R.id.btn_plan);
		bt10.setOnClickListener(Myplan);
		
	}
	//跳转到章节
	private Button.OnClickListener class_orderactivity = new Button.OnClickListener(){
		public void onClick(View v){
			Intent intent=new Intent();
			intent.setClass(main.this,class_orderactivity.class);
			startActivity(intent);
		}
	};
	//跳转到错题难度
	private Button.OnClickListener class_hard = new Button.OnClickListener(){
		public void onClick(View v){
			Intent intent=new Intent();
			intent.setClass(main.this,class_hard.class);
			startActivity(intent);
		}
	};
	//跳转到知识点
	private Button.OnClickListener class_knowledge = new Button.OnClickListener(){
		public void onClick(View v){
			Intent intent=new Intent();
			intent.setClass(main.this,class_knowledge.class);
			startActivity(intent);
		}
	};
	//跳转到题目类型
		private Button.OnClickListener class_type = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(main.this,class_type.class);
				startActivity(intent);
			}
		};
		//跳转到错题录入
		private Button.OnClickListener Input_error = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(main.this,Input_error.class);
				startActivity(intent);	
			}
		};
		/*//跳转到书房
				private Button.OnClickListener Input_more = new Button.OnClickListener(){
					public void onClick(View v){
						Intent intent=new Intent();
						intent.setClass(main.this,Input_error.class);
						startActivity(intent);	
					}
				};*/
		//跳转到复习评测
		/*private Button.OnClickListener review_set = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(main.this,review_set.class);
				startActivity(intent);			
			}
		};*/
		//跳转到复习内容
		private Button.OnClickListener evalution = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(main.this,evalution.class);
				startActivity(intent);					
			}
		};
		
		//跳转到在家
		private Button.OnClickListener back = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(main.this,back.class);
				startActivity(intent);							
			}
		};
		
		// 
		private Button.OnClickListener Myplan = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(main.this,Myplan.class);
				startActivity(intent);							
			}
		};
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}