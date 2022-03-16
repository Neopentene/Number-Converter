package com.NumCo.numberconverter.Database;

import static android.provider.BaseColumns._ID;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Schemas extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "numco";
    public Schemas(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static class History {
        public String TABLE_NAME = "History";
        public String ID_COLUMN = _ID;
        public String INPUT_TYPE_COLUMN = "Input_Type";
        public String INPUT_COLUMN = "Input";
        public String OUTPUT_TYPE_COLUMN = "Output_type";
        public String OUTPUT_COLUMN = "Output";
        public String columns[] = {ID_COLUMN, INPUT_TYPE_COLUMN, INPUT_COLUMN, OUTPUT_TYPE_COLUMN, OUTPUT_COLUMN};
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        History history = new History();
        String createHistoryTable = "Create Table if not exists " + history.TABLE_NAME +
                "(" +
                history.ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                history.INPUT_TYPE_COLUMN + " TEXT, " +
                history.INPUT_COLUMN + " TEXT," +
                history.OUTPUT_TYPE_COLUMN + " TEXT," +
                history.OUTPUT_COLUMN + " TEXT" +
                ")";

        db.execSQL(createHistoryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
