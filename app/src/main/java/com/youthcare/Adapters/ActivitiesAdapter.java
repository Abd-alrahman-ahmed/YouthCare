package com.youthcare.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youthcare.Fragments.ActivitiesFragment;
import com.youthcare.R;
import com.youthcare.models.department;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>{
    private static final String TAG = "ActivitiesAdapter";
    private List<department> departments = new ArrayList<>();
    private ActivitiesFragment mContext;

    public ActivitiesAdapter(List<department> departments, ActivitiesFragment mContext) {
        this.departments = departments;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activities,parent,false);
        ViewHolder holder=new ViewHolder(view);
        
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.Image.setImageResource(departments.get(position).getImage());
        holder.ImageName.setText(departments.get(position).getAbout());
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView Image;
        TextView ImageName;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Image=itemView.findViewById(R.id.image);
            ImageName=itemView.findViewById(R.id.image_name);
            parentLayout=itemView.findViewById(R.id.parent_layout);
        }
    }
}
