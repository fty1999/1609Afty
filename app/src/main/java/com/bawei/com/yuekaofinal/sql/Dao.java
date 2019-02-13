package com.bawei.com.yuekaofinal.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/19 10:06:50
 * @Description:
 */
public class Dao {

    private final SQLiteDatabase db;

    public Dao(Context context){
        MySql mySql = new MySql(context);
        db = mySql.getWritableDatabase();
    }
    public long insert(String table, String nullColumnHack, ContentValues values){
        return db.insert(table,nullColumnHack,values);
    }
    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return db.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
    }
}
