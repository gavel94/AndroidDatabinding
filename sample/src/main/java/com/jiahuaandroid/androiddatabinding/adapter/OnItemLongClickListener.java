package com.jiahuaandroid.androiddatabinding.adapter;

import android.view.View;

/**
 * Created by jhhuang on 2016/3/3.
 * QQ: 781913268
 * 作用：长按监听
 */
public interface OnItemLongClickListener<T> {
    void onLongClick(View view, T item);
}
