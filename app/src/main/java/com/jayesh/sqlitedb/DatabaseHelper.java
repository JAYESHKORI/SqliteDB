package com.jayesh.sqlitedb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jayesh on 6/4/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "username";
    private static final String COLUMN_PWD = "password";

    private static final String TABLE_CREATE = "create table "+TABLE_NAME+" ("+COLUMN_NAME+" text, "+COLUMN_UNAME+" text, "+COLUMN_PWD+" text);";


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    public void register(String name, String uname, String pwd)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String INSERT = "insert into "+TABLE_NAME+" values ('"+name+"','"+uname+"','"+pwd+"')";
        db.execSQL(INSERT);
    }

    public Cursor getData(String uname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String PWD = "select * from "+TABLE_NAME+" where username ="+uname;
        return db.query(PWD, null,"username=?",new String[] {uname},null,null,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
