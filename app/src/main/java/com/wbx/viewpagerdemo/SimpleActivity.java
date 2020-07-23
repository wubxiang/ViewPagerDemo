package com.wbx.viewpagerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wbx
 * Date: 2020/7/23
 * Description:
 */

public class SimpleActivity extends AppCompatActivity {
    private ViewPager mViewpager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.simple_activity);

        mViewpager = findViewById(R.id.viewpager);

        ImageView img1 = new ImageView(this);
        img1.setImageResource(R.drawable.v1);
        ImageView img2 = new ImageView(this);
        img2.setImageResource(R.drawable.v2);
        ImageView img3 = new ImageView(this);
        img3.setImageResource(R.drawable.v3);

        List<View> list = new ArrayList<>();
        list.add(img1);
        list.add(img2);
        list.add(img3);

        mViewpager.setAdapter(new ViewpagerAdapter(list));
    }
}
