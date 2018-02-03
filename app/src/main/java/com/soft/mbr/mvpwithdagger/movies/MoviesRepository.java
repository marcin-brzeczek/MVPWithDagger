package com.soft.mbr.mvpwithdagger.movies;


import com.soft.mbr.mvpwithdagger.http.MovieApiService;
import com.soft.mbr.mvpwithdagger.http.MovieInfoApiService;
import com.soft.mbr.mvpwithdagger.http.apimodel.movie.OmdbApi;
import com.soft.mbr.mvpwithdagger.http.apimodel.movie.Result;
import com.soft.mbr.mvpwithdagger.http.apimodel.movie.TopRated;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by mbrzeczek on 01.02.2018.
 */

public class MoviesRepository implements Repository {

    private MovieApiService movieApiService;
    private MovieInfoApiService moreInfoApiService;
    private List<String> countries;
    private List<Result> results;
    private long timestamp;

    private static long STALE_MS = 20 * 1000; // data is stale after 20 sec


    public MoviesRepository(MovieApiService movieApiService, MovieInfoApiService moreInfoApiService)
    {
        this.movieApiService = movieApiService;
        this.moreInfoApiService = moreInfoApiService;
        this.timestamp = System.currentTimeMillis();
        countries = new ArrayList<String>();
        results = new ArrayList<Result>();
    }


    public boolean isUpToDate()
    {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<Result> getResultsFromMemory()
    {

        if (isUpToDate()) {
            return Observable.from(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultsFromNetwork()
    {
           /*1, 2, 3 because I concat 3 pages of results*/
        Observable<TopRated> topRatedObservable = movieApiService.getTopRatedMovies(1).concatWith(movieApiService.getTopRatedMovies(2)).concatWith(movieApiService.getTopRatedMovies(3));

        return topRatedObservable.concatMap(new Func1<TopRated, Observable<Result>>() {
            @Override
            public Observable<Result> call(TopRated topRated)
            {
                return Observable.from(topRated.results);
            }
        }).doOnNext(new Action1<Result>() {
            @Override
            public void call(Result result)
            {
                results.add(result);
            }
        });
    }

    @Override
    public Observable<String> getCountriesFromMemory()
    {

        if (isUpToDate()) {
            return Observable.from(countries);
        } else {
            timestamp = System.currentTimeMillis();
            countries.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<String> getCountriesFromNetwork()
    {
        return getResultsFromNetwork().concatMap(new Func1<Result, Observable<OmdbApi>>() {
            @Override
            public Observable<OmdbApi> call(Result result)
            {
                return moreInfoApiService.getCountry(result.title);
            }
        }).concatMap(new Func1<OmdbApi, Observable<String>>() {
            @Override
            public Observable<String> call(OmdbApi omdbApi)
            {
                return Observable.just(omdbApi.getCountry());
            }
        }).doOnNext(new Action1<String>() {
            @Override
            public void call(String s)
            {
                countries.add(s);
            }
        });
    }

    @Override
    public Observable<String> getCountryData()
    {
        return getCountriesFromMemory().switchIfEmpty(getCountriesFromNetwork());
    }

    @Override
    public Observable<Result> getResultData()
    {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());

    }
}