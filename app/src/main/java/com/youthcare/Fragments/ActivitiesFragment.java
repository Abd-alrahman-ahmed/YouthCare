package com.youthcare.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
        return view;
    }
}
