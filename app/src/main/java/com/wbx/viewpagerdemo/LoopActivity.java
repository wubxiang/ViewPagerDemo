package com.wbx.viewpagerdemo;

import android.os.Bundle;
import android.util.Log;
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
 * Description: LoopActivity
 */

public class LoopActivity extends AppCompatActivity {
    private ViewPager mViewpager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loop_activity);

        mViewpager = findViewById(R.id.viewpager);

        ImageView img0 = new ImageView(this);
        img0.setImageResource(R.drawable.v3);
        ImageView img1 = new ImageView(this);
        img1.setImageResource(R.drawable.v1);
        ImageView img2 = new ImageView(this);
        img2.setImageResource(R.drawable.v2);
        ImageView img3 = new ImageView(this);
        img3.setImageResource(R.drawable.v3);
        ImageView img4 = new ImageView(this);
        img4.setImageResource(R.drawable.v1);

        final List<View> list = new ArrayList<>();
        //随软img0和img3图片相同但是不能使用同一个imgview,否则报错
        list.add(img0);
        list.add(img1);
        list.add(img2);
        list.add(img3);
        list.add(img4);

        mViewpager.setAdapter(new ViewpagerAdapter(list));

        mViewpager.setCurrentItem(1,false);

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("Viewpager", "onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("Viewpager", "onPageSelected; position:"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("Viewpager", "onPageScrollStateChanged; state:" + state);
                //滑动停止时，切换
                // 无线循环实现部分
                if(state == ViewPager.SCROLL_STATE_IDLE){
                    if(mViewpager.getCurrentItem() == list.size()-1){
                        mViewpager.setCurrentItem(1, false);
                    }else if(mViewpager.getCurrentItem() == 0){
                        mViewpager.setCurrentItem(list.size()-2, false);
                    }
                }
            }
        });
    }
}
