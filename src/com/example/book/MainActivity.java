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

		//1.声明xml文件中的控件的变量
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
     // 2.通过findViewById的方法获取控件组件
        btnenroll = (Button) findViewById(R.id.button_enroll);
        btnlogin = (Button) findViewById(R.id.button_login);
        user= (TextView)findViewById(R.id.username);
        pwd= (TextView) findViewById(R.id.pwd);
        username = (EditText) findViewById(R.id.usernameEdittext);
        password = (EditText) findViewById(R.id.pwdEdittext);  
     		// 3.为button组件加入click事件的监听，触发时执行定义方法     		
     	btnlogin.setOnClickListener( this);
     	btnenroll.setOnClickListener( this);   	
	 };
	 
	 
    //实现注册按钮
	     public void onClick(View v)
	       {switch (v.getId()) {
	        case R.id.button_login:
	            // 检测网络，无法检测wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(MainActivity.this,"网络未连接", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	                break;
	            }
	            // 提示框
	            dialog = new ProgressDialog(this);
	            dialog.setTitle("提示");
	            dialog.setMessage("正在登陆，请稍后...");
	            dialog.setCancelable(false);
	            dialog.show();
	            // 创建子线程，分别进行Get和Post传输
	            new Thread(new MyThread()).start();
	            break;
	        case R.id.button_enroll:
	            Intent regItn = new Intent(MainActivity.this, enroll.class);
	            // overridePendingTransition(anim_enter);
	            startActivity(regItn);
	            break;
	        } ;
      }

	     // 子线程接收数据，主线程修改数据
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
	     
	  // 检测网络
	     private boolean checkNetwork() {
	         ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	         if (connManager.getActiveNetworkInfo() != null) {
	             return connManager.getActiveNetworkInfo().isAvailable();
	         }
	         return false;
	     }

	 }