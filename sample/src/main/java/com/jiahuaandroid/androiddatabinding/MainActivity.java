package com.jiahuaandroid.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jiahuaandroid.androiddatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //代替setcontentview并且进行findviewbyid操作
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //创建对象在布局文件中使用，对应<data />标签内的变量
        User user = new User("DataBinding Test");
        //设置对象，对应<data />标签内的变量
        binding.setUser(user);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new TestFragment()).commit();
    }
}
