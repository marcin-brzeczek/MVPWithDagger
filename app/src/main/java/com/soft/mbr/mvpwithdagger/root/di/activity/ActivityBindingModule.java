package com.soft.mbr.mvpwithdagger.root.di.activity;


import com.soft.mbr.mvpwithdagger.games.GameListActivity;
import com.soft.mbr.mvpwithdagger.login.LoginActivity;
import com.soft.mbr.mvpwithdagger.menu.MenuActivity;
import com.soft.mbr.mvpwithdagger.movies.MovieListActivity;
import com.soft.mbr.mvpwithdagger.root.GameListActivityComponent;
import com.soft.mbr.mvpwithdagger.root.LoginActivityComponent;
import com.soft.mbr.mvpwithdagger.root.MenuActivityComponent;
import com.soft.mbr.mvpwithdagger.root.MovieListActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

@Module(
        subcomponents = {
                LoginActivityComponent.class,
                GameListActivityComponent.class,
                MovieListActivityComponent.class,
                MenuActivityComponent.class
        })
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity.class)
    public abstract ActivityComponentBuilder loginActivityComponentBuilder(LoginActivityComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(GameListActivity.class)
    public abstract ActivityComponentBuilder gamelistActivityComponentBuilder(GameListActivityComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(MovieListActivity.class)
    public abstract ActivityComponentBuilder movielistActivityComponentBuilder(MovieListActivityComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(MenuActivity.class)
    public abstract ActivityComponentBuilder menuActivityComponentBuilder(MenuActivityComponent.Builder impl);

}