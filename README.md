# FourGridView
仿微信个人朋友圈多图组合（4宫格）
## 示例
![](https://github.com/Virgilseed/FourGridView/blob/master/test.gif)

## 使用
#### 2.1布局
        <com.seed.puzzle.NineGroupImageView
            android:layout_below="@id/item_content"
            android:layout_toRightOf="@id/item_image"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_marginLeft="10dp"
            android:layout_marginTop="10dp"
            android:id="@+id/item_group">

          </com.seed.puzzle.NineGroupImageView>
#### 2.2使用
      nineGroupImageView.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String url) {
                Glide.with(mContext).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5")))
                        .error(R.mipmap.ic_launcher).into(imageView);
            }

            @Override
            public void onItemImageClick(Context context, ImageView itemView, int position, List mImgDataList) {

            }
        });
      nineGroupImageView.setImagesData(mDataLists.get(position).getUrls());

## 参考感谢
laobie 的 [NineGridView](https://github.com/laobie/NineGridImageView)  

myloften 的 [GroupIconSample](https://github.com/myloften/GroupIconSample)

