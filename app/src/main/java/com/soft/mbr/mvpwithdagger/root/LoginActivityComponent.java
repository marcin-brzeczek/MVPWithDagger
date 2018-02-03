package com.soft.mbr.mvpwithdagger.root;

import com.soft.mbr.mvpwithdagger.login.LoginActivity;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityComponent;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityComponentBuilder;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityModule;
import com.soft.mbr.mvpwithdagger.root.di.activity.ActivityScope;

import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

@ActivityScope
@Subcomponent(
        modules = LoginActivityComponent.LoginActivityModule.class
)
public interface LoginActivityComponent extends ActivityComponent<LoginActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<LoginActivityModule, LoginActivityComponent> {
    }

    @Module
    class LoginActivityModule extends ActivityModule<LoginActivity> {
        public LoginActivityModule(LoginActivity activity) {
            super(activity);
        }
    }
}