package com.marveltravel.map.data.entity.currency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.marveltravel.map.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Currency> {
    List<Currency> currencyExchanges;
    public SpinnerAdapter(@NonNull Context context, int resource, List<Currency> currencyExchanges) {
        super(context, resource, currencyExchanges);
        this.currencyExchanges=currencyExchanges;
    }
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent,false);
        TextView label = (TextView) row.findViewById(R.id.tv_currency);
        label.setText(currencyExchanges.get(position).getName());
        return row;
    }

}
