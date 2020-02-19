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

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ActivitiesFragment extends Fragment {
    View view;
    private ArrayList<String>mNames;
    private ArrayList<String>mImageUrls;
    public ActivitiesFragment() {
        mNames=new ArrayList<>();
        mImageUrls=new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_activities, container, false);
        Log.d(TAG, "onCreateView: started");
        initImagesBitmaps();
        return view;
    }
    private void initImagesBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.add("https://www.flickr.com/photos/mcdenbesten/28993819431");
        mNames.add("Sport Activity at Fayoum University is Under the Lead of Doctor Hesham Ragab" +
                " It Consists of A lot of Teams You can ask to attend auditions any time");
        mImageUrls.add("https://www.flickr.com/photos/mcdenbesten/28993819431");
        mNames.add("Arts Activity at Fayoum University is Under the Lead of Doctor Hesham Ragab\" \n" +
                "                \" It Consists of A lot of Teams You can ask to attend auditions any time\"");
        mImageUrls.add("https://www.flickr.com/photos/mcdenbesten/28993819431");
        mNames.add("Literature Activity at Fayoum University is Under the Lead of Doctor Hesham Ragab\" \n" +
                "                \" It Consists of A lot of Teams You can ask to attend auditions any time\"");
        mImageUrls.add("https://www.flickr.com/photos/mcdenbesten/28993819431");
        mNames.add("Culture Activity at Fayoum University is Under the Lead of Doctor Hesham Ragab\" \n" +
                "                \" It Consists of A lot of Teams You can ask to attend auditions any time\"");
        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "RecyclerView: init recyclerView");
        RecyclerView recyclerView= view.findViewById(R.id.recycler_view_Activities);
        ActivitiesAdapter adapter=new ActivitiesAdapter(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    }

