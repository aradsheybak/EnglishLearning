package com.example.arad_sheybak.englishlearning.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.arad_sheybak.englishlearning.R;
import com.example.arad_sheybak.englishlearning.rest.ApiClient;

/**
 * Created by Arad_Sheybak on 7/15/2017.
 */

public class PlayingVideo extends Fragment {
    private VideoView video;
    LinearLayout linearLayout;
    private String moviewName;

    public static PlayingVideo newInstance(String path){
      Bundle bundle=new Bundle();
        bundle.putString("Path",path);
        PlayingVideo playingVideo=new PlayingVideo();
        playingVideo.setArguments(bundle);

        return playingVideo;


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        moviewName=bundle.getString("Path","");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.playingvideo,container,false);
        video=view.findViewById(R.id.video_view);
        MediaController mediaController=new MediaController(getActivity());
        Uri uri=Uri.parse(ApiClient.MOVIE_URL+moviewName);
        video.setMediaController(mediaController);
        video.setVideoURI(uri);
        video.start();

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
}

