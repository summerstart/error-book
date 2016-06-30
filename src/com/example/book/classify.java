package com.example.book;

import com.example.book.utils.MySQLite;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class classify extends Activity {
	 
	private Button bt2;//bt2:����
	private Button bt3;//bt3:��ѧ
	private Button bt4;//bt4:Ӣ��
	private Button bt5;//bt5:����
	private Button bt6;//bt6:��ѧ
	private Button bt7;//bt7:����
	public static MySQLite mySQLite;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 /*requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ������
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	           		WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		 
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.classify);
	     mySQLite = new MySQLite(this, "managedb", 1);
	     
	     bt2 = (Button) findViewById(R.id.button_Chinese);
	     bt2.setOnClickListener(ChineseActivity);
	     bt3 = (Button) findViewById(R.id.button_math);
	     bt3.setOnClickListener(mathActivity);
	     bt4 = (Button) findViewById(R.id.button_english);
	     bt4.setOnClickListener(englishActivity);
	     bt5 = (Button) findViewById(R.id.button_physics);
	     bt5.setOnClickListener(physicsActivity);
	     bt6 = (Button) findViewById(R.id.button_chemistry);
	     bt6.setOnClickListener(chemistryActivity);
	     bt7 = (Button) findViewById(R.id.button_biology);
	     bt7.setOnClickListener(biologyActivity);
	 };
	//��ת������ѡ�����
		private Button.OnClickListener ChineseActivity = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(classify.this,main.class);
				startActivity(intent);
			}
		};
		//��ת����ѧ
		private Button.OnClickListener mathActivity = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(classify.this,main.class);
				startActivity(intent);
			}
		};
		//��ת��Ӣ��
		private Button.OnClickListener englishActivity = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(classify.this,main.class);
				startActivity(intent);
			}
		};
		//��ת������
			private Button.OnClickListener physicsActivity = new Button.OnClickListener(){
				public void onClick(View v){
					Intent intent=new Intent();
					intent.setClass(classify.this,main.class);
					startActivity(intent);
				}
			};
			//��ת����ѧ
			private Button.OnClickListener chemistryActivity = new Button.OnClickListener(){
				public void onClick(View v){
					Intent intent=new Intent();
					intent.setClass(classify.this,main.class);
					startActivity(intent);	
				}
			};
			//��ת������
			private Button.OnClickListener biologyActivity = new Button.OnClickListener(){
				public void onClick(View v){
					Intent intent=new Intent();
					intent.setClass(classify.this,main.class);
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
	

