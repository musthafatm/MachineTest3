package com.whirlwind.iroid.machinetest3.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.whirlwind.iroid.machinetest3.R;

/**
 * Created by Muhammed on 02/08/17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.CustomViewHolder> {

    private Context context;
    private String[] imageUrls;

    public ImageAdapter(Context mContext, String[] image_url) {
        this.context = mContext;
        this.imageUrls = image_url;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image, null);

        if (imageUrls.length > 1) {

        } else {


        }

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Picasso.with(context).load(imageUrls[position])
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder).resize(200, 200).centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageUrls.length;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;

        public CustomViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);

        }
    }
}
