package com.seed.puzzle.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seed.puzzle.NineGridImageViewAdapter;
import com.seed.puzzle.NineGroupImageView;
import com.seed.puzzle.R;
import com.seed.puzzle.model.TestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Seed
 * @date: 2017-07-31 10:35
 */


public class DemoListAdapter extends RecyclerView.Adapter<DemoListAdapter.MyHolder> {
    private Context mContext;
    private List<TestModel> mDataLists = new ArrayList<>();
    public DemoListAdapter(Context context, List<TestModel> lists) {
        mContext = context;
        this.mDataLists = lists;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder viewHolder = null;
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_demo_list, null, false);
        viewHolder = new MyHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.content.setText(mDataLists.get(position).getContent());
        holder.nineGroupImageView.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                Glide.with(mContext).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5")))
                        .error(R.mipmap.ic_launcher).into(imageView);
            }

            @Override
            public void onItemImageClick(Context context, ImageView itemView, int position, List mImgDataList) {

            }
        });
        holder.nineGroupImageView.setImagesData(mDataLists.get(position).getUrls());
    }

    @Override
    public int getItemCount() {
        return mDataLists.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        TextView content;
        NineGroupImageView nineGroupImageView;

        public MyHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.item_content);
            nineGroupImageView = (NineGroupImageView) itemView.findViewById(R.id.item_group);
        }
    }
}
