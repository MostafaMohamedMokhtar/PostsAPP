package com.example.facebook.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.R;
import com.example.facebook.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.postViewHolde> {
    private List<PostModel> postsList = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public postViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_row, parent, false);
        return new postViewHolde(view);
    } // end onCreateViewHolder()

    @Override
    public void onBindViewHolder(@NonNull postViewHolde holder, int position) {
        holder.titleTV.setText(postsList.get(position).getTitle());
        holder.userTV.setText(postsList.get(position).getUserId()+"");
        holder.bodyTV.setText(postsList.get(position).getBody());

    } // end onBindViewHolder()

    @Override
    public int getItemCount() {
        return postsList.size();
    } // end getItemCount()

    public void setList(List<PostModel> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();
    } // end setPostsList()

    public class postViewHolde extends RecyclerView.ViewHolder {
        TextView titleTV , userTV , bodyTV ;

        public postViewHolde(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV_id);
            userTV = itemView.findViewById(R.id.userID);
            bodyTV = itemView.findViewById(R.id.bodyTV_id);

        } // end constructor

    } // end inner class postViewHolde(class)
} // end outer class
