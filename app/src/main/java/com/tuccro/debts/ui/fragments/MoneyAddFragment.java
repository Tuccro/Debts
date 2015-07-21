package com.tuccro.debts.ui.fragments;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.tuccro.debts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyAddFragment extends AlertDialog {


    protected MoneyAddFragment(Context context) {
        super(context);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_money_add, null);

        this.setTitle("HI!");
        this.setView(view);
        this.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }

}
