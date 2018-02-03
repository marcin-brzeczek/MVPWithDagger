package com.soft.mbr.mvpwithdagger.movies;


import com.soft.mbr.mvpwithdagger.http.apimodel.movie.Result;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by mbrzeczek on 01.02.2018.
 */

public class MoviesModel implements  MoviesActivityMVP.Model {

    private Repository repository;

    public MoviesModel(Repository repository)
    {
        this.repository = repository;
    }


    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(
                repository.getResultData(),
                repository.getCountryData(),
                new Func2<Result, String, ViewModel>() {
                    @Override
                    public ViewModel call(Result result, String s) {
                        return new ViewModel(result.title, s);
                    }
                }
        );
    }
}
