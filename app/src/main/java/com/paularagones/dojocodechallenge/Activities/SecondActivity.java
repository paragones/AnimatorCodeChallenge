package com.paularagones.dojocodechallenge.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.paularagones.dojocodechallenge.Adapters.ItemAdapters;
import com.paularagones.dojocodechallenge.Models.ItemSet;
import com.paularagones.dojocodechallenge.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private EventBus eventBus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        eventBus = EventBus.getDefault();
        eventBus.register(this);
    }

    @Subscribe(sticky = true)
    public void onItemSetCalled(List<ItemSet> itemSets) {
        setContentView(R.layout.activity_second);
        ItemAdapters itemAdapters = new ItemAdapters(this, R.layout.item_set_view, itemSets);
        ListView listView = (ListView) findViewById(R.id.item_list);
        listView.setAdapter(itemAdapters);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        eventBus.removeAllStickyEvents();
        eventBus.unregister(this);
    }
}
