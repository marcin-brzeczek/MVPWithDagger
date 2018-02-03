package com.soft.mbr.mvpwithdagger.root.di.activity;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityComponent> {
    ActivityComponentBuilder<M, C> activityModule(M activityModule);
    C build();
}