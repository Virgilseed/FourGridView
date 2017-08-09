package com.seed.puzzle;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.puzzle.library.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seed on 2017/7/23.
 */

public class NineGroupImageView<T> extends ViewGroup {


    private int mRowCount; //行数
    private int mColumnCount;  //列数

    private int mMaxSize = 9;  //最大图片数
    private int mGap; //宫格间距

    private int parentWidth;//父组件宽
    private int parentHeight;//父组件高

    private List<ImageView> mImageViewList = new ArrayList<>();
    private List<T> mImgDataList;

    private NineGridImageViewAdapter<T> mAdapter;

    private boolean showOnlyFour = true;

    public NineGroupImageView(Context context) {
        this(context, null);
    }

    public NineGroupImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NineGroupImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NineGridImageView);
        this.mGap = (int) typedArray.getDimension(R.styleable.NineGridImageView_imgGap, 8);
        typedArray.recycle();
    }


    /**
     * 设定宽高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        parentWidth = measureWidth(widthMeasureSpec);
        parentHeight = measureHeight(heightMeasureSpec);

        setMeasuredDimension(parentWidth, parentHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        layoutChildrenFourView();
    }


    /**
     * 为子ImageView布局
     */
    private void layoutChildrenFourView() {
        if (mImgDataList == null) {
            return;
        }
        int childrenCount = mImgDataList.size();
        int max = 4;
        if (childrenCount >= max)
            max = 4;
        else
            max = childrenCount;
        for (int i = 0; i < max; i++) {
            ImageView childrenView = (ImageView) getChildAt(i);

            int mImageWidthSize = (parentWidth - mGap) / 2;//图片尺寸

            int rowNum = i / mColumnCount;//当前行数
            int columnNum = i % mColumnCount;//当前列数
            int mImageSize = (parentWidth - (mColumnCount + 1) * mGap) / mColumnCount;//图片尺寸

            int t_center = (parentHeight + mGap) / 2;//中间位置以下的顶点（有宫格间距）
            int b_center = (parentHeight - mGap) / 2;//中间位置以上的底部（有宫格间距）
            int l_center = (parentWidth + mGap) / 2;//中间位置以右的左部（有宫格间距）
            int r_center = (parentWidth - mGap) / 2;//中间位置以左的右部（有宫格间距）
            int center = (parentHeight - mImageSize) / 2;//中间位置以上顶部（无宫格间距）

            int left = mImageSize * columnNum + mGap * (columnNum + 1);
            int top = mImageSize * rowNum + mGap * (rowNum + 1);
            int right = left + mImageSize;
            int bottom = top + mImageSize;

            if (childrenCount == 1) {
                childrenView.layout(0, 0, parentWidth, parentHeight);
            }else if (childrenCount == 2){
                childrenView.layout(mImageWidthSize * i + mGap * i, 0, mImageWidthSize * (i + 1) + mGap * i, parentHeight);
            }else if (childrenCount == 3){
                if (i == 0) {
                    childrenView.layout(0, 0, mImageWidthSize, parentHeight);
                }else {
                    childrenView.layout(mImageWidthSize + mGap, mImageWidthSize * (i - 1) + mGap * (i - 1), mImageWidthSize * 2 + mGap, mImageWidthSize * i + mGap * (i - 1));
                }
            }else if (childrenCount >= 4){
                if (i <= 1)
                    childrenView.layout(mImageWidthSize * i + mGap * i, 0, mImageWidthSize * (i + 1) + mGap * i, mImageWidthSize);
                else
                    childrenView.layout(mImageWidthSize * (i - 2) + mGap * (i - 2), mImageWidthSize + mGap, mImageWidthSize * (i - 1) + mGap * (i - 2), mImageWidthSize * 2 + mGap);
            }
            if (mAdapter != null && childrenView.getDrawable() == null) {
                mAdapter.onDisplayImage(getContext(), childrenView, mImgDataList.get(i));
            }
        }
    }

    /**
     * 设置图片数据
     *
     * @param lists 图片数据集合
     */
    public void setImagesData(List<T> lists) {
        if (lists == null || lists.isEmpty()) {
            this.setVisibility(GONE);
            return;
        } else {
            this.setVisibility(VISIBLE);
        }

        if (mMaxSize > 0 && lists.size() > mMaxSize) {
            lists = lists.subList(0, mMaxSize);
        }

        int[] gridParam = calculatefourParam(lists.size());
        mRowCount = gridParam[0];
        mColumnCount = gridParam[1];

        int numbers = 4;
        if (lists.size() < 4)
            numbers = lists.size();
        removeAllViews();
        for (int i = 0; i < numbers; i++) {
            final ImageView itemView = mAdapter.generateImageView(getContext());;
            if (mAdapter != null) {
                mAdapter.onDisplayImage(getContext(), itemView, lists.get(i));
                final int finalI = i;
                itemView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mAdapter.onItemImageClick(getContext(), itemView, finalI, mImgDataList);
                    }
                });

            }
            addView(itemView, generateDefaultLayoutParams());
        }

//        if (mImgDataList == null) {
//            int i = 0;
//            while (i < lists.size()) {
//                if (showOnlyFour && i < 4) {
//                    ImageView iv = getImageView(i);
//                    if (iv == null) {
//                        return;
//                    }
//                    addView(iv, generateDefaultLayoutParams());
//                }
//                i++;
//            }
//        } else {
//            int oldViewCount = mImgDataList.size();
//            int newViewCount = lists.size();
//            if (oldViewCount > newViewCount) {
//                removeViews(newViewCount, oldViewCount - newViewCount);
//            } else if (oldViewCount < newViewCount && 4 > oldViewCount) {
//                //@// TODO: 2017/7/23  仅限 4个view
//                for (int i = oldViewCount; i < 4 - oldViewCount; i++) {
//                    ImageView iv = getImageView(i);
//                    if (iv == null) {
//                        return;
//                    }
//                    addView(iv, generateDefaultLayoutParams());
//                }
//            }
//        }
        mImgDataList = lists;
        requestLayout();
    }

    /**
     * 获得 ImageView
     * 保证了 ImageView的重用
     *
     * @param position 位置
     */
    private ImageView getImageView(final int position) {
        if (position < mImageViewList.size()) {
            return mImageViewList.get(position);
        } else {
            if (mAdapter != null) {
                ImageView imageView = mAdapter.generateImageView(getContext());
                mImageViewList.add(imageView);
                return imageView;
            } else {
                return null;
            }
        }
    }

    /**
     * 设置宫格参数
     *
     * @param imagesSize 图片数量
     * @return 宫格参数 gridParam[0] 宫格行数 gridParam[1] 宫格列数
     */
    protected static int[] calculateGridParam(int imagesSize) {
        int[] gridParam = new int[2];
        if (imagesSize < 3) {
            gridParam[0] = 1;
            gridParam[1] = imagesSize;
        } else if (imagesSize <= 4) {
            gridParam[0] = 2;
            gridParam[1] = 2;
        } else {
            gridParam[0] = imagesSize / 3 + (imagesSize % 3 == 0 ? 0 : 1);
            gridParam[1] = 3;
        }
        return gridParam;
    }


    protected static int[] calculatefourParam(int imagesSize){
        int[] gridParam = new int[2];
        if (imagesSize < 3) {
            gridParam[0] = 1;
            gridParam[1] = imagesSize;
        } else if (imagesSize <= 4) {
            gridParam[0] = 2;
            gridParam[1] = 2;
        } else {
            gridParam[0] = 2;
            gridParam[1] = 2;
        }
        return gridParam;
    }

    /**
     * 设置适配器
     *
     * @param adapter 适配器
     */
    public void setAdapter(NineGridImageViewAdapter adapter) {
        mAdapter = adapter;
    }

    /**
     * 设置宫格间距
     *
     * @param gap 宫格间距 px
     */
    public void setGap(int gap) {
        mGap = gap;
    }

    /**
     * 对宫格的宽高进行重新定义
     */
    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}

