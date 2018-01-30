package com.soft.mbr.mvpwithdagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
interface  ApplicationComponent {

    void inject(LoginActivity target);
}
