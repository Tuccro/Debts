package com.tuccro.debts.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB implements IDBStrings {

    Context context;
    DBHelper dbHelper;
    SQLiteDatabase db;

    public DB(Context context) {
        this.context = context;
    }

    public void open() {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
        this.db = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (dbHelper != null) dbHelper.close();
    }

    public void addHuman(String name, String phone) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("date_of_create", "3 September");
        cv.put("visible", 1);

        db.insert(DB_TABLE_PEOPLE, null, cv);
    }

    public Cursor getAllPeople() {
        return db.query(DB_TABLE_PEOPLE, null, null, null, null, null, "name");
    }

    public Cursor getAllMoney() {
        return db.query(DB_TABLE_MONEY, null, null, null, null, null, "name");
    }
}

