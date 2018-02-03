package com.soft.mbr.mvpwithdagger.root;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityComponentBuilder;
import com.soft.mbr.mvpwithdagger.root.di.activity.HasActivitySubcomponentBuilders;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;


/**
 * Created by mbrzeczek on 29.01.2018.
 */


public class App extends Application implements HasActivitySubcomponentBuilders {

    @Inject
    Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> activityComponentBuilders;

    private AppComponent appComponent;

    public static HasActivitySubcomponentBuilders get(Context context) {
        return ((HasActivitySubcomponentBuilders) context.getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
        appComponent.inject(this);
    }

    @Override
    public ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass) {
        return activityComponentBuilders.get(activityClass).get();
    }



}
