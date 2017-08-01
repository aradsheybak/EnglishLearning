package com.example.arad_sheybak.englishlearning.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arad_Sheybak on 7/15/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "http://nikx1.nikmodern.com/android_project/web/";
    public static final String MOVIE_URL= "http://nikx1.nikmodern.com/android_project/web/uploads/movies/";
    //private static   OkHttpClient.Builder ok;
//    private static OkHttpClient client;
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder ok=new OkHttpClient.Builder();
//            HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
//            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            ok.addInterceptor(httpLoggingInterceptor);
            OkHttpClient client=ok.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();


        }
        return retrofit;
    }
}
