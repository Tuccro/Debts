package com.tuccro.debts.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tuccro.debts.R;
import com.tuccro.debts.core.Money;

import java.util.ArrayList;

public class MoneyAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Money> list;

    public MoneyAdapter(Context context, ArrayList<Money> money) {
        this.context = context;
        this.list = money;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Money getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_money, parent, false);
        }

        Money money = getItem(position);

        ((TextView) view.findViewById(R.id.text_name)).setText(money.getNote());
        ((TextView) view.findViewById(R.id.text_sum)).setText(String.valueOf(money.getSum()));    // dummy sum

        return view;
    }
}
