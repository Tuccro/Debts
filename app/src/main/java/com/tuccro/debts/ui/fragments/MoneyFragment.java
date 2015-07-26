package com.tuccro.debts.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;
import com.tuccro.debts.R;
import com.tuccro.debts.core.Money;
import com.tuccro.debts.db.DB;
import com.tuccro.debts.ui.adapters.MoneyAdapter;
import com.tuccro.debts.ui.dialogs.MoneyAddDialog;
import com.tuccro.debts.utils.dbUtils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoneyFragment.OnMoneyFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MoneyFragment extends Fragment {

    private OnMoneyFragmentInteractionListener mListener;
    static MoneyFragment fragment;
    FloatingActionButton buttonAddEntry;

    private ListView listView;

    private ArrayList<Money> moneyList;

    public MoneyFragment() {
        // Required empty public constructor
    }

    public static MoneyFragment getInstance() {

        if (fragment == null) fragment = new MoneyFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_money, container, false);

        buttonAddEntry = (FloatingActionButton) view.findViewById(R.id.bt_add_money);
        listView = (ListView) view.findViewById(R.id.list_money);

        buttonAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoneyAddDialog moneyAddDialog = new MoneyAddDialog(getActivity());
                moneyAddDialog.show();

            }
        });

        return view;
    }

    public void init() {
        DB db = new DB(getActivity().getApplicationContext());
        db.open();
        moneyList = dbUtils.getMoneyFromDbCursor(db.getAllMoney());
        db.close();

        listView.setAdapter(new MoneyAdapter(getActivity().getApplicationContext(), moneyList));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnMoneyFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnMoneyFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
