package com.example.facebook.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebook.data.PostsClient;
import com.example.facebook.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";
    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();

    public void getPosts(){
        PostsClient.getInstance().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.d(TAG, "mokh onFailure: " + t.getMessage());
            }
        });
    } // end getPosts()
} // end class
