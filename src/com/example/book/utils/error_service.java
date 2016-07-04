package com.example.book.utils;

import com.example.book.user.In_error;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
 
public class error_service {
	private Text_error terror;
	public error_service(Context context){
		terror=new Text_error(context);
}
	//错题录入
	
		public boolean entering(In_error error){
			SQLiteDatabase sdb=terror.getReadableDatabase();
			String sql="insert into Text_error1(error_date,error_time,type,section,reason," +
					"knowledge,text,texterror,experience,analysis) values(?,?,?,?,?,?,?,?,?,?)";
			Object obj[]={error.getDate(),error.getTime(),error.getType(),error.getSection(),
					error.getReason(),error.getKnowledge(),error.getText(),error.getTexterror(),
					error.getExperience(),error.getAnalysis()};
			sdb.execSQL(sql, obj);	
			return true;
		}
		
		//章节Class_order查询用
		public boolean select(String textsection){
			SQLiteDatabase sdb=terror.getReadableDatabase();
			String sql="select texterror from  Text_error1 where section=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{textsection});		
			if(cursor.moveToFirst()==true){
				cursor.close();
				return true;
			}
			return false;
		}

		public boolean enter(String type, String section, String reason,
				String knowledge, String text) {
			// TODO Auto-generated method stub
			return false;
		}

}

