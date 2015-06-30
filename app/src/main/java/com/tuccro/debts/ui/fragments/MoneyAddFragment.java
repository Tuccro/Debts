package com.tuccro.debts.ui.fragments;


import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuccro.debts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyAddFragment extends DialogFragment {


    public MoneyAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_money_add, container, false);


        return view;
    }
}
