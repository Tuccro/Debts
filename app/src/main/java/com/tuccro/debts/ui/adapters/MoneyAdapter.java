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
        return 0;
    }

    @Override
    public Money getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_money, parent, false);
        }

        Money money = getItem(position);

        ((TextView) view.findViewById(R.id.text_name)).setText(money.getIdHuman());
        ((TextView) view.findViewById(R.id.text_sum)).setText("50");    // dummy sum

        return view;
    }
}
