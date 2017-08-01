package com.example.arad_sheybak.englishlearning.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.arad_sheybak.englishlearning.Adapter.MovieAdapter;
import com.example.arad_sheybak.englishlearning.Iterface.ApiInterface;
import com.example.arad_sheybak.englishlearning.Model.MovieResponse;
import com.example.arad_sheybak.englishlearning.R;
import com.example.arad_sheybak.englishlearning.rest.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Arad_Sheybak on 7/14/2017.
 */

public class Fragment_3 extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayout linearLayout;
    private ArrayList<MovieResponse> movieList;
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    private MovieAdapter movieAdapter;
    private showMoview mShowMoview;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=getActivity();
        try {
          mShowMoview=(Fragment_3.showMoview) activity;
        }
        catch (ClassCastException e){
            e.printStackTrace();
            Log.e("AttachError","ActivityDosnotImplementInterface");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieList=new ArrayList<>();
        retrofit= ApiClient.getClient();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_3
                ,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView_3);
        apiInterface=retrofit.create(ApiInterface.class);

        Call<List<MovieResponse>> call=apiInterface.getMoviesByCatId(3,0,10);
        call.enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
                if (response.isSuccessful()){

                    movieList= (ArrayList<MovieResponse>) response.body();
                    fillAllitemRecyclerView(movieList);

                }
            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {

            }
        });



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void fillAllitemRecyclerView(ArrayList<MovieResponse> movieList){

        movieAdapter=new MovieAdapter(movieList,getContext());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
        movieAdapter.setOnListItemClicked(new MovieAdapter.onItemClickedListener() {
            @Override
            public void itemClicked(String path) {
                mShowMoview.showMoviewByName(path);
            }
        });
    }
    public interface showMoview{
        void showMoviewByName(String name);
    }
}
