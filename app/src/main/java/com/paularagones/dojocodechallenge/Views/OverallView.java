package com.paularagones.dojocodechallenge.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.paularagones.dojocodechallenge.Activities.SecondActivity;
import com.paularagones.dojocodechallenge.Constants.SystemConstants;
import com.paularagones.dojocodechallenge.Drawable.CircleProgress;
import com.paularagones.dojocodechallenge.R;

/**
 * Created by Mack and Aragones on 23/08/2016.
 */
public class OverallView extends RelativeLayout {

    private static final String LOG_TAG = OverallView.class.getSimpleName();
    private CircleProgress fillCircle;
    private TextView currentScore;
    private TextView totalScore;
    private TextView arrow;
    private AppCompatActivity activity;

    public OverallView(Context context) {
        super(context);
        initializeViews(context);
    }

    public OverallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public OverallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    /**
     * Inflates the views in the layout.
     * * @param context
     * the current context for the view.
     */
    private void initializeViews(Context context) {
        Log.d(LOG_TAG, "initializeViews");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.overall_view, this);


    }

    @

            Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(LOG_TAG, "onFinishInflate");
        // Sets the images for the previous and next buttons. Uses
        // built‐in images so you don't need to add images, but in
        // a real application your images should be in the
        // application package so they are always available.

        fillCircle = (CircleProgress) findViewById(R.id.fillCircle);
        currentScore = (TextView) findViewById(R.id.currentScore);
        totalScore = (TextView) findViewById(R.id.totalScore);
        arrow = (TextView) findViewById(R.id.arrow);


    }

    public void setCurrentScore(String currentScoreValue) {
        Log.d(LOG_TAG, "setCurrentScore");
        currentScore.setText(currentScoreValue);

        currentScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterSecondActivity();
            }
        });
    }

    public void setTotalScore(String totalScoreValue) {
        Log.d(LOG_TAG, "setTotalScore");
        totalScore.setText(" / " + totalScoreValue);
    }

    public void setTrend(String trend) {
        Log.d(LOG_TAG, "setTrend");

        if (trend.equals(SystemConstants.DOWN)) {
            arrow.setText("↓");
        } else {
            arrow.setText("↑");
        }
    }

    private void enterSecondActivity() {
        Intent mainIntent = new Intent(activity, SecondActivity.class);
        activity.startActivity(mainIntent);
        activity.finish();
    }


    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void setProgress(long current, long total) {

        float progress = ((float) current / (float) total) * 100;
        Log.d(LOG_TAG, "progress : " + progress);

        fillCircle.setProgress(Math.round(progress));
    }
}
