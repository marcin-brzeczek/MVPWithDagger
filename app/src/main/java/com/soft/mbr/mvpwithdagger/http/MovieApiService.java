package com.soft.mbr.mvpwithdagger.http;


import android.support.annotation.IntegerRes;

import com.soft.mbr.mvpwithdagger.http.apimodel.movie.TopRated;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mbrzeczek on 01.02.2018.
 */

public interface MovieApiService {

    @GET("top_rated")
    Observable<TopRated> getTopRatedMovies(@Query("page")Integer page);
}
