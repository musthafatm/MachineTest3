package com.whirlwind.iroid.machinetest3.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.whirlwind.iroid.machinetest3.R;
import com.whirlwind.iroid.machinetest3.model.JsoncyclerFeeder;
import com.whirlwind.iroid.machinetest3.model.Result;

import java.util.List;

/**
 * Created by Acer on 02-Aug-17.
 */

public class JsoncyclerAdapter extends RecyclerView.Adapter<JsoncyclerAdapter.CustomViewHolder> {

    private Result[] jsoncyclerFeederList;
    private Context mContext;


    public JsoncyclerAdapter(Context context, Result[] JsoncyclerFeederList) {

        this.jsoncyclerFeederList = JsoncyclerFeederList;
        this.mContext = context;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Result result = jsoncyclerFeederList[position];

        holder.textViewTitle.setText(result.getTitle());
        holder.textViewDescribe.setText(result.getDescription());


        holder.mRecyclerView.setAdapter(new ImageAdapter(mContext, jsoncyclerFeederList[position].getImage_url()));



//        //In case of error, replace within load - the url to be called.

//
//        Picasso.with(mContext).load(jsoncyclerFeederList[position].getImage_url().length > 0 ? jsoncyclerFeederList[position].getImage_url()[0] : "")
//                .error(R.drawable.placeholder)
//                .placeholder(R.drawable.placeholder)
//                .into(holder.imageView1);
//
//        //If required make the above picasso loading and the below within an if - to check for the dual images
//
//        if (jsoncyclerFeederList[position].getImage_url().length > 1) {
//            Picasso.with(mContext).load(jsoncyclerFeederList[position].getImage_url()[1])
//                    .error(R.drawable.placeholder)
//                    .placeholder(R.drawable.placeholder)
//                    .into(holder.imageView2);
//        }


    }

    @Override
    public int getItemCount() {
        return jsoncyclerFeederList.length;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewTitle;
        protected TextView textViewDescribe;

        protected  RecyclerView mRecyclerView;
        public CustomViewHolder(View view) {
            super(view);
            this.textViewTitle = (TextView) view.findViewById(R.id.tvListTitle);
            this.textViewDescribe = (TextView) view.findViewById(R.id.tvListDescription);
            this.mRecyclerView = (RecyclerView) view.findViewById(R.id.imageRecyclerView);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        }
    }


}
