package com.tuccro.debts.utils;


import android.database.Cursor;

import com.tuccro.debts.core.Human;
import com.tuccro.debts.db.IDBStrings;

import java.util.ArrayList;

public class Utils implements IDBStrings {

    public static ArrayList<Human> getPeopleFromDbCursor(Cursor cursor) {
        ArrayList<Human> people = new ArrayList<>();

        int id;
        String name;
        String phone;
        String dateAdd;

        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DB_PEOPLE_ID));
            name = cursor.getString(cursor.getColumnIndex(DB_PEOPLE_NAME));
            phone = cursor.getString(cursor.getColumnIndex(DB_PEOPLE_PHONE));
            dateAdd = cursor.getString(cursor.getColumnIndex(DB_PEOPLE_DATE_OF_CREATE));

            people.add(new Human(id, name, phone, dateAdd));

        } while (cursor.moveToNext());
        return people;
    }
}
