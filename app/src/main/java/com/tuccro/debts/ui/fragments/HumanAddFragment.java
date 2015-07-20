package com.tuccro.debts.ui.fragments;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.tuccro.debts.R;

public class HumanAddFragment extends AlertDialog {

    protected HumanAddFragment(Context context) {
        super(context);

        final View view = (View) findViewById(R.layout.fragment_human_add);

        this.setView(view);
        this.setCancelable(true);
    }
}
