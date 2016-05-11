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
 * 作用：测试databinding在fragment的使用
 */
public class TestFragment extends Fragment {

    private FragmentTestBinding binding;
    private ArrayList<Item> data;
    private TestAdapter adapter;
    private LinearLayoutManager llmanager;
    private GridLayoutManager glmanager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        binding.reGl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
