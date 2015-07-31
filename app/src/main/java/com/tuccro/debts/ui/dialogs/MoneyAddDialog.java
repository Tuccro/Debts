package com.tuccro.debts.ui.dialogs;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.tuccro.debts.R;
import com.tuccro.debts.core.Human;
import com.tuccro.debts.core.Item;
import com.tuccro.debts.data.Data;
import com.tuccro.debts.ui.fragments.PeopleFragment;
import com.tuccro.debts.utils.timeUtils;

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

    EditText etSum;
    EditText etNote;
    EditText etDateBegin;
    EditText etDateEnd;

    RadioGroup rgWhoIs;
    RadioButton rbHe;
    RadioButton rbMe;

    long dateAdd;
    long dateBegin;
    long dateEnd;

    public MoneyAddDialog(Context context) {
        super(context);
        this.context = context;

        dateBegin = System.currentTimeMillis();

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_money_add, null);

//        this.setTitle("Title");
        this.setView(view);

        sPeople = (Spinner) view.findViewById(R.id.spinner_people);
        sCurrency = (Spinner) view.findViewById(R.id.spinner_currency);

        etSum = (EditText) view.findViewById(R.id.et_sum);
        etNote = (EditText) view.findViewById(R.id.et_note);
        etDateBegin = (EditText) view.findViewById(R.id.et_date_begin);
        etDateEnd = (EditText) view.findViewById(R.id.et_date_end);

        rgWhoIs = (RadioGroup) view.findViewById(R.id.rg_whois);
        rbHe = (RadioButton) view.findViewById(R.id.rb_he);
        rbMe = (RadioButton) view.findViewById(R.id.rb_me);

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

        int numberOfCurrencies = currenciesArray.size();

        String[] currenciesNames = new String[numberOfCurrencies];

        for (int i = 0; i < numberOfCurrencies; i++) {
            currenciesNames[i] = currenciesArray.get(i).getName();
        }

        ArrayAdapter<String> currenciesAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, currenciesNames);

        sCurrency.setAdapter(currenciesAdapter);

        setDateView(etDateBegin, dateBegin);

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

    private void setDateView(EditText editText, long date) {
        editText.setText(timeUtils.getDateFromMillis(date));
    }
}
