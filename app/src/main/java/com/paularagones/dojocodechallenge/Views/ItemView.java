package com.paularagones.dojocodechallenge.Views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.paularagones.dojocodechallenge.Constants.SystemConstants;
import com.paularagones.dojocodechallenge.R;

/**
 * Created by Mack and Aragones on 23/08/2016.
 */
public class ItemView extends RelativeLayout {

    private static final String LOG_TAG = ItemView.class.getSimpleName();
    private View progressBar;
    private View cursor;
    private View midpoint;
    private RelativeLayout.LayoutParams progressBarRule;
    private RelativeLayout.LayoutParams cursorRule;

    public ItemView(Context context) {
        super(context);
        initializeViews(context);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        Log.d(LOG_TAG, "initializeViews");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_view, this);


    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(LOG_TAG, "onFinishInflate");

        progressBar = (View) findViewById(R.id.progressBar);
        cursor = (View) findViewById(R.id.cursor);
        midpoint = (View) findViewById(R.id.midpoint);

        progressBarRule = (RelativeLayout.LayoutParams) progressBar.getLayoutParams();
        cursorRule = (RelativeLayout.LayoutParams) cursor.getLayoutParams();

    }

    public void setProgressBarDirectionAndCursorColor(String status) {
        if (status.equals(SystemConstants.GOOD)) {
            progressBarRule.addRule(RelativeLayout.RIGHT_OF, 0);
            progressBarRule.addRule(RelativeLayout.LEFT_OF, R.id.midpoint);
            cursorRule.addRule(RelativeLayout.RIGHT_OF,0);
            cursorRule.addRule(RelativeLayout.LEFT_OF,R.id.progressBar);
            cursor.setBackgroundColor(Color.parseColor("#36c7ac"));
        } else if (status.equals(SystemConstants.OK)){
            cursor.setBackgroundColor(Color.parseColor("#fadb43"));
        }
    }

    public void setProgressBarWidth(float width) {
        Log.d(LOG_TAG, "width : " + width);
        progressBarRule.width = Math.round(width);
    }
}
