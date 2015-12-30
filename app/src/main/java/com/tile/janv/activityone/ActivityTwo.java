package com.tile.janv.activityone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    public static final String CALLS_ON_CREATE_KEY = "com.tile.janv.activityone.ActivityTwo.CALLS_ON_CREATE";
    public static final String CALLS_ON_START_KEY = "com.tile.janv.activityone.ActivityTwo.CALLS_ON_START";
    public static final String CALLS_ON_RESUME_KEY = "com.tile.janv.activityone.ActivityTwo.CALLS_ON_RESUME";
    public static final String CALLS_ON_RESTART_KEY = "com.tile.janv.activityone.ActivityTwo.CALLS_ON_RESTART";
    private int callsOnCreate = 0;
    private int callsOnStart = 0;
    private int callsOnResume = 0;
    private int callsOnRestart = 0;

    private TextView onCreateTextView, onStartTextView, onResumeTextView, onRestartTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("tag", "activity Two onCreate");
        super.onCreate(savedInstanceState);
        callsOnCreate++;
        setContentView(R.layout.activity_activity_two);
        onCreateTextView = (TextView) findViewById(R.id.activity_two_value_onCreate);
        onStartTextView = (TextView) findViewById(R.id.activity_two_value_onStart);
        onResumeTextView = (TextView) findViewById(R.id.activity_two_value_onResume);
        onRestartTextView = (TextView) findViewById(R.id.activity_two_value_onRestart);
        if (savedInstanceState != null) {
            extractFromState(savedInstanceState);
        }
        Log.i("question", "callsOnCreate value ? " + callsOnCreate);
        Log.i("question", "onCreateTextView not null?  " + (onCreateTextView != null ? "true" : "false"));
        updateCallsToView();
    }

    @Override
    protected void onStart() {
        Log.i("ActivityTwo", "activity Two onStart");
        super.onStart();
        callsOnStart++;
        updateCallsToView();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("ActivityTwo", "activity Two onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.i("ActivityTwo", "activity Two onResume");
        super.onResume();
        callsOnResume++;
        updateCallsToView();
    }

    @Override
    protected void onPause() {
        Log.i("ActivityTwo", "activity Two onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("ActivityTwo", "activity Two onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("ActivityTwo", "activity Two onRestart");
        super.onRestart();
        callsOnRestart++;
        updateCallsToView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("ActivityTwo", "activity Two onSaveInstanceState");
        copyToState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        Log.i("ActivityTwo", "activity Two onDestroy");
        super.onDestroy();  // Always call the superclass
    }

    public void clickButtonActivityTwo(View view) {
        ActivityTwo.this.finish();
    }

    private void extractFromState(Bundle bundle) {
        callsOnCreate = bundle.getInt(CALLS_ON_CREATE_KEY);
        callsOnStart = bundle.getInt(CALLS_ON_START_KEY);
        callsOnResume = bundle.getInt(CALLS_ON_RESUME_KEY);
        callsOnRestart = bundle.getInt(CALLS_ON_RESTART_KEY);
    }

    private void copyToState(Bundle bundle) {
        bundle.putInt(CALLS_ON_CREATE_KEY, callsOnCreate);
        bundle.putInt(CALLS_ON_START_KEY, callsOnStart);
        bundle.putInt(CALLS_ON_RESUME_KEY, callsOnResume);
        bundle.putInt(CALLS_ON_RESTART_KEY, callsOnRestart);
    }

    private void updateCallsToView() {
        onRestartTextView.setText(callsOnRestart + "");
        onResumeTextView.setText(callsOnResume + "");
        onStartTextView.setText(callsOnStart + "");
        onCreateTextView.setText(callsOnCreate + "");
    }
}
