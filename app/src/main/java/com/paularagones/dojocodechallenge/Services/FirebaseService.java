package com.paularagones.dojocodechallenge.Services;

import android.util.Log;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.paularagones.dojocodechallenge.Constants.SystemConstants;
import com.paularagones.dojocodechallenge.Models.Item;
import com.paularagones.dojocodechallenge.Models.ItemSet;
import com.paularagones.dojocodechallenge.Models.Overall;

import java.util.ArrayList;
import java.util.List;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Mack and Aragones on 23/08/2016.
 */
public class FirebaseService {

    private static final String LOG_TAG = FirebaseService.class.getSimpleName();

    private static FirebaseService firebaseService;

    public static FirebaseService newInstance() {

        if (firebaseService == null) {
            firebaseService = new FirebaseService();
        }
            return firebaseService;
    }

    public void callOverall() {
        final Overall overall = new Overall();
        final EventBus eventBus = EventBus.getDefault();

        new Firebase("https://dojocodechallenge.firebaseio.com/overall")
                .addChildEventListener(new ChildEventListener() {
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Log.d(LOG_TAG, "onChildAdded");

                        overall.setStatus((String)dataSnapshot.child(SystemConstants.STATUS).getValue());
                        overall.setTotal((Long)dataSnapshot.child(SystemConstants.TOTAL).getValue());
                        overall.setValue((Long)dataSnapshot.child(SystemConstants.VALUE).getValue());
                        overall.setTrend((String)dataSnapshot.child(SystemConstants.TREND).getValue());

                        eventBus.postSticky(overall);

                        Log.d(LOG_TAG, overall.toString());
                    }
                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                        Log.d(LOG_TAG, "onChildRemoved");
                    }
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        Log.d(LOG_TAG, "onChildChanged");
                    }
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                        Log.d(LOG_TAG, "onChildMoved");
                    }
                    public void onCancelled(FirebaseError firebaseError) {
                        Log.d(LOG_TAG, "onCancelled");
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getMessage());
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getDetails());
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getCode());
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getCode());
                    }
                });

    }

    public void callItems() {

        final List<ItemSet> itemSets = new ArrayList<>();
        final EventBus eventBus = EventBus.getDefault();

        new Firebase("https://dojocodechallenge.firebaseio.com/items")
                .addChildEventListener(new ChildEventListener() {
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Log.d(LOG_TAG, "Start : onChildAdded");
                        List<Item> items = new ArrayList<>();
                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                            String status = (String)postSnapshot.child(SystemConstants.STATUS).getValue();
                            Log.d(LOG_TAG, "status : " + status);
                            String timeDifferenceString = String.valueOf(postSnapshot.child(SystemConstants.TIME_DIFFERENCE).getValue());

                            if (status.equals(SystemConstants.GOOD)) timeDifferenceString = timeDifferenceString.substring(2);
                            Log.d(LOG_TAG, "time difference : " + timeDifferenceString);

                            Item item = new Item();
                            item.setStatus((String)postSnapshot.child(SystemConstants.STATUS).getValue());

                            timeDifferenceString = timeDifferenceString.substring(2,4);

                            Float timeDifference = Float.parseFloat(timeDifferenceString);

                            Log.d(LOG_TAG, "time difference calculation : " + timeDifference);

                            item.setTimeDifference(timeDifference);
                            items.add(item);

                            Log.d(LOG_TAG, item.toString());
                        }
                        ItemSet itemSet = new ItemSet();
                        itemSet.setItems(items);

                        itemSets.add(itemSet);

                        eventBus.postSticky(itemSets);

                        Log.d(LOG_TAG, "Finish : onChildAdded");

                    }
                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                        Log.d(LOG_TAG, "onChildRemoved");
                    }
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        Log.d(LOG_TAG, "onChildChanged");
                    }
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                        Log.d(LOG_TAG, "onChildMoved");
                    }
                    public void onCancelled(FirebaseError firebaseError) {
                        Log.d(LOG_TAG, "onCancelled");
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getMessage());
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getDetails());
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getCode());
                        Log.d(LOG_TAG, "firebaseError : " + firebaseError.getCode());
                    }
                });
    }
}
