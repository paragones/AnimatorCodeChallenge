package com.paularagones.dojocodechallenge.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.Firebase;
import com.paularagones.dojocodechallenge.Application.DojoApplication;
import com.paularagones.dojocodechallenge.Models.Overall;
import com.paularagones.dojocodechallenge.R;
import com.paularagones.dojocodechallenge.Services.FirebaseService;
import com.paularagones.dojocodechallenge.Views.OverallView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Inject EventBus eventBus;
    @Inject FirebaseService firebaseService;

    @Bind(R.id.overall_view) OverallView overallView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {

        // Initialize Services and Methods
        ((DojoApplication) getApplication()).getServiceComponent().inject(this);

        eventBus.register(this);
        Firebase.setAndroidContext(this);
        firebaseService.callOverall();
        firebaseService.callItems();

    }


    @Subscribe(sticky = true)
    public void onOverallCalled(Overall overall) {
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        overallView.setCurrentScore(String.valueOf(overall.getValue()));
        overallView.setTotalScore(String.valueOf(overall.getTotal()));
        overallView.setTrend(overall.getTrend());
        overallView.setActivity(this);
        overallView.setProgress(overall.getValue(), overall.getTotal());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        eventBus.removeAllStickyEvents();
        eventBus.unregister(this);
    }


}
