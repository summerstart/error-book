package com.example.book.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.book.user.User;

public class UserService {
	private DBHelper dbHelper;
	public UserService(Context context){
		dbHelper=new DBHelper(context);
	}
	
	//µÇÂ¼ÓÃ
	public boolean login(String username,String password){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="select * from User where username=? and password=?";
		Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});		
		if(cursor.moveToFirst()==true){
			cursor.close();
			return true;
		}
		return false;
	}
	//×¢²áÓÃ
	public boolean register(User user){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into User(username,password,repassword,phone,type) values(?,?,?,?,?)";
		Object obj[]={user.getUsername(),user.getPassword(),user.getRepassword(),user.getPhone(),user.getType()};
		sdb.execSQL(sql, obj);	
		return true;
	}
}
