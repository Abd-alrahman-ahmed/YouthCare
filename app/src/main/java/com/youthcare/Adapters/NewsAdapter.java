package com.youthcare.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.youthcare.R;
import com.youthcare.models.Post;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<Post> postsData;
    ViewGroup parent;

    public NewsAdapter(List<Post> postsData) {
        this.postsData = postsData;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = parent;
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent,false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Post post = postsData.get(position);
        holder.post_title.setText(post.getTitle());
        holder.post_date.setText(post.getDate());
        holder.post_description.setText(post.getContent());
        holder.img_user.setImageResource(post.getUserImage());
        holder.post_image.setImageResource(post.getPostImage());
    }

    @Override
    public int getItemCount() {
        return postsData.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView post_title, post_description, post_date;
        ImageView img_user, post_image;
        RelativeLayout container;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            container = (RelativeLayout) itemView.findViewById(R.id.container);
            post_title = (TextView) itemView.findViewById(R.id.post_title);
            post_description = (TextView) itemView.findViewById(R.id.post_description);
            post_date = (TextView) itemView.findViewById(R.id.post_date);
            img_user = (ImageView) itemView.findViewById(R.id.img_user);
            post_image = (ImageView) itemView.findViewById(R.id.post_image);
        }
    }
}