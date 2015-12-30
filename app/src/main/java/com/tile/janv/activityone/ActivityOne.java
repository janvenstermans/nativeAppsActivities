package com.tile.janv.activityone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    public static final String CALLS_ON_CREATE_KEY = "com.tile.janv.activityone.ActivityOne.CALLS_ON_CREATE";
    public static final String CALLS_ON_START_KEY = "com.tile.janv.activityone.ActivityOne.CALLS_ON_START";
    public static final String CALLS_ON_RESUME_KEY = "com.tile.janv.activityone.ActivityOne.CALLS_ON_RESUME";
    public static final String CALLS_ON_RESTART_KEY = "com.tile.janv.activityone.ActivityOne.CALLS_ON_RESTART";
    private int callsOnCreate = 0;
    private int callsOnStart = 0;
    private int callsOnResume = 0;
    private int callsOnRestart = 0;

    private TextView onCreateTextView, onStartTextView, onResumeTextView, onRestartTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("ActivityOne", "activity One onCreate");
        super.onCreate(savedInstanceState);
        callsOnCreate++;
        setContentView(R.layout.activity_activity_one);
        onCreateTextView = (TextView) findViewById(R.id.activity_one_value_onCreate);
        onStartTextView = (TextView) findViewById(R.id.activity_one_value_onStart);
        onResumeTextView = (TextView) findViewById(R.id.activity_one_value_onResume);
        onRestartTextView = (TextView) findViewById(R.id.activity_one_value_onRestart);
        if (savedInstanceState != null) {
            extractFromState(savedInstanceState);
        }
        Log.i("question", "callsOnCreate value ? " + callsOnCreate);
        Log.i("question", "onCreateTextView not null?  " + (onCreateTextView != null ? "true" : "false"));
        updateCallsToView();
    }

    @Override
    protected void onStart() {
        Log.i("ActivityOne", "activity One onStart");
        super.onStart();
        callsOnStart++;
        updateCallsToView();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("ActivityOne", "activity One onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.i("ActivityOne", "activity One onResume");
        super.onResume();
        callsOnResume++;
        updateCallsToView();
    }

    @Override
    protected void onPause() {
        Log.i("ActivityOne", "activity One onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("ActivityOne", "activity One onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("ActivityOne", "activity One onRestart");
        super.onRestart();
        callsOnRestart++;
        updateCallsToView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("ActivityOne", "activity One onSaveInstanceState");
        copyToState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        Log.i("ActivityOne", "activity One onDestroy");
        super.onDestroy();  // Always call the superclass
    }

    public void clickButtonActivityOne(View view) {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
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
