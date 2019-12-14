package com.example.khiemdeptrai.apptracnghiem.question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context) {
        dbHelper=new DBHelper(context);
    }

    public ArrayList<Question> getQuestion(int num_exam, String subject){
        ArrayList<Question> isData= new ArrayList<Question>();
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM database WHERE num_exam='"+num_exam+"' AND subject='"+subject+"'",null);
        cursor.moveToFirst();
        do{
            Question item;
            item=new Question(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),
                    cursor.getString(6),cursor.getInt(7),cursor.getString(8),cursor.getInt(9), "");
            isData.add(item);
        }while (cursor.moveToNext());
        return isData;
    }

    //Lấy danh sách câu hỏi theo câu hỏi
    public Cursor getSearchQuestion(String subject, String key) {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM database WHERE question LIKE '%"+key+"%' AND subject LIKE '%"+subject+"%'",null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    //Lấy danh sách câu hỏi theo môn học
    public Cursor getQuestionBySubject(String key) {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM database WHERE subject LIKE '%"+key+"%'",null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
