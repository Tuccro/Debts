package com.tuccro.debts.ui.dialogs;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tuccro.debts.R;
import com.tuccro.debts.core.Human;
import com.tuccro.debts.db.DB;
import com.tuccro.debts.utils.Utils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyAddDialog extends AlertDialog {

    Context context;
    Spinner sPeople;
    Spinner sCurrency;

    public MoneyAddDialog(Context context) {
        super(context);
        this.context = context;

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_money_add, null);

        this.setTitle("Title");
        this.setView(view);

        sPeople = (Spinner) view.findViewById(R.id.spinner_people);


        initFields();

        this.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }

    private void initFields() {
        DB db = new DB(context);
        db.open();
        ArrayList<Human> peopleArray = Utils.getPeopleFromDbCursor(db.getAllPeople());
        db.close();

        int numberOfPeople = peopleArray.size();

        String[] peopleNames = new String[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            peopleNames[i] = peopleArray.get(i).getName();
            Log.e("NAME", peopleNames[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, peopleNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sPeople.setAdapter(adapter);
    }

}
