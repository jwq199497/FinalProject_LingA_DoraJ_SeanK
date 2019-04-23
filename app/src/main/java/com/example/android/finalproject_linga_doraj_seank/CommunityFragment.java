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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommunityFragment extends Fragment {

    private static final String TAG = "CommunityFragment";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Post> posts = new ArrayList<>();
    private FloatingActionButton composeButton;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mPostDatabaseReference;
    private ChildEventListener mChildEventListener;

    private String author;
    private String title;
    private String photoUrl;
    private String likes;
    private Post newPost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_community, container, false);

        composeButton = (FloatingActionButton) rootView.findViewById(R.id.fab_posting);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mPostDatabaseReference = mFirebaseDatabase.getReference("Posts/Ld7cQmJ3djQ8EFlLAR4");
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                newPost = dataSnapshot.getValue(Post.class);
                photoUrl = newPost.getPhotoUrl();
                author = newPost.getAuthor();
                title = newPost.getTitle();
                likes = newPost.getLiked();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mPostDatabaseReference.addChildEventListener(mChildEventListener);

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

        posts.add(new Post(photoUrl, title, author, likes));
        posts.add(new Post("https://www.familyhandyman.com/wp-content/uploads/2017/05/FH16JUN_PAINTS_11.jpg", "11 Little Known Painting Hacks from Expert Field Editors", "👤FamilyHandymen", "♡ 5.5K"));
        posts.add(new Post("https://www.familyhandyman.com/wp-content/uploads/2019/04/shutterstock_561902914-1200x675.jpg","7 Genius Organization Tips to Transform Your Refrigerator", "👤JacquelineWeiss", "♡ 1.9K"));
        posts.add(new Post("https://www.bybrittanygoldwyn.com/wp-content/uploads/2016/12/Cat-Tree-5-March-13.jpg", "50 bucks Makes a Cute Cat Tree", "👤一条鲫鱼呀", "♡ 850"));
        posts.add(new Post("https://nourisheveryday.com/wp-content/uploads/2016/04/Healthy-Carrot-Cake-Porridge-N2.jpg", "Healthy Carrot Cake Porridge", "👤MoniqueTheNutritionist", "♡ 99"));

    }

}
