package com.soft.mbr.mvpwithdagger;

import android.app.Application;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();
    component =  DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .loginModule(new LoginModule()).build();

    }

public ApplicationComponent  getComponent(){
        return  component;
}
}
