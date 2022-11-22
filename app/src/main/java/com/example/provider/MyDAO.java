package com.example.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyDAO {
    private Context context;
    private SQLiteDatabase database;
    public MyDAO(Context context) {
        this.context=context;
        MyDBHelper dbHelper=new MyDBHelper(context,"yunDB",null,1);
        database=dbHelper.getWritableDatabase();
    }

    public Uri DAOInsert(ContentValues values){
        long row_id=database.insert("student",null,values);
        Uri uri=Uri.parse("content//yun.provider");
        Uri insert_uri=ContentUris.withAppendedId(uri,row_id);
        context.getContentResolver().notifyChange(insert_uri,null);
        return insert_uri;
    }
}