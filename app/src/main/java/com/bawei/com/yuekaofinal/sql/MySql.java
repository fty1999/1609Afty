package com.bawei.com.yuekaofinal.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/1/19 10:03:26
 * @Description:
 */
public class MySql extends SQLiteOpenHelper {
    public MySql(Context context) {
        super(context, "p.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pp(id integer primary key autoincrement,news_title text,pic_url text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
