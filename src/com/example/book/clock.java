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
			   //ȡ��ϵͳʱ��
		       long time = System.currentTimeMillis();
		       final Calendar mCalendar = Calendar.getInstance();
		       mCalendar.setTimeInMillis(time);
		       int mHour = mCalendar.get(Calendar.HOUR);
		       int mMinutes = mCalendar.get(Calendar.MINUTE);

		       new AlertDialog.Builder(clock.this).setTitle("ϵͳ��ʾ")//���öԻ������  
		       
		       .setMessage("���ǩ��ʱ��"+mHour+":"+mMinutes)//������ʾ������  
		    
		       .setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {//���ȷ����ť  	         	    
		           @Override  
		           public void onClick(DialogInterface dialog, int which) {//ȷ����ť����Ӧ�¼�  
		    
		               // TODO Auto-generated method stub  
		               finish();  
		           }  
		       }).setNegativeButton("����",new DialogInterface.OnClickListener() {//��ӷ��ذ�ť  
		           @Override  
		           public void onClick(DialogInterface dialog, int which) {//��Ӧ�¼�  
		    
		               // TODO Auto-generated method stub  
		             //  Log.i("alertdialog"," �뱣�����ݣ�");  
		           }  
		    
		       }).show();//�ڰ�����
	       }
	};
	 private Button.OnClickListener btnenrollListener3 = new Button.OnClickListener()
	   {
		     public void onClick(View v)
		       {
			       Intent intent = new Intent();
			       //������ת��� 
			       intent.setClass(clock.this,Myplan.class);
	               startActivity(intent);
		       }
	      }; 
}
