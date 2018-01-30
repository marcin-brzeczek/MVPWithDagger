package com.soft.mbr.mvpwithdagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mbrzeczek on 29.01.2018.
 */
@Module
public class ApplicationModule {

    private Application application;
    public ApplicationModule(Application application)
    {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return  application;
    }


}
