package com.honoo.idcard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DaoService extends SQLiteOpenHelper{

	 public DaoService(Context context, String name, 
			int version) {
		super(context, name,null, version);
		// TODO Auto-generated constructor stub
	}

	final String sql1="create table person_info(id integer primary key autoincrement,number varchar(12),name varchar(10),password varchar(16),sex varchar(2))";
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

arg0.execSQL(sql1);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
