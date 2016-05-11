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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("DataBinding Test");
        binding.setUser(user);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new TestFragment()).commit();
    }
}
