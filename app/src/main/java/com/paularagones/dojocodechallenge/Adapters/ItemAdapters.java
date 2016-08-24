package com.paularagones.dojocodechallenge.Adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.paularagones.dojocodechallenge.Models.Item;
import com.paularagones.dojocodechallenge.Models.ItemSet;
import com.paularagones.dojocodechallenge.R;
import com.paularagones.dojocodechallenge.Views.ItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mack and Aragones on 23/08/2016.
 */
public class ItemAdapters extends ArrayAdapter<ItemSet> {
    private AppCompatActivity appCompatActivity;
    private ViewHolder viewHolder;
    private List<ItemSet> itemSets;

    public ItemAdapters(AppCompatActivity appCompatActivity, int resource, List<ItemSet> itemSets) {
        super(appCompatActivity.getApplicationContext(), resource, itemSets);
        this.appCompatActivity = appCompatActivity;
        this.itemSets = itemSets;
        viewHolder = new ViewHolder();

    }

    private class ViewHolder {
        ItemView itemView1;
        ItemView itemView2;
        ItemView itemView3;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_set_view, null);

        viewHolder.itemView1 = (ItemView) convertView.findViewById(R.id.item_view1);
        viewHolder.itemView2 = (ItemView) convertView.findViewById(R.id.item_view2);
        viewHolder.itemView3 = (ItemView) convertView.findViewById(R.id.item_view3);

        List<Item> items = itemSets.get(position).getItems();



        viewHolder.itemView1.setProgressBarDirectionAndCursorColor(items.get(0).getStatus());
        viewHolder.itemView1.setProgressBarWidth(items.get(0).getTimeDifference());

        viewHolder.itemView2.setProgressBarDirectionAndCursorColor(items.get(1).getStatus());
        viewHolder.itemView2.setProgressBarWidth(items.get(1).getTimeDifference());

        viewHolder.itemView3.setProgressBarDirectionAndCursorColor(items.get(2).getStatus());
        viewHolder.itemView3.setProgressBarWidth(items.get(2).getTimeDifference());

        return convertView;
    }
}
