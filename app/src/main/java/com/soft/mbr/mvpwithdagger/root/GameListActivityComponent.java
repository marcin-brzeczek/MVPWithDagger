package com.soft.mbr.mvpwithdagger.root;

import com.soft.mbr.mvpwithdagger.games.GameListActivity;
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
        modules = GameListActivityComponent.GameListActivityModule.class
)
public interface GameListActivityComponent extends ActivityComponent<GameListActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<GameListActivityModule, GameListActivityComponent> {
    }

    @Module
    class GameListActivityModule extends ActivityModule<GameListActivity> {
        public GameListActivityModule(GameListActivity activity) {
            super(activity);
        }
    }
}
