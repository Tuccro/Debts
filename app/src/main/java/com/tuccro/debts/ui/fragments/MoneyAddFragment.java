package com.tuccro.debts.ui.fragments;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.ScrollView;

import com.tuccro.debts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyAddFragment extends AlertDialog {


    protected MoneyAddFragment(Context context) {
        super(context);

        LayoutInflater inflater = getLayoutInflater();
        ScrollView f1 = (ScrollView) findViewById(R.layout.fragment_money_add);



        this.setTitle("HI!");
        this.setView(inflater.inflate(R.layout.fragment_money_add, f1, false));
        this.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }

}
