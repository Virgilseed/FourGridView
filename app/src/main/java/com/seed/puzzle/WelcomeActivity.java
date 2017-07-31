package com.seed.puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * @author: Seed
 * @date: 2017-07-31 11:05
 */


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mNormalBtn;
    private TextView mListviewBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mNormalBtn = (TextView) findViewById(R.id.test_normal);
        mListviewBtn = (TextView) findViewById(R.id.test_listview);
        mNormalBtn.setOnClickListener(this);
        mListviewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_normal:
                startActivity(new Intent(WelcomeActivity.this, DemoNormalActivity.class));
                break;
            case R.id.test_listview:
                startActivity(new Intent(WelcomeActivity.this, DemoListActivity.class));
                break;
        }
    }
}
