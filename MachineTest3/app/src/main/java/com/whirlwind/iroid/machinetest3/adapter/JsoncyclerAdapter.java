package com.whirlwind.iroid.machinetest3.adapter;

import android.content.Context;
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

import java.util.List;

/**
 * Created by Acer on 02-Aug-17.
 */

public class JsoncyclerAdapter extends RecyclerView.Adapter<JsoncyclerAdapter.CustomViewHolder> {

    private List<JsoncyclerFeeder> JsoncyclerFeederList;
    private Context mContext;


    public JsoncyclerAdapter(Context context, List<JsoncyclerFeeder> JsoncyclerFeederList){

        this.JsoncyclerFeederList = JsoncyclerFeederList;
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

        JsoncyclerFeeder feederObj1 = JsoncyclerFeederList.get(position);

        holder.textViewTitle.setText(Html.fromHtml(JsoncyclerFeeder.getTitle()));
        holder.textViewDescribe.setText(Html.fromHtml(JsoncyclerFeeder.getDescription()));

        //In case of error, replace within load - the url to be called.
        Picasso.with(mContext).load(feederObj1.getImg1())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView1);

        //If required make the above picasso loading and the below within an if - to check for the dual images

        Picasso.with(mContext).load(feederObj1.getImg2())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView2);



    }

    @Override
    public int getItemCount() {
        return JsoncyclerFeederList.size();
    }




    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewTitle;
        protected TextView textViewDescribe;
        protected ImageView imageView1;
        protected ImageView imageView2;

        public CustomViewHolder(View view) {
            super(view);
            this.textViewTitle = (TextView) view.findViewById(R.id.tvListTitle);
            this.textViewDescribe = (TextView) view.findViewById(R.id.tvListDescription);
            this.imageView1 = (ImageView) view.findViewById(R.id.thumbnail1);
            this.imageView1 = (ImageView) view.findViewById(R.id.thumbnail2);
        }
    }


}
