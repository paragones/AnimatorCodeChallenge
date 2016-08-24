package com.paularagones.dojocodechallenge.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.Firebase;
import com.paularagones.dojocodechallenge.Models.Overall;
import com.paularagones.dojocodechallenge.R;
import com.paularagones.dojocodechallenge.Services.FirebaseService;
import com.paularagones.dojocodechallenge.Views.OverallView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EventBus eventBus;
    private OverallView overallView;
    private AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {

        // Initialize Services and Methods
        eventBus = EventBus.getDefault();
        eventBus.register(this);
        activity = this;
        Firebase.setAndroidContext(this);
        FirebaseService firebaseService = FirebaseService.newInstance();
        firebaseService.callOverall();
        firebaseService.callItems();

    }


    @Subscribe(sticky = true)
    public void onOverallCalled(Overall overall) {
        setContentView(R.layout.activity_main);

        overallView = (OverallView) findViewById(R.id.overall_view);
        overallView.setCurrentScore(String.valueOf(overall.getValue()));
        overallView.setTotalScore(String.valueOf(overall.getTotal()));
        overallView.setTrend(overall.getTrend());
        overallView.setActivity(activity);
        overallView.setProgress(overall.getValue(), overall.getTotal());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        eventBus.removeAllStickyEvents();
        eventBus.unregister(this);
    }


}
