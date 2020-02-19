package com.youthcare.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youthcare.Adapters.ActivitiesAdapter;
import com.youthcare.R;
import com.youthcare.models.department;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ActivitiesFragment extends Fragment {
    View view;
    private List<department> departments;
    public ActivitiesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_activities, container, false);
        departments = new ArrayList<>();
        initImagesBitmaps();
        return view;
    }
    private void initImagesBitmaps(){
        departments.add(new department(null, "Sport Activity", R.drawable.circul6, null, null));
        departments.add(new department(null, "Arts Activity", R.drawable.circul6, null, null));
        departments.add(new department(null, "Literature Activity", R.drawable.circul6, null, null));
        departments.add(new department(null, "Culture Activity", R.drawable.circul6, null, null));

        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView= view.findViewById(R.id.recycler_view_Activities);
        ActivitiesAdapter adapter= new ActivitiesAdapter(departments,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}

