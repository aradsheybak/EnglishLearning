package com.example.arad_sheybak.englishlearning.Iterface;

import com.example.arad_sheybak.englishlearning.Model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Arad_Sheybak on 7/15/2017.
 */

public interface ApiInterface {
    @GET("api/movie/")
    Call<MovieResponse> getMovieById(@Path("movieId") int movieId);

    @GET("api/category/{catId}/movies")
    Call<List<MovieResponse>>getMoviesByCatId(@Path("catId") int catId,@Query("offset") int offset,@Query("limit") int limit);

    @GET("api/movies")
    Call<List<MovieResponse>>getMoviesById(@Query("movieId") int id,@Query("offset")int offset,@Query("limit")int limit);

    @PUT("api/movie/{movieId}/seen/{seen}")
    Call<MovieResponse>setSeen(@Path("isSeen") boolean isSeen);
}
