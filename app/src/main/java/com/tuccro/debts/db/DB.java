package com.tuccro.debts.db;

import android.content.Context;
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
}

