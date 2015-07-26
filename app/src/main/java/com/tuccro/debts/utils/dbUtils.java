package com.tuccro.debts.utils;


import android.database.Cursor;

import com.tuccro.debts.core.Human;
import com.tuccro.debts.core.Item;
import com.tuccro.debts.core.Money;
import com.tuccro.debts.db.IDBStrings;

import java.util.ArrayList;

public abstract class dbUtils implements IDBStrings {

    public static ArrayList<Human> getPeopleFromDbCursor(Cursor cursor) {

        ArrayList<Human> people = new ArrayList<>();

        if (cursor.getCount() == 0) return people;

        int id;
        String name;
        String phone;
        long dateAdd;

        cursor.moveToFirst();

        do {
            id = cursor.getInt(cursor.getColumnIndex(DB_PEOPLE_ID));
            name = cursor.getString(cursor.getColumnIndex(DB_PEOPLE_NAME));
            phone = cursor.getString(cursor.getColumnIndex(DB_PEOPLE_PHONE));
            dateAdd = cursor.getLong(cursor.getColumnIndex(DB_PEOPLE_DATE_OF_CREATE));

            people.add(new Human(id, name, phone, dateAdd));

        } while (cursor.moveToNext());
        return people;
    }

    public static ArrayList<Money> getMoneyFromDbCursor(Cursor cursor) {

        ArrayList<Money> money = new ArrayList<>();

        if (cursor.getCount() == 0) return money;

        int id;
        int people_id;
        int currency_id;
        double sum;
        String note;
        long date_add;
        long date_begin;
        long date_end;
        int status_id;

        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DB_MONEY_ID));
            people_id = cursor.getInt(cursor.getColumnIndex(DB_MONEY_HUMAN_ID));
            currency_id = cursor.getInt(cursor.getColumnIndex(DB_MONEY_CURRENCY_ID));
            sum = cursor.getDouble(cursor.getColumnIndex(DB_MONEY_SUM));
            note = cursor.getString(cursor.getColumnIndex(DB_MONEY_NOTE));
            date_add = cursor.getLong(cursor.getColumnIndex(DB_MONEY_DATE_ADD));
            date_begin = cursor.getLong(cursor.getColumnIndex(DB_MONEY_DATE_BEGIN));
            date_end = cursor.getLong(cursor.getColumnIndex(DB_MONEY_DATE_END));

            money.add(new Money(id, people_id, currency_id, sum, note,
                    date_add, date_begin, date_end));

        } while (cursor.moveToNext());
        return money;
    }

    public static ArrayList<Item> getItemsFromDbCursor(Cursor cursor) {

        ArrayList<Item> items = new ArrayList<>();

        if (cursor.getCount() == 0) return items;

        int id;
        String name;

        cursor.moveToFirst();

        do {
            id = cursor.getInt(cursor.getColumnIndex(DB_PEOPLE_ID));
            name = cursor.getString(cursor.getColumnIndex(DB_PEOPLE_NAME));


            items.add(new Item(id, name));

        } while (cursor.moveToNext());
        return items;
    }
}
