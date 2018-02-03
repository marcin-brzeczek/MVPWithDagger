package com.soft.mbr.mvpwithdagger.root;

import com.soft.mbr.mvpwithdagger.games.GameModule;
import com.soft.mbr.mvpwithdagger.http.ApiModuleForMovieInfo;
import com.soft.mbr.mvpwithdagger.http.ApiModuleTwitch;
import com.soft.mbr.mvpwithdagger.http.ApiModuleForMovieName;
import com.soft.mbr.mvpwithdagger.login.LoginModule;
import com.soft.mbr.mvpwithdagger.menu.MenuModule;
import com.soft.mbr.mvpwithdagger.movies.MovieModule;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityBindingModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mbrzeczek on 29.01.2018.
 */


@Singleton
@Component(
        modules = {
                LoginModule.class, ApiModuleTwitch.class, ApiModuleForMovieName.class, ApiModuleForMovieInfo.class, MovieModule.class, GameModule.class, MenuModule.class,
                ActivityBindingModule.class
        }
)
public interface AppComponent {
    App inject(App application);
}