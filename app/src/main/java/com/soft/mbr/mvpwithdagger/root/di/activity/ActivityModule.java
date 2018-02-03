package com.soft.mbr.mvpwithdagger.root.di.activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mbrzeczek on 29.01.2018.
 */


@Module
public abstract class ActivityModule<T> {
    protected final T activity;

    public ActivityModule(T activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public T provideActivity() {
        return activity;
    }
}
