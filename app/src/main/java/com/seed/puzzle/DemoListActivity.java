package com.seed.puzzle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.seed.puzzle.adapter.DemoListAdapter;
import com.seed.puzzle.model.TestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: Seed
 * @date: 2017-07-31 10:27
 */


public class DemoListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DemoListAdapter mAdapter;
    private List<TestModel> mDataLists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.demo_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        mAdapter = new DemoListAdapter(this, mDataLists);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            TestModel model = new TestModel();
            model.setContent("测试第-----" + i + "------条");
            int max = getRandom(1, 5);
            List<String> urls = new ArrayList<>();
            for (int j = 0; j < max; j++) {
                if (j % 2 == 0)
                    urls.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
                else
                    urls.add("http://ac-QYgvX1CC.clouddn.com/36f0521888a57.jpg");
            }
            model.setUrls(urls);
            mDataLists.add(model);
        }
    }

    public static int getRandom(int min, int max)
    {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}
