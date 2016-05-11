package com.jiahuaandroid.androiddatabinding.adapter;

import android.view.View;

/**
 * Created by jhhuang on 2016/3/3.
 * QQ: 781913268
 * 作用：短按监听器
 */
public interface OnItemClickListener<T> {
    void onClick(View view, T item);
}
