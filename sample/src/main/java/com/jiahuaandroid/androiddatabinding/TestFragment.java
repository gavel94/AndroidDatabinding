package com.jiahuaandroid.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiahuaandroid.androiddatabinding.databinding.FragmentTestBinding;

import java.util.ArrayList;

/**
 * Created by jhhuang on 2016/5/11.
 * QQ:781913268
 * 作用：测试databinding在fragment的使用
 */
public class TestFragment extends Fragment {

    private FragmentTestBinding binding;
    private ArrayList<Item> data;
    private TestAdapter adapter;
    /**
     * 线性布局管理器
     */
    private LinearLayoutManager llmanager;
    /**
     * gridview的布局管理器
     */
    private GridLayoutManager glmanager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //获取bind对象，进行findviewbyid操作，通过binding.getRoot()获取视图
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
        Item botton = new Item("listview","gridview");
        binding.setButton(botton);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        init();
        initListener();
        super.onActivityCreated(savedInstanceState);
    }

    private void initListener() {
        //获取xml文件中带id的控件并设置点击事件
        binding.reGl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换recyclerview的布局管理器
                binding.fragRecycler.setLayoutManager(glmanager);
                adapter.notifyDataSetChanged();
            }
        });
        binding.reLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.fragRecycler.setLayoutManager(llmanager);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        data = new ArrayList<>();
        llmanager = new LinearLayoutManager(getActivity());
        glmanager = new GridLayoutManager(getActivity(), 2);
        binding.fragRecycler.setLayoutManager(llmanager);
        adapter = new TestAdapter(data);
        binding.fragRecycler.setAdapter(adapter);
        //初始化recyclerview的数据
        initData();
        adapter.notifyDataSetChanged();
    }


    private void initData() {
        data.add(new Item("0", "左"));
        data.add(new Item("2", "右"));
        data.add(new Item("0", "左"));
        data.add(new Item("1", "中"));
        data.add(new Item("1", "中"));
        data.add(new Item("2", "右"));
        data.add(new Item("1", "中"));
        data.add(new Item("2", "右"));
        data.add(new Item("0", "左"));
        data.add(new Item("1", "中"));
        data.add(new Item("2", "右"));
        data.add(new Item("0", "左"));
        data.add(new Item("1", "中"));
        data.add(new Item("2", "右"));
    }
}
