package com.tuccro.debts.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tuccro.debts.R;
import com.tuccro.debts.core.Human;

import java.util.ArrayList;

public class PeopleAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Human> list;

    public PeopleAdapter(Context context, ArrayList<Human> people) {
        this.context = context;
        this.list = people;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Human getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_human, parent, false);
        }

        Human human = getItem(position);

        ((TextView) view.findViewById(R.id.text_name)).setText(human.getName());
        ((TextView) view.findViewById(R.id.text_sum)).setText("50");    // dummy sum

        return view;
    }
}
