package com.soft.mbr.mvpwithdagger.games;


import com.soft.mbr.mvpwithdagger.http.TwitchAPIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mbrzeczek on 02.02.2018.
 */



@Module
public class GameModule {

    /*presenter*/
    @Provides
    public GameActivityMVP.Presenter provideGameActivityPresenter(GameActivityMVP.Model gameModel) {
        return new GamePresenter(gameModel);
    }

    /*model*/
    @Provides
    public GameActivityMVP.Model provideGameActivityModel(Repository repository) {
        return new GameModel(repository);
    }

    /*repository*/
    @Singleton
    @Provides
    public Repository provideRepo(TwitchAPIService twichApiService) {
        return new GameRepository(twichApiService);
    }


}