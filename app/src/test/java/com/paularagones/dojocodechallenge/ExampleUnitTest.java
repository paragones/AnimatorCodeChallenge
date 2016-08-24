package com.paularagones.dojocodechallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.client.Firebase;
import com.paularagones.dojocodechallenge.Models.Overall;
import com.paularagones.dojocodechallenge.Services.FirebaseService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    private TestActivity testActivity;
    private EventBus eventBus;

    @Before
    public void setupFirebaseService() throws Exception {
        System.out.println("setupFirebaseService");
        testActivity = new TestActivity();
        Firebase.setAndroidContext(testActivity);
        FirebaseService firebaseService = FirebaseService.newInstance();
        firebaseService.callOverall();

        eventBus = EventBus.getDefault();
        eventBus.register(testActivity);
    }

    @Test
    public void testFirebaseService() throws Exception {

        System.out.println("assertEquals");
        assertEquals(1588, testActivity.value);
        assertEquals(1900, testActivity.total);
        assertEquals("down", testActivity.trend);
        assertEquals("too_few_games", testActivity.status);
    }


    public class TestActivity extends AppCompatActivity {

        public String status;
        public String trend;
        public long total;
        public long value;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            System.out.println("onCreate");
            super.onCreate(savedInstanceState);


        }

        @Subscribe(sticky = true)
        public void onEvent(Overall overall) {
            System.out.println("onEvent");
            total = overall.getTotal();
            value = overall.getValue();
            trend  = overall.getTrend();
            status = overall.getStatus();
        }

    }
}