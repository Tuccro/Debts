package com.tuccro.debts.ui.dialogs;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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
import java.util.Calendar;

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

    double sum;
    String note;

    Button btDateBeginChange;
    Button btDateEndChange;

    public MoneyAddDialog(final Context context) {
        super(context);
        this.context = context;

        dateBegin = System.currentTimeMillis();

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_money_add, null);

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

        btDateBeginChange = (Button) view.findViewById(R.id.bt_date_begin_change);
        btDateEndChange = (Button) view.findViewById(R.id.bt_date_end_change);

        initFields();

        this.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        this.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        etSum.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                EditText et = (EditText) v;
                String numberText = et.getText().toString();

                sum = (numberText.isEmpty()) ? 0 : Double.parseDouble(numberText);
                return false;
            }
        });

        etNote.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                note = ((EditText) v).getText().toString();
                return false;
            }
        });

        btDateBeginChange.setOnClickListener(onClickDateChanger);
        btDateEndChange.setOnClickListener(onClickDateChanger);

    }

    View.OnClickListener onClickDateChanger = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final View v = view;
            final Calendar calendar = Calendar.getInstance();

            switch (v.getId()) {
                case R.id.bt_date_begin_change:
                    calendar.setTimeInMillis(dateBegin);
                    break;
                case R.id.bt_date_end_change:
                    if (dateEnd != 0) calendar.setTimeInMillis(dateEnd);
                    else calendar.setTimeInMillis(dateBegin);
                    break;
            }

            DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    calendar.set(year, monthOfYear, dayOfMonth);

                    switch (v.getId()) {
                        case R.id.bt_date_begin_change:
                            dateBegin = calendar.getTimeInMillis();
                            break;
                        case R.id.bt_date_end_change:
                            dateEnd = calendar.getTimeInMillis();
                            break;
                    }
                    initFields();
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

            datePickerDialog.setCancelable(true);
            datePickerDialog.setCanceledOnTouchOutside(true);
            datePickerDialog.show();
        }
    };

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
        if (dateEnd != 0) setDateView(etDateEnd, dateEnd);

//        sPeople.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

        rgWhoIs.check(rbHe.getId());
    }

    private void setDateView(EditText editText, long date) {
        editText.setText(timeUtils.getDateFromMillis(date));
    }
}
