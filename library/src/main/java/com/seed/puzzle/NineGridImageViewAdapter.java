package com.seed.puzzle;

import android.content.Context;
import android.widget.ImageView;

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
}
