package com.m520it.mostbeautiful.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.m520it.mostbeautiful.cons.DbConst;

public class UserDao {

	private DbOpenHelper mHelper;

	public UserDao(Context c) {
		mHelper = new DbOpenHelper(c);
	}

	// �������
	public boolean saveUser(String name, String pwd) {
		SQLiteDatabase db = mHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(DbConst._NAME, name);
		values.put(DbConst._PWD, pwd);
		long insertId = db.insert(DbConst.USER_TABLE, null, values);
		return insertId != -1;
	}

	// �����ݱ�
	public void clearUsers() {
		SQLiteDatabase db = mHelper.getWritableDatabase();
		db.delete(DbConst.USER_TABLE, null, null);
	}

	public UserInfo aquireLastestUser() {
		SQLiteDatabase db = mHelper.getWritableDatabase();
		Cursor cursor = db.query(DbConst.USER_TABLE, new String[] {
				DbConst._NAME, DbConst._PWD }, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			String name = cursor.getString(0);
			String pwd = cursor.getString(1);
			return new UserInfo(name, pwd);
		}
		return null;
	}

	public class UserInfo {
		public String name;
		public String pwd;
		
		public UserInfo(String name, String pwd) {
			this.name = name;
			this.pwd = pwd;
		}
		
	}

}
