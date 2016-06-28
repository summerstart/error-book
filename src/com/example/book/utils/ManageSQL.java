package com.example.book.utils;

import android.database.sqlite.SQLiteDatabase;

/**
 * 对数据库存储，提取数据
 * 
 * @author Administrator
 * 
 */
public class ManageSQL {

	public void insertT(SQLiteDatabase db, String data, String time) {
		try {

			db.execSQL("insert into in_error values (? , ? , ? )",
					new String[] { data, time });
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void DeleteARecord(SQLiteDatabase db, String strRow,
			String strRowValue) {
		try {
			String sql = "delete from  in_error  where " + strRow + " = "
					+ strRowValue;
			db.execSQL(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

