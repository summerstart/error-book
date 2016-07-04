package com.example.book.utils;

import com.example.book.user.In_error;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
 
public class text_evalution {
	private Text_error terror;
	public text_evalution(Context context){
		terror=new Text_error(context);
}
	//�����ݿⰴ��ͬ��¼�뷽ʽ����Ŀ��ѯ������
	
		public boolean entering(In_error error){
			SQLiteDatabase sdb=terror.getReadableDatabase();
			String sql="insert into Text_error1(error_date,error_time,type,section,reason,knowledge) values(?,?,?,?,?,?)";
			Object obj[]={error.getDate(),error.getTime(),error.getType(),error.getSection(),error.getReason(),error.getKnowledge()};
			sdb.execSQL(sql, obj);	
			return true;
		}
		//��¼��
		public boolean select(String sdate,String atime){
			SQLiteDatabase sdb=terror.getReadableDatabase();
			String sql="select texterror from In_error where date=? or time=?";
			Cursor cursor=sdb.rawQuery(sql, new String[]{sdate,atime});		
			if(cursor.moveToFirst()==true){
				cursor.close();
				return true;
			}
			return false;
		}
}
