package com.example.thuchanh1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.thuchanh1.R;

public class SpinnerAdapter extends BaseAdapter {
    private int[] imgs={R.drawable.a,R.drawable.b};

    public SpinnerAdapter(Context context) {
        this.context = context;
    }

    private Context context;
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Integer getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View items= LayoutInflater.from(context).inflate(R.layout.item_image,parent,false);
        ImageView img =items.findViewById(R.id.img);
        img.setImageResource(imgs[position]);
        return items;
    }
}
