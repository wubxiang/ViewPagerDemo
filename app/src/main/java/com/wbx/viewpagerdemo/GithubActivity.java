package com.wbx.viewpagerdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wbx
 * Date: 2020/7/23
 * Description:
 */

public class GithubActivity extends AppCompatActivity {
    private Banner mBanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.github_activity);

        mBanner = findViewById(R.id.banner);

        List<DataBean> list = new ArrayList<>();
        DataBean dataBean1 = new DataBean();
        dataBean1.setImgResourceId(R.drawable.v1);
        list.add(dataBean1);
        DataBean dataBean2 = new DataBean();
        dataBean2.setImgResourceId(R.drawable.v2);
        list.add(dataBean2);
        DataBean dataBean3 = new DataBean();
        dataBean3.setImgResourceId(R.drawable.v3);
        list.add(dataBean3);

        mBanner.setAdapter(new BannerAapter(list))
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this));

    }
}
