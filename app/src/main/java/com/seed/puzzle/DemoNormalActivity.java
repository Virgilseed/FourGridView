package com.seed.puzzle;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class DemoNormalActivity extends AppCompatActivity {

    private NineGroupImageView mOne, mTwo, mThree, mFour, mFive;
    private List<String> mDataList = new ArrayList<>();

    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    List<String> list4 = new ArrayList<>();
    List<String> list5 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOne = (NineGroupImageView) findViewById(R.id.one);
        mTwo = (NineGroupImageView) findViewById(R.id.two);
        mThree = (NineGroupImageView) findViewById(R.id.three);
        mFour = (NineGroupImageView) findViewById(R.id.four);
        mFive = (NineGroupImageView) findViewById(R.id.five);
        initData();
        mOne.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                Glide.with(DemoNormalActivity.this).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5")))
                        .error(R.mipmap.ic_launcher).into(imageView);
            }

            @Override
            public void onItemImageClick(Context context, ImageView itemView, int position, List<String> mImgDataList) {

            }
        });
        mOne.setImagesData(list1);
        mTwo.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                Glide.with(DemoNormalActivity.this).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5")))
                        .error(R.mipmap.ic_launcher).into(imageView);
            }

            @Override
            public void onItemImageClick(Context context, ImageView itemView, int position, List<String> mImgDataList) {

            }
        });
        mTwo.setImagesData(list2);
        mThree.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                Glide.with(DemoNormalActivity.this).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5")))
                        .error(R.mipmap.ic_launcher).into(imageView);
            }

            @Override
            public void onItemImageClick(Context context, ImageView itemView, int position, List<String> mImgDataList) {

            }
        });
        mThree.setImagesData(list3);
        mFour.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                Glide.with(DemoNormalActivity.this).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5")))
                        .error(R.mipmap.ic_launcher).into(imageView);
            }

            @Override
            public void onItemImageClick(Context context, ImageView itemView, int position, List<String> mImgDataList) {

            }
        });
        mFour.setImagesData(list4);
        mFive.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                Glide.with(DemoNormalActivity.this).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5")))
                        .error(R.mipmap.ic_launcher).into(imageView);
            }

            @Override
            public void onItemImageClick(Context context, ImageView itemView, int position, List<String> mImgDataList) {

            }
        });
        mFive.setImagesData(list5);
    }

    private void initData() {
        list1.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");

        list2.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list2.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");

        list3.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list3.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list3.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");

        list4.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list4.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list4.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list4.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");


        list5.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list5.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list5.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list5.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        list5.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");

    }
}
