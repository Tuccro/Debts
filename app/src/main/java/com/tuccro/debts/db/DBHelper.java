package com.tuccro.debts.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper implements IDBStrings {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE_TABLE_CURRENCY);
        db.execSQL(DB_CREATE_TABLE_PEOPLE);
        db.execSQL(DB_CREATE_TABLE_MONEY);
        db.execSQL(DB_CREATE_TABLE_STATUS);

        initSomeTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void initSomeTables(SQLiteDatabase db) {
        db.execSQL(DB_INSERT_CURRENCY_VALUES);
        db.execSQL(DB_INSERT_STATUS_VALUES);

//        db.execSQL(DB_INSERT_PEOPLE);
    }
}
