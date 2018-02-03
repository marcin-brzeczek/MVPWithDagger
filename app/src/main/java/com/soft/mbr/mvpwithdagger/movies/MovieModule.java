package com.soft.mbr.mvpwithdagger.movies;

import com.soft.mbr.mvpwithdagger.http.MovieApiService;
import com.soft.mbr.mvpwithdagger.http.MovieInfoApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mbrzeczek on 02.02.2018.
 */



@Module
public class MovieModule {

    /*presenter*/
    @Provides
    public MoviesActivityMVP.Presenter provideTopMoviesActivityPresenter(MoviesActivityMVP.Model topMoviesModel) {
        return new MoviePresenter(topMoviesModel);
    }

    /*model*/
    @Provides
    public MoviesActivityMVP.Model provideTopMoviesActivityModel(Repository repository) {
        return new MoviesModel(repository);
    }

    /*repository*/
    @Singleton
    @Provides
    public Repository provideRepo(MovieApiService movieApiService, MovieInfoApiService moreInfoApiService) {
        return new MoviesRepository(movieApiService, moreInfoApiService);
    }


}