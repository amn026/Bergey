package io.isawesome.albert.dilution;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alber on 10/1/2016.
 */

public class ItemAdapter extends ArrayAdapter<String> {
    public ItemAdapter(Context context, List<String> str) {
        super(context,0,str);

    }

    @Override
    public View getDropDownView(int pos, View convertView, ViewGroup parent) {
        return initView(pos, convertView, parent);

    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        return initView(pos, convertView, parent);

    }

    public View initView(int pos, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, parent, false);
        }

        TextView name = (TextView)convertView.findViewById(R.id.textView);

        name.setText(getItem(pos));

        return convertView;

    }
}
