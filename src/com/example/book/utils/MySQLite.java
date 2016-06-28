package com.example.book.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 *
 */
public class MySQLite extends SQLiteOpenHelper {

	final String CREAT_RABLE_SQL = "create table in_error(in_time date primary key autoincrement ,time_type," +
			"zhangjie,error_reason,error_zhengwen,answer,tihui,subject)";

	public MySQLite(Context context, String name, int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREAT_RABLE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
