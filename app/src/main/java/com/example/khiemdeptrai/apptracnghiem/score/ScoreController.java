package com.example.khiemdeptrai.apptracnghiem.score;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.khiemdeptrai.apptracnghiem.question.DBHelper;

public class ScoreController {
    private DBHelper dbHelper;

    public ScoreController(Context context) {
        dbHelper=new DBHelper(context);
    }

    public void insertScore(String name, float score, String room){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("score",score);
        values.put("room",room);
        db.insert("tbscore",null,values);
        db.close();

    }

    //Lấy danh sách điểm
    public Cursor getScrore() {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("tbscore",null,null,null,null,null,"_id DESC");
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
