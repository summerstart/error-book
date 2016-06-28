package com.example.book;


import com.example.book.R;
import com.example.book.user.User;
import com.example.book.utils.UserService;
//import com.example.book.RegisterActivity;
//import com.example.book.SearchActivity;
//import com.example.book.utils.HttpUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class enroll  extends Activity {
	EditText username;
	EditText password;
	EditText repassword;
	EditText phone;
	RadioGroup type=null;	
	private RadioButton student=null; 
    private RadioButton teacher=null;
	Button register,cancle;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enroll);
		findViews();
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=username.getText().toString().trim();
				String pass=password.getText().toString().trim();
				String repwd=repassword.getText().toString().trim();
				String phonestr=phone.getText().toString().trim();
				String typestr=((RadioButton)enroll.this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
				Log.i("TAG",name+"_"+pass+"_"+repwd+"_"+phonestr+"_"+typestr);
				UserService uService=new UserService(enroll.this);
				User user=new User();
				user.setUsername(name);
				user.setPassword(pass);
				user.setRepassword(repwd);
				user.setPhone(Integer.parseInt(phonestr));
				user.setType(typestr);
				uService.register(user);
				Toast.makeText(enroll.this, "×¢²á³É¹¦", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(enroll.this,MainActivity.class);
				startActivity(intent);
			}
		});
		cancle.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(enroll.this,MainActivity.class);
				startActivity(intent);
				enroll.this.finish();
			}
		});
	
	}
	private void findViews() {
		username=(EditText) findViewById(R.id.en_usernameeedit);
		password=(EditText) findViewById(R.id.en_pwdtext);
		repassword=(EditText) findViewById(R.id.en_repwdtext);
		phone=(EditText) findViewById(R.id.en_phonetext);
		type=(RadioGroup) findViewById(R.id.radGroupsex);
		student =(RadioButton)findViewById(R.id.en_student);
		teacher =(RadioButton)findViewById(R.id.en_teacher);
		register=(Button) findViewById(R.id.btn_en);
		cancle=(Button) findViewById(R.id.btn_cancle);
	}
}
