package com.example.cryptonews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/*
public class FavDB extends SQLiteOpenHelper {

    private static int DB_VERSION =1;
    private static String DATABASE_NAME= "CryptoDB";
    private static String TABLE_NAME= "favoriteTable";
    public static String KEY_ID = "id";
    public static String ITEM_TITLE = "itemTitle";
    public static String FAVORITE_STATUS = "fStatus";
    public static String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME+ "("
            + KEY_ID+ " TEXT," +ITEM_TITLE+ " TEXT,"
            + FAVORITE_STATUS+ " TEXT)";

    public FavDB(Context context){ super(context,DATABASE_NAME,null,DB_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //create empty tables
    public void insertEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        for (int x=1; x<11;x++){
            cv.put(KEY_ID,x);
            cv.put(FAVORITE_STATUS,"0");

            db.insert(TABLE_NAME,null,cv);
        }
    }
    // insert data into database
    public void insertIntoTheDatabase(String item_title, String id, String fav_status){
        SQLiteDatabase db;
        db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_TITLE,item_title);
        cv.put(KEY_ID,id);
        cv.put(FAVORITE_STATUS,fav_status);
        db.insert(TABLE_NAME,null,cv);

        Log.d("FavDB Status", item_title +", favstatus - "+fav_status+" - ."+cv);
    }

    //read all data
    public Cursor read_alldata(String id){
        SQLiteDatabase db = this. getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where "+ KEY_ID+"=" +id+"";
        return db.rawQuery(sql,null,null);
    }
}*/
