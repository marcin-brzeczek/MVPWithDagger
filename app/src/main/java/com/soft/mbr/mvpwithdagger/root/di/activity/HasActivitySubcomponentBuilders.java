package com.soft.mbr.mvpwithdagger.root.di.activity;

import android.app.Activity;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public interface HasActivitySubcomponentBuilders {
    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass);
}