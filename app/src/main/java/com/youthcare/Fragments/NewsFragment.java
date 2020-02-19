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

    public NewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);

        newsRecycler = (RecyclerView) view.findViewById(R.id.news_rs);
        postsData = new ArrayList<>();
        
        postsData.add(new Post("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", R.drawable.userphoto, null, "6 july 1994"));
        postsData.add(new Post("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", R.drawable.circul6, null, "6 july 1994"));
        postsData.add(new Post("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", R.drawable.uservoyager, null, "6 july 1994"));
        postsData.add(new Post("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", R.drawable.useillust, null, "6 july 1994"));
        postsData.add(new Post("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", R.drawable.circul6, null, "6 july 1994"));
        postsData.add(new Post("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", R.drawable.userphoto, null, "6 july 1994"));
        postsData.add(new Post("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", R.drawable.userphoto, null, "6 july 1994"));
        postsData.add(new Post("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", R.drawable.circul6, null, "6 july 1994"));
        postsData.add(new Post("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", R.drawable.uservoyager, null, "6 july 1994"));
        postsData.add(new Post("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", R.drawable.useillust, null, "6 july 1994"));
        postsData.add(new Post("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", R.drawable.circul6, null, "6 july 1994"));
        postsData.add(new Post("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", R.drawable.userphoto, null, "6 july 1994"));
        postsData.add(new Post("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", R.drawable.userphoto, null, "6 july 1994"));
        postsData.add(new Post("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", R.drawable.circul6, null, "6 july 1994"));
        postsData.add(new Post("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", R.drawable.uservoyager, null, "6 july 1994"));
        postsData.add(new Post("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", R.drawable.useillust, null, "6 july 1994"));
        postsData.add(new Post("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", R.drawable.circul6, null, "6 july 1994"));
        postsData.add(new Post("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", R.drawable.userphoto, null, "6 july 1994"));

        // adapter init and setup
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newsRecycler.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(postsData);
        newsRecycler.setAdapter(newsAdapter);
        
        return view;
    }
}
