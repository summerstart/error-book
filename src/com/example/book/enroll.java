package com.example.book;

import com.example.book.R;
//import com.example.book.RegisterActivity;
//import com.example.book.SearchActivity;
import com.example.book.utils.HttpUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class enroll  extends Activity {
	private Button btnen,btncancle;
	private EditText editTextuser, editTextpwd,editTextphone;
	private RadioButton rabteacher,rabstudent;
	private RadioGroup radioGroupclass;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.enroll);
	// 2.通过findViewById方法取得界面组件
	 editTextuser = (EditText) findViewById(R.id.en_usernametext);
		editTextpwd = (EditText) findViewById(R.id.en_pwd);
		editTextphone = (EditText) findViewById(R.id.en_phone);
		radioGroupclass=(RadioGroup)findViewById(R.id.radGroupclass);
		rabteacher=(RadioButton)findViewById(R.id.en_teacher);
		rabstudent=(RadioButton)findViewById(R.id.en_student);
	    btnen = (Button)findViewById(R.id.btn_en);
	    btncancle = (Button)findViewById(R.id.btn_cancle);
	   
	    //    my_button2.setText("@string/close");    //setText里面不能采用资源引用
	      //资源引用显示文本应该是在xml中的
	 //btnen.setText("Close");
	    
	    
	    
	  //获取用户在xml界面中输入的值，用final修饰，使其不可更改
		final String UserName = editTextuser.getText().toString().trim();
		final String password = editTextpwd.getText().toString().trim();
		final String phone = editTextphone.getText().toString().trim();
		final String teacher= rabteacher.getText().toString().trim();
		final String student= rabstudent.getText().toString().trim();
		//final String where = editTextwhere.getText().toString().trim();

		/*Thread thread = new Thread() {
			public void run() {
				//获取用户名，编号，密码和电话号码
				final String result = HttpUtils.requestHttp(UserName, password, phone);
                
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						if (result.equals("true")) {
							Toast.makeText(getApplicationContext(),
									" 注册陈功", 0).show();
							
							Intent intent = new Intent();
							 intent.setClass(enroll.this,
							MainActivity.class);
							 startActivity(intent);
						} else if(result.equals("false")) {
							Toast.makeText(getApplicationContext(),
									"注册失败，请检查", 0).show();
						}else if(result.equals("keyerror")) {
							Toast.makeText(getApplicationContext(),
									"该用户名已存在", 0).show();
						}else {
							
						}

					}
				});

			};
		};
		thread.start();*/
	    
	   btnen.setOnClickListener(new OnClickListener() 
		   {
	    	public void onClick(View v)
			     
			       {
				       Intent intent = new Intent();
		               intent.setClass(enroll.this,MainActivity.class);
		               startActivity(intent);
			       }
		      });
	 //取消
	    btncancle.setOnClickListener(new OnClickListener() 
	   {
		     public void onClick(View v)
		       {
			       Intent intent = new Intent();
	               intent.setClass(enroll.this,MainActivity.class);
	               startActivity(intent);
		       }
	   });
	 }
}
