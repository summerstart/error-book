package com.example.book;

import java.util.Calendar;

import android.app.Activity;  
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.widget.AnalogClock; 
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.DigitalClock;
@SuppressWarnings("deprecation")
public class clock extends Activity {

	private Button btnReturn;
	private Button btnQD;
	public void onCreate(Bundle savedInstanceState) {   
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.tixing);   
        @SuppressWarnings("unused")
		DigitalClock digitalClock = (DigitalClock)findViewById(R.id.digitalClock);   
        @SuppressWarnings("unused")
		AnalogClock analogClock = (AnalogClock)findViewById(R.id.analogClock); 
        btnReturn = (Button) findViewById(R.id.btnreturn1);
        btnQD = (Button) findViewById(R.id.btnqd);
        btnQD.setOnClickListener( btnenrollListener2);
        btnReturn.setOnClickListener( btnenrollListener3);
    //    TextView txt = (TextView)findViewById(R.id.textview1);
    }   
	private Button.OnClickListener btnenrollListener2 = new Button.OnClickListener()
	{
		private TextView txt;

		public void onClick(View v)
	       {
			   //取得系统时间
		       long time = System.currentTimeMillis();
		       final Calendar mCalendar = Calendar.getInstance();
		       mCalendar.setTimeInMillis(time);
		       int mHour = mCalendar.get(Calendar.HOUR);
		       int mMinutes = mCalendar.get(Calendar.MINUTE);

		       new AlertDialog.Builder(clock.this).setTitle("系统提示")//设置对话框标题  
		       
		       .setMessage("你的签到时间"+mHour+":"+mMinutes)//设置显示的内容  
		    
		       .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  	         	    
		           @Override  
		           public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
		    
		               // TODO Auto-generated method stub  
		               finish();  
		           }  
		       }).setNegativeButton("返回",new DialogInterface.OnClickListener() {//添加返回按钮  
		           @Override  
		           public void onClick(DialogInterface dialog, int which) {//响应事件  
		    
		               // TODO Auto-generated method stub  
		             //  Log.i("alertdialog"," 请保存数据！");  
		           }  
		    
		       }).show();//在按键响
	       }
	};
	 private Button.OnClickListener btnenrollListener3 = new Button.OnClickListener()
	   {
		     public void onClick(View v)
		       {
			       Intent intent = new Intent();
			       //返回跳转语句 
			       intent.setClass(clock.this,Myplan.class);
	               startActivity(intent);
		       }
	      }; 
}
