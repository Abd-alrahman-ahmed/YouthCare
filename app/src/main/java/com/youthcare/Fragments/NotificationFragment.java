package com.youthcare.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youthcare.Activities.itemnotification;
import com.youthcare.Adapters.NewsAdapter;
import com.youthcare.Adapters.Notificationadapters;
import com.youthcare.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    View view;
    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
    List<itemnotification> mData;


    public NotificationFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notifications, container, false);
        NewsRecyclerview= view.findViewById(R.id.notification);
        Notificationadapters r=new Notificationadapters(getContext(),mData);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        NewsRecyclerview.setAdapter(r);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData=new ArrayList<>();
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
        mData.add(new itemnotification("mohamed","mohamedramdan","18",R.drawable.circul6));
    }
}
