package com.seed.puzzle;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Gray on 2017/7/23.
 */

public abstract class NineGridImageViewAdapter<T> {
    protected abstract void onDisplayImage(Context context, ImageView imageView, T t);



    protected ImageView generateImageView(Context context){
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    public abstract void onItemImageClick(Context context, ImageView itemView, int position, List<T> mImgDataList);
}
