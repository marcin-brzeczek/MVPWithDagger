package com.soft.mbr.mvpwithdagger.menu;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mbrzeczek on 02.02.2018.
 */



@Module
public class MenuModule {

    /*presenter*/
    @Provides
    public MenuActivityMVP.Presenter provideMenuActivityPresenter(MenuActivityMVP.Model model) {
        return new MenuPresenter(model);
    }

    /*model*/
    @Provides
    public MenuActivityMVP.Model provideMenuActivityModel(Repository repository) {
        return new MenuModel(repository);
    }

    /*repository*/
    @Singleton
    @Provides
    public Repository provideRepoMenu() {
        return new MenuRepository();
    }


}