package com.soft.mbr.mvpwithdagger.root.di.activity;

import android.app.Activity;

import dagger.MapKey;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

@MapKey
public @interface ActivityKey {
    Class<? extends Activity> value();
}
