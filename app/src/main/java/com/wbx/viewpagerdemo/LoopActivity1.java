package com.wbx.viewpagerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: wbx
 * Date: 2020/7/23
 * Description: LoopActivity
 */

public class LoopActivity1 extends AppCompatActivity {
    private ViewPager mViewpager;
    private List<View> mList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loop_activity1);

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

        mList = new ArrayList<>();
        //随软img0和img3图片相同但是不能使用同一个imgview,否则报错
        mList.add(img0);
        mList.add(img1);
        mList.add(img2);
        mList.add(img3);
        mList.add(img4);

        mViewpager.setAdapter(new ViewpagerAdapter(mList));

        // 去除滑动效果
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
                    if(mViewpager.getCurrentItem() == mList.size()-1){
                        mViewpager.setCurrentItem(1, false);
                    }else if(mViewpager.getCurrentItem() == 0){
                        mViewpager.setCurrentItem(mList.size()-2, false);
                    }
                }
            }
        });

        timeTurn();
    }

    // 定时轮播
    private void timeTurn(){
        //实例化定时器
        Timer timer = new Timer();
        //指定定时器计划
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int index = mViewpager.getCurrentItem();
                Message msg = Message.obtain();
                index++;
                msg.arg1 = index;
                mHandler.sendMessage(msg);
            }
        }, 3000, 3000);//第二个参数：延时，第三个间隔
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            mViewpager.setCurrentItem(msg.arg1);
        }
    };
}
