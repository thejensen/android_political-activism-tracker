package com.epicodus.politicalactivismtracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.politicalactivismtracker.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.findActionsButton) Button mFindActionsButton;
    @Bind(R.id.inputTitleEditText) EditText mInputTitleEditText;
    @Bind(R.id.inputDateEditText) EditText mInputDateEditText;
    @Bind(R.id.inputLocationEditText) EditText mInputLocationEditText;
    @Bind(R.id.inputLinkEditText) EditText mLinkEditText;
    @Bind(R.id.inputImageUrlEditText) EditText mInputImageUrlEditText;
    @Bind(R.id.inputCauseEditText) EditText mInputCauseEditText;
    @Bind(R.id.inputActionTypeEditText) EditText mInputActionTypeEditText;
    @Bind(R.id.inputPriceEditText) EditText mInputPriceEditText;
    @Bind(R.id.inputDescriptionEditText) EditText mInputDescriptionEditText;
    @Bind(R.id.submitNewActionInputButton) Button mSubmitNewActionInputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindActionsButton.setOnClickListener(this);
        mSubmitNewActionInputButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == mSubmitNewActionInputButton) {
            String title = mInputTitleEditText.getText().toString();
            String date = mInputDateEditText.getText().toString();
            String location = mInputLocationEditText.getText().toString();
            String externalLink = mLinkEditText.getText().toString();
            String image = mInputImageUrlEditText.getText().toString();
            String cause = mInputCauseEditText.getText().toString();
            String actionType = mInputActionTypeEditText.getText().toString();
            String price = mInputPriceEditText.getText().toString();
            String description = mInputDescriptionEditText.getText().toString();
            Log.v(TAG, "Location is: " + location);
            Toast.makeText(MainActivity.this, "OMG WHY", Toast.LENGTH_SHORT).show();
        }
        if (v == mFindActionsButton) {
            Intent intent = new Intent(MainActivity.this, ActivismActivity.class);
            startActivity(intent);
        }
    }
}
