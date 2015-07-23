package com.tuccro.debts.ui.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.tuccro.debts.R;
import com.tuccro.debts.db.DB;

public class HumanAddFragment extends AlertDialog {

    protected HumanAddFragment(final Context context) {
        super(context);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_human_add, null);

        final EditText etName = (EditText) view.findViewById(R.id.et_human_name);
        final EditText etPhone = (EditText) view.findViewById(R.id.et_human_phone);

        this.setView(view);

        this.setTitle("Add new human");
        this.setButton(BUTTON_NEGATIVE, "Cancel", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        this.setButton(BUTTON_POSITIVE, "Add", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DB db = new DB(context);
                db.open();

                db.addHuman(etName.getText().toString(), etPhone.getText().toString());
                db.close();

                PeopleFragment.getInstance().init();
            }
        });
    }
}
