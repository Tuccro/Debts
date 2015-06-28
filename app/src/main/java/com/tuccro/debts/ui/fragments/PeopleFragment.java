package com.tuccro.debts.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tuccro.debts.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PeopleFragment.OnPeopleFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PeopleFragment extends Fragment {

    private OnPeopleFragmentInteractionListener mListener;
    static PeopleFragment fragment;

    ListView listView;

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

        String[] names = {"sdfsdfsdf", "nm,hjjhgfh", "dfghbnvbnm",
                "ewrqewfgdsf", "sggfjhhgfgfdg", "rertertdfdfg",
                "sfdfgfhrtrt", "uykujhfgdfgdfg", "werwgdfgdgd",
                "nm,hjjhgfh", "dfghbnvbnm", "ewrqewfgdsf",
                "sggfjhhgfgfdg", "rertertdfdfg", "sfdfgfhrtrt",
                "uykujhfgdfgdfg", "uykujhfgdfgdfg", "werwgdfgdgd",
                "sggfjhhgfgfdg", "rertertdfdfg", "sfdfgfhrtrt",
                "wqerqewqrwer", "utuyytrtgfbb", "xcvcgtertdfg",
                "qweewretretre", "iuughhcvvchghg", "cvvdfgdfgdfgdf",
                "tregdffvcxbxb", "cccgdhgfhgfhfg", "pufghhgdfgfd"};

        listView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, names));
        listView.setBackgroundColor(R.color.Black);
        return view;
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