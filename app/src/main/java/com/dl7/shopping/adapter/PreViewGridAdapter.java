package com.dl7.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dl7.shopping.R;

import java.util.List;

/**
 * Created by MC.Zeng on 2017-07-06.
 */

public class PreViewGridAdapter extends BaseAdapter {
    private List<String> lstImageItem;
    private Context mContext;

    public PreViewGridAdapter(Context mContext, List<String> arg0) {
        this.lstImageItem = arg0;
        this.mContext = mContext;
    }

    public int getCount() {
        return lstImageItem.size();
    }

    public Object getItem(int position) {
        return lstImageItem.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {


        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_img, null);
            viewHolder.img = (ImageView) view.findViewById(R.id.img);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Glide.with(mContext)
                .load(lstImageItem.get(position))
                .centerCrop()
                .thumbnail(0.1f)
                .placeholder(R.drawable.__picker_ic_photo_black_48dp)
                .error(R.drawable.__picker_ic_broken_image_black_48dp)
                .into(viewHolder.img);

        return view;
    }

    class ViewHolder {
        ImageView img;
    }
}
