package com.youthcare.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.youthcare.Activities.MainActivity;
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(parent.getContext())
                        .setTitle("Reservation Confirmation")
                        .setMessage("Do you really want to reserve this event ?")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(parent.getContext(), "Event Reserved", Toast.LENGTH_SHORT).show();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
                }
            });
            container = (RelativeLayout) itemView.findViewById(R.id.container);
            post_title = (TextView) itemView.findViewById(R.id.post_title);
            post_description = (TextView) itemView.findViewById(R.id.post_description);
            post_date = (TextView) itemView.findViewById(R.id.post_date);
            img_user = (ImageView) itemView.findViewById(R.id.img_user);
            post_image = (ImageView) itemView.findViewById(R.id.post_image);
        }
    }
}