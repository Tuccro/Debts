package com.tuccro.debts.ui.dialogs;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tuccro.debts.R;
import com.tuccro.debts.core.Human;
import com.tuccro.debts.core.Item;
import com.tuccro.debts.data.Data;
import com.tuccro.debts.ui.fragments.PeopleFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyAddDialog extends AlertDialog {

    Context context;

    ArrayList<Human> peopleArray;
    ArrayList<Item> currenciesArray;

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
        sCurrency = (Spinner) view.findViewById(R.id.spinner_currency);

        initFields();

        this.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }

    private void initFields() {
        peopleArray = PeopleFragment.getInstance().getPeopleList();

        int numberOfPeople = peopleArray.size();

        String[] peopleNames = new String[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            peopleNames[i] = peopleArray.get(i).getName();
        }

        ArrayAdapter<String> peopleAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, peopleNames);

        sPeople.setAdapter(peopleAdapter);


        currenciesArray = Data.getInstance(context).getCurrencies();

        int numberOfCurrencies = peopleArray.size();

        String[] currenciesNames = new String[numberOfCurrencies];

        for (int i = 0; i < numberOfCurrencies; i++) {
            currenciesNames[i] = currenciesArray.get(i).getName();
        }

        ArrayAdapter<String> currenciesAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, currenciesNames);

        sCurrency.setAdapter(currenciesAdapter);


//        sPeople.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
    }

}
