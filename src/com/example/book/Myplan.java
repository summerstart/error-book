package com.example.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Myplan extends Activity{
	
	private Button btnReturn;
	private Button btntx;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.plan);
	// 2.ͨ��findViewById�ķ�����ȡ�ؼ����
	 btnReturn = (Button) findViewById(R.id.btnreturn);
	 btntx = (Button) findViewById(R.id.btnqdtx);
	 btnReturn.setOnClickListener( btnenrollListener);  
	 btntx.setOnClickListener( btnenrollListener1);
	 }
	  private Button.OnClickListener btnenrollListener = new Button.OnClickListener()
	   {
		     public void onClick(View v)
		       {
			       Intent intent = new Intent();
			       //������ת��� 
			       intent.setClass(Myplan.this, main.class);
	               startActivity(intent);
		       }
	      }; 
	      private Button.OnClickListener btnenrollListener1 = new Button.OnClickListener()
		   {
			     public void onClick(View v)
			       {
				       Intent intent = new Intent();
				       //��ת��� 
				       intent.setClass(Myplan.this, clock.class);
		               startActivity(intent);
			       }
		      };
	      
}
