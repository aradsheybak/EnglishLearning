package com.example.arad_sheybak.englishlearning.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.arad_sheybak.englishlearning.Model.MovieResponse;
import com.example.arad_sheybak.englishlearning.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.arad_sheybak.englishlearning.R.id.img_video;
import static com.example.arad_sheybak.englishlearning.rest.ApiClient.MOVIE_URL;

/**
 * Created by Arad_Sheybak on 7/15/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieResponse> list;
    private Context context;
    private LinearLayout linearLayout;
    private String isSeen;
    private onItemClickedListener mIemClickedListener;


    public MovieAdapter(ArrayList<MovieResponse> list, Context context) {
        this.list = list;
        this.context = context;
        this.isSeen=isSeen;
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        MovieViewHolder myHolder = new MovieViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        MovieResponse movie = list.get(position);
        holder.name.setText(movie.getName());
        Log.e("productName", movie.getName() + "");
        holder.descript.setText(movie.getDescript());
        Log.e("Descript", movie.getDescript() + "");
        Glide.with(context).load(MOVIE_URL+movie.getPic()).into(holder.image);
        if (movie.isSeen()){
            holder.name.setTypeface(null, Typeface.NORMAL);
            holder.descript.setTypeface(null, Typeface.NORMAL);
        }
        else {
            holder.name.setTypeface(null,Typeface.BOLD);
            holder.descript.setTypeface(null,Typeface.BOLD);
        }
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout linearLayout;
        ImageView image;
        TextView name;
        TextView descript;
        boolean isSeen;


        public MovieViewHolder(View itemView){
            super(itemView);
            image = (ImageView) itemView.findViewById(img_video);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.txt_name_of_file);
            descript = (TextView) itemView.findViewById(R.id.txt_descript_of_file);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.item_lineralayout);

        }

        @Override
        public void onClick(View view) {
            try {
                Log.e("view","clicked");
                Log.e("list",list.get(getAdapterPosition()).getFile()+"");
                mIemClickedListener.itemClicked(list.get(getAdapterPosition()).getFile()+"");
            }catch (Exception e){
                Log.e("c2323","" + e.getMessage()+"");
            }
        }
    }


    public interface onItemClickedListener {

        public void itemClicked(String path);

    }

    public void setOnListItemClicked(onItemClickedListener onListItemClicked){

        this.mIemClickedListener=onListItemClicked;
    }


}
