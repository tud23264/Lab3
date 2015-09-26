package com.example.tud23264.lab3;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterClass extends BaseAdapter {
    private int cap =0;
    private Context context;

    private int counter = 0;
    private boolean flipper = true; // when true, first element gets colored, when false, second element

    private ArrayList<TextView> list = new ArrayList<TextView>();
    public CustomAdapterClass(int n, Context context) {
        cap = n;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cap;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        TextView text = new TextView(context);
        text.setText(String.valueOf(position+1));

        //text.setText(String.valueOf(counter));
        if (flipper) {
            if ((position % 2 ==0)) {
                text.setBackgroundColor(Color.BLACK);
                text.setTextColor(Color.WHITE);
            }
            if (counter == 1)
            {
                text.setBackgroundColor(Color.BLACK);
                text.setTextColor(Color.WHITE);
            }
            if (counter == 0)
            {
                text.setBackgroundColor(Color.WHITE);
                text.setTextColor(Color.BLACK);
            }
            counter++;
        }
        else {
            if (!(position % 2 ==0)) {
                text.setBackgroundColor(Color.BLACK);
                text.setTextColor(Color.WHITE);
            }
            if (counter == 0)
            {
                text.setBackgroundColor(Color.BLACK);
                text.setTextColor(Color.WHITE);
            }
            if (counter == 1)
            {
                text.setBackgroundColor(Color.WHITE);
                text.setTextColor(Color.BLACK);
            }
            counter++;
        }
        if (counter == Math.sqrt(cap)) {
            flipper = !flipper;
            counter =0;
        }
        text.setGravity(Gravity.CENTER);
        return text;
    }
}
