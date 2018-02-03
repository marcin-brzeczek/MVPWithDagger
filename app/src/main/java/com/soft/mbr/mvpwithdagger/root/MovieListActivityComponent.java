package com.soft.mbr.mvpwithdagger.root;

import com.soft.mbr.mvpwithdagger.movies.MovieListActivity;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityComponent;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityComponentBuilder;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityModule;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityScope;

import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

@ActivityScope
@Subcomponent(
        modules = MovieListActivityComponent.MovieListActivityModule.class
)
public interface MovieListActivityComponent extends ActivityComponent<MovieListActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MovieListActivityModule, MovieListActivityComponent> {
    }

    @Module
    class MovieListActivityModule extends ActivityModule<MovieListActivity> {
        public MovieListActivityModule(MovieListActivity activity) {
            super(activity);
        }
    }
}
