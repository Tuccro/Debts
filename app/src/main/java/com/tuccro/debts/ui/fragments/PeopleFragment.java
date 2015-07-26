package com.tuccro.debts.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;
import com.tuccro.debts.R;
import com.tuccro.debts.core.Human;
import com.tuccro.debts.db.DB;
import com.tuccro.debts.ui.adapters.PeopleAdapter;
import com.tuccro.debts.ui.dialogs.HumanAddDialog;
import com.tuccro.debts.ui.dialogs.HumanInfoDialog;
import com.tuccro.debts.utils.dbUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PeopleFragment.OnPeopleFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PeopleFragment extends Fragment {

    private OnPeopleFragmentInteractionListener mListener;
    static PeopleFragment fragment;
    private FloatingActionButton buttonAddHuman;

    private ListView listView;
    private ArrayList<Human> peopleList;

    public PeopleFragment() {
        // Required empty public constructor
    }

    public static PeopleFragment getInstance() {

        if (fragment == null) {
            fragment = new PeopleFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);

        listView = (ListView) view.findViewById(R.id.list_people);

        init();

        buttonAddHuman = (FloatingActionButton) view.findViewById(R.id.bt_add_human);
        buttonAddHuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HumanAddDialog humanAddDialog = new HumanAddDialog(getActivity());
                humanAddDialog.show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Human human = (Human) parent.getItemAtPosition(position);

                HumanInfoDialog dialog = new HumanInfoDialog(getActivity(), human);
                dialog.show();
            }
        });
        return view;
    }

    public void init() {
        DB db = new DB(getActivity().getApplicationContext());
        db.open();
        peopleList = dbUtils.getPeopleFromDbCursor(db.getAllPeople());
        db.close();

        listView.setAdapter(new PeopleAdapter(getActivity().getApplicationContext(), peopleList));
    }

    public ArrayList<Human> getPeopleList() {
        return peopleList;
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
            mListener = (OnPeopleFragmentInteractionListener) activity;
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
    public interface OnPeopleFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
