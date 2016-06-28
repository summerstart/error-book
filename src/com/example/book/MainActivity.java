package com.example.book;


import com.example.book.utils.UserService;

import com.example.book.user.User;
import com.example.book.utils.MySQLite;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.text.Spannable;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.app.backup.SharedPreferencesBackupHelper;
import android.widget.EditText;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;



public class MainActivity extends Activity  {
	
	EditText username;
	EditText password;
	Button login,register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		findViews();
	}
	private void findViews() {
		username=(EditText) findViewById(R.id.usernameEdittext);
		password=(EditText) findViewById(R.id.pwdEdittext);
		login=(Button) findViewById(R.id.button_login);
		register=(Button) findViewById(R.id.button_enroll);
		login.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=username.getText().toString();
				String pass=password.getText().toString();
				Log.i("TAG",name+"_"+pass);
				UserService uService=new UserService(MainActivity.this);
				boolean flag=uService.login(name, pass);
				if(flag){
					//jumpToMenu();	
					Log.i("TAG","µÇÂ¼³É¹¦");
					Toast.makeText(MainActivity.this, "µÇÂ¼³É¹¦", Toast.LENGTH_LONG).show();
					Intent intent=new Intent(MainActivity.this,classify.class);
					startActivity(intent);
					//MainActivity.this.finish();
				}else{
					Log.i("TAG","µÇÂ¼Ê§°Ü");
					Toast.makeText(MainActivity.this, "µÇÂ¼Ê§°Ü", Toast.LENGTH_LONG).show();
				}
			}
		});
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,enroll.class);
				startActivity(intent);
			}
		});
	}
		public void jumpToMenu(){
			//setContentView(R.layout.classify);
			Intent intent=new Intent(MainActivity.this,classify.class);
			startActivity(intent);
			MainActivity.this.finish();
		}
}