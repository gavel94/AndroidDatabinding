package com.jiahuaandroid.androiddatabinding;

import android.view.View;
import android.view.ViewGroup;

import com.jiahuaandroid.androiddatabinding.adapter.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * Created by jhhuang on 2016/5/11.
 * 作用：recyclerview的适配器
 */
public class TestAdapter extends BaseRecyclerViewAdapter<Item,TestAdapter.MyViewHolder> {


    /**
     * @param list the datas to attach the adapter
     */
    public TestAdapter(List<Item> list) {
        super(list);
    }

    @Override
    public int getItemViewType(int position) {
        if("0".equals(mList.get(position).getType())) {
            return 0;
        }else if ("1".equals(mList.get(position).getType())) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    protected void bindDataToItemView(MyViewHolder myViewHolder, Item item) {
        if("0".equals(item.getType())) {
            myViewHolder.setText(R.id.tv_left,item.getLocation());
        }else if ("1".equals(item.getType())) {
            myViewHolder.setText(R.id.tv_center, item.getLocation());
        } else {
            myViewHolder.setText(R.id.tv_right, item.getLocation());
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType ==0) {
            return new MyViewHolder(inflateItemView(parent,R.layout.left));
        }else if (viewType == 1) {
            return new MyViewHolder(inflateItemView(parent, R.layout.center));
        } else {
            return new MyViewHolder(inflateItemView(parent, R.layout.right));
        }

    }

    public class MyViewHolder extends BaseRecyclerViewAdapter.SparseArrayViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
