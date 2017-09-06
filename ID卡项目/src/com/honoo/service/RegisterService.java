package com.honoo.service;

import android.database.sqlite.SQLiteDatabase;

public class RegisterService {

	public static Boolean checkPassword(String userPassword1,
			String userPassword2) {
		if (userPassword1.equals(userPassword2)) {

			return true;

		}

		return false;
	}

	public static void insertUser(SQLiteDatabase db, String userName,
			String password, String sex, String number) {
		db.execSQL(
				"insert into person_info(number,name,password,sex) values(?,?,?,?)",
				new String[] { number, userName, password, sex });

	}

}
