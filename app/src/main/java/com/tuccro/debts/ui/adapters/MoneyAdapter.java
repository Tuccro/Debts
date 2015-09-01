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

        TextView tvNote = (TextView) view.findViewById(R.id.text_name);
        TextView tvSum = (TextView) view.findViewById(R.id.text_sum);
        TextView tvWhoIs = (TextView) view.findViewById(R.id.text_whois);

        if (money.getNote().isEmpty()) money.setNote("<no description>");

        tvNote.setText(money.getNote());

        if (money.getSum() < 0) {
            money.setSum(money.getSum() * -1);
            tvSum.setTextColor(context.getResources().getColor(R.color.DarkRed));
        } else {
            tvSum.setTextColor(context.getResources().getColor(R.color.DarkGreen));
        }

        tvSum.setText(String.valueOf(money.getSum()));
        return view;
    }
}
