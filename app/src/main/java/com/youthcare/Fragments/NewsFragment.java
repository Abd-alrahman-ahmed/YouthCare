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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.youthcare.Adapters.NewsAdapter;
import com.youthcare.R;
import com.youthcare.models.Post;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    View view;
    RecyclerView newsRecycler;
    NewsAdapter newsAdapter;
    List<Post> postsData;
    private DatabaseReference mDatabase;
    private ChildEventListener childEventListener;
    public NewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);

        newsRecycler = (RecyclerView) view.findViewById(R.id.news_rs);
        postsData = new ArrayList<>();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                Post post = dataSnapshot.getValue(Post.class);
                postsData.add(post);
                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Post post = dataSnapshot.getValue(Post.class);
                postsData.add(post);
                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mDatabase = FirebaseDatabase.getInstance().getReference("posts");
        mDatabase.addChildEventListener(childEventListener);

        // adapter init and setup
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newsRecycler.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(postsData);
        newsRecycler.setAdapter(newsAdapter);
        
        return view;
    }
}
