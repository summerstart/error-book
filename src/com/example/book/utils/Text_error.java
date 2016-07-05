package com.example.book.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Text_error extends SQLiteOpenHelper {
	static String name="Text_error1.db";
	static int dbVersion=2;
	public Text_error(Context context) {
		super(context, name, null, dbVersion);
	}
	//只在创建的时候用一次
	public void onCreate(SQLiteDatabase db) {
		String sql="create table Text_error1(error_date date," +
				"error_time time,type varchar(20),section varchar(100)," +
	      "reason varchar(100),knowledge varchar(100),text varchar(100),texterror varchar(100)," +
	      "experience varchar(100),analysis varchar(100),leveltext varchar(100))";
		db.execSQL(sql);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
