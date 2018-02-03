package com.soft.mbr.mvpwithdagger.root.di.activity;

import android.app.Activity;

import dagger.MembersInjector;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public interface ActivityComponent<A extends Activity> extends MembersInjector<A> {
}

