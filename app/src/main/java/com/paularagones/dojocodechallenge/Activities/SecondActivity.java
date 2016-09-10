package com.paularagones.dojocodechallenge.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.paularagones.dojocodechallenge.Adapters.ItemAdapters;
import com.paularagones.dojocodechallenge.Application.DojoApplication;
import com.paularagones.dojocodechallenge.Models.ItemSet;
import com.paularagones.dojocodechallenge.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {
    @Inject EventBus eventBus;

    @Bind(R.id.item_list) ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        ((DojoApplication) getApplication()).getServiceComponent().inject(this);
        eventBus.register(this);
    }

    @Subscribe(sticky = true)
    public void onItemSetCalled(List<ItemSet> itemSets) {
        setContentView(R.layout.activity_second);
        ItemAdapters itemAdapters = new ItemAdapters(this, R.layout.item_set_view, itemSets);
        ButterKnife.bind(this);
        listView.setAdapter(itemAdapters);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        eventBus.removeAllStickyEvents();
        eventBus.unregister(this);
    }
}
