package com.soft.mbr.mvpwithdagger.root;

import com.soft.mbr.mvpwithdagger.menu.MenuActivity;
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
        modules = MenuActivityComponent.MenuActivityModule.class
)
public interface MenuActivityComponent extends ActivityComponent<MenuActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MenuActivityModule, MenuActivityComponent> {
    }

    @Module
    class MenuActivityModule extends ActivityModule<MenuActivity> {
        public MenuActivityModule(MenuActivity activity) {
            super(activity);
        }
    }
}
