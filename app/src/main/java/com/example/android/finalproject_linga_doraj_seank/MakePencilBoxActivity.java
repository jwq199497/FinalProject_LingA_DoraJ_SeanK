package com.example.android.finalproject_linga_doraj_seank;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakePencilBoxActivity extends AppCompatActivity {
    private List<Project> projects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_pencil_box);

        Intent i = getIntent();
        initialData();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProjectsAdapter(projects,this));


    }
    private void initialData(){

        projects = new ArrayList<>();
        projects.add(new Project(R.string.counter_top_name,R.string.level_a1, R.string.counter_top_time,R.string.rating_4, R.drawable.countertop));
        projects.add(new Project(R.string.ispring_name, R.string.level_i3, R.string.ispring_time, R.string.rating_5,R.drawable.ispringwaterfilter));
        projects.add(new Project(R.string.smart_bidet_name, R.string.level_i1, R.string.smart_bidet_time,R.string.rating_4, R.drawable.smartbidet));
        projects.add(new Project(R.string.screen_iphone_name, R.string.level_b2, R.string.screen_iphone_time,R.string.rating_5, R.drawable.screeniphone));
        projects.add(new Project(R.string.drying_rack_name, R.string.level_m1, R.string.drying_rack_time,R.string.rating_5, R.drawable.dryingrack));
        projects.add(new Project(R.string.pencil_box_name, R.string.level_b1, R.string.pencil_box_time,R.string.rating_4, R.drawable.pencilbox));
    }

}


