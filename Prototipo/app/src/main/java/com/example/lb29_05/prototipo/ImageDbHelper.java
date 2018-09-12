package com.example.lb29_05.prototipo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImageDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_POSTS =
            "CREATE TABLE " + DBContract.ImageEntry.TABLE_NAME + " (" +
                    DBContract.ImageEntry._ID + " INTEGER PRIMARY KEY," +
                    DBContract.ImageEntry.COL_IMG_NAME + TEXT_TYPE + COMMA_SEP +
                    DBContract.ImageEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE + " )";
    private static final String SQL_DELETE_POSTS =
            "DROP TABLE IF EXISTS " + DBContract.ImageEntry.TABLE_NAME;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";
    public ImageDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_POSTS);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_POSTS);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
