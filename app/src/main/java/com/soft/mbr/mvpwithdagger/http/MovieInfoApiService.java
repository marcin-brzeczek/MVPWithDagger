package com.soft.mbr.mvpwithdagger.http;

import com.soft.mbr.mvpwithdagger.http.apimodel.movie.OmdbApi;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mbrzeczek on 02.02.2018.
 */

public interface MovieInfoApiService {

    @GET("/")
    Observable<OmdbApi> getCountry(@Query("t") String title);
}
