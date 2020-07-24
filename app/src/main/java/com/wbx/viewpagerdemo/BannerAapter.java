package com.wbx.viewpagerdemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * Author: wbx
 * Date: 2020/7/23
 * Description:
 */

public class BannerAapter extends BannerAdapter<DataBean, BannerAapter.BannerViewHoleder> {

    public BannerAapter(List<DataBean> datas) {
        super(datas);
    }

    @Override
    public BannerViewHoleder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHoleder(imageView);
    }

    @Override
    public void onBindView(BannerViewHoleder holder, DataBean data, int position, int size) {
        holder.imageView.setImageResource(data.getImgResourceId());
    }

    class BannerViewHoleder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public BannerViewHoleder(@NonNull ImageView itemView) {
            super(itemView);
            imageView = itemView;
        }
    }
}
