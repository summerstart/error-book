package com.example.book;

import com.example.book.R;
import com.web.WebService;
import com.web.WebServicePost;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends Activity implements OnClickListener {

		//1.����xml�ļ��еĿؼ��ı���
		private Button btnenroll,btnlogin;
		private EditText username, password;
		private TextView user,pwd;
		  private ProgressDialog dialog;
		  private String info;
		public Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     // 2.ͨ��findViewById�ķ�����ȡ�ؼ����
        btnenroll = (Button) findViewById(R.id.button_enroll);
        btnlogin = (Button) findViewById(R.id.button_login);
        user= (TextView)findViewById(R.id.username);
        pwd= (TextView) findViewById(R.id.pwd);
        username = (EditText) findViewById(R.id.usernameEdittext);
        password = (EditText) findViewById(R.id.pwdEdittext);  
     		// 3.Ϊbutton�������click�¼��ļ���������ʱִ�ж��巽��     		
     	btnlogin.setOnClickListener( this);
     	btnenroll.setOnClickListener( this);   	
	 };
	 
	 
    //ʵ��ע�ᰴť
	     public void onClick(View v)
	       {switch (v.getId()) {
	        case R.id.button_login:
	            // ������磬�޷����wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(MainActivity.this,"����δ����", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	                break;
	            }
	            // ��ʾ��
	            dialog = new ProgressDialog(this);
	            dialog.setTitle("��ʾ");
	            dialog.setMessage("���ڵ�½�����Ժ�...");
	            dialog.setCancelable(false);
	            dialog.show();
	            // �������̣߳��ֱ����Get��Post����
	            new Thread(new MyThread()).start();
	            break;
	        case R.id.button_enroll:
	            Intent regItn = new Intent(MainActivity.this, enroll.class);
	            // overridePendingTransition(anim_enter);
	            startActivity(regItn);
	            break;
	        } ;
      }

	     // ���߳̽������ݣ����߳��޸�����
	     public class MyThread implements Runnable {
	         @Override
	         public void run() {
	             info = WebService.executeHttpGet(username.getText().toString(), password.getText().toString());
	             // info = WebServicePost.executeHttpPost(username.getText().toString(), password.getText().toString());
	             handler.post(new Runnable() {
	                 @Override
	                 public void run() {
	                	 btnlogin.setText(info);
	                     dialog.dismiss();
	                 }
	             });
	         }
	     }
	     
	  // �������
	     private boolean checkNetwork() {
	         ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	         if (connManager.getActiveNetworkInfo() != null) {
	             return connManager.getActiveNetworkInfo().isAvailable();
	         }
	         return false;
	     }

	 }