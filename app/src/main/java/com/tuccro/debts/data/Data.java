package com.tuccro.debts.data;

import android.content.Context;

import com.tuccro.debts.core.Item;
import com.tuccro.debts.db.DB;
import com.tuccro.debts.utils.dbUtils;

import java.util.ArrayList;

public class Data {

    private static Data data;
    private Context context;

    private ArrayList<Item> currencies;
    private ArrayList<Item> statuses;

    public ArrayList<Item> getCurrencies() {
        return currencies;
    }

    public ArrayList<Item> getStatuses() {
        return statuses;
    }

    public static Data getInstance(Context context) {

        if (data == null) {
            data = new Data(context);
        }
        return data;
    }

    private Data(Context context) {
        this.context = context;

        DB db = new DB(context);
        db.open();

        currencies = dbUtils.getItemsFromDbCursor(db.getAllCurrencies());
        statuses = dbUtils.getItemsFromDbCursor(db.getAllStatuses());

        db.close();
    }
}
