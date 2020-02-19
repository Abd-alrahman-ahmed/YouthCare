package com.youthcare.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youthcare.Activities.itemnotification;
import com.youthcare.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Notificationadapters extends RecyclerView.Adapter<Notificationadapters.NewsViewHolder> {
    Context mcontext;
    List<itemnotification> mData;

    public Notificationadapters(Context mcontext, List<itemnotification> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mcontext).inflate(R.layout.item_notification, parent,false);
        NewsViewHolder vHolder = new NewsViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_time.setText(mData.get(position).getTime());
        holder.tv_text.setText(mData.get(position).getText());
        holder.tv_img.setImageResource(mData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class NewsViewHolder extends  RecyclerView.ViewHolder{
        private TextView tv_title;
        private TextView tv_time;
        private TextView tv_text;
        private ImageView tv_img;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_time=itemView.findViewById(R.id.tv_time);
            tv_text=itemView.findViewById(R.id.tv_data);
            tv_img=itemView.findViewById(R.id.img_user);

        }
    }
}
