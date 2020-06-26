package com.example.facebook.data;

import com.example.facebook.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/" ;
    private static  PostsClient instance ;
    private PostInterface postInterface ;
    public PostsClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    } // end constructor

    public static PostsClient getInstance() {
        if(null == instance ) {
            instance = new PostsClient();
        }
        return instance;
    } // end getInstance()

    public Call<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }
} // end class
