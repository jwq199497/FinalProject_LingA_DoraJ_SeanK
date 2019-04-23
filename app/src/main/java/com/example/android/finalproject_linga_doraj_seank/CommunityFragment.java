package com.example.android.finalproject_linga_doraj_seank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommunityFragment extends Fragment {

    private static final String TAG = "CommunityFragment";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Post> posts = new ArrayList<>();
    private FloatingActionButton composeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_community, container, false);

        composeButton = (FloatingActionButton) rootView.findViewById(R.id.fab_posting);

        initialBitmaps();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.staggered_recycler_view);
        PostsAdapter adapter = new PostsAdapter(posts, getContext());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);

        composeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ComposeActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private void initialBitmaps(){
        Log.d(TAG, "InitialBitmaps preparing");

        posts.add(new Post("https://www.familyhandyman.com/wp-content/uploads/2017/05/FH16JUN_PAINTS_11.jpg", R.string.painting_hack_title, R.string.painting_author, R.string.painting_likes));
        posts.add(new Post("https://www.familyhandyman.com/wp-content/uploads/2019/04/shutterstock_561902914-1200x675.jpg",R.string.refrig_title, R.string.refrig_author, R.string.refrig_likes));
        posts.add(new Post("https://www.bybrittanygoldwyn.com/wp-content/uploads/2016/12/Cat-Tree-5-March-13.jpg", R.string.cattree_title, R.string.cattree_author, R.string.cattree_likes));
        posts.add(new Post("https://nourisheveryday.com/wp-content/uploads/2016/04/Healthy-Carrot-Cake-Porridge-N2.jpg", R.string.porridge_title, R.string.porridge_author, R.string.porridge_likes));

    }

}
