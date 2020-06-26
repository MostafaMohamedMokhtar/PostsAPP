package com.example.facebook.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.facebook.R;
import com.example.facebook.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel ;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
            postViewModel.getPosts();

            RecyclerView recyclerView = findViewById(R.id.recyclerView_id);
            final PostsAdapter adapter = new PostsAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
            postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
                @Override
                public void onChanged(List<PostModel> postModels) {
                    adapter.setList(postModels);
                }
            });

        }
        catch (Exception e){
            Log.d(TAG, "mokh onCreate:" + e.getMessage() );
        }

    } // end onCreate()
} // end class
