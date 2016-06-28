package com.example.book.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	static String name="book.db";
	static int dbVersion=1;
	public DBHelper(Context context) {
		super(context, name, null, dbVersion);
	}
	//只在创建的时候用一次
	public void onCreate(SQLiteDatabase db) {
		
		String sql="create table User(username varchar(20) primary key ,password varchar(20),repassword varchar(20),phone integer,type varchar(4))";
		db.execSQL(sql);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}