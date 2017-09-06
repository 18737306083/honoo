package com.honoo.service;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonInfo {

	public static void insertPersonInfo(SQLiteDatabase db, String number,
			String name, String password, String sex) {
		db.execSQL("insert into person_info(number,name,password,sex)",
				new String[] { number, name, password, sex });

	}
	
	public static String selectPerson(SQLiteDatabase db,String number){
	
	Cursor cursor=	db.rawQuery("select  * from person_info where number = ?", new String[]{number});
	  
	 System.out.println(cursor.getPosition());
	 System.out.println(cursor.getCount());
	 if(cursor.getCount()>0){
	   cursor.moveToNext();
	   String password=cursor.getString(cursor.getColumnIndex("password"));
		System.out.println(password+"pssword");
		return password;
	 }
		
	 return "";
	}
	
	
}
