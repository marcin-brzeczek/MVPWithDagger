package com.soft.mbr.mvpwithdagger.movies;


import com.soft.mbr.mvpwithdagger.http.apimodel.movie.Result;

import rx.Observable;


/**
 * Created by mbrzeczek on 01.02.2018.
 */

public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();
}
