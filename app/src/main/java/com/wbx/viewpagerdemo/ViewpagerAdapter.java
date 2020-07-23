package com.wbx.viewpagerdemo;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Author: wbx
 * Date: 2020/7/23
 * Description:
 */

public class ViewpagerAdapter extends PagerAdapter {
    private List<View> mViewList;

    public ViewpagerAdapter(List<View> list) {
        mViewList = list;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    // 判断view和obj是否为同一个view
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    // 获取当前列表项
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    // 当前项离开屏幕时回调本方法，在本方法中需要将当前项从ViewPager中移除
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mViewList.get(position));
    }
}
