package com.soft.mbr.mvpwithdagger.games;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by mbrzeczek on 02.02.2018.
 */

public class GameModel implements GameActivityMVP.Model {

    Repository repository;

    public GameModel(Repository repository)
    {
        this.repository = repository;
    }


    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(
                repository.getTitlesGames(),
                repository.getImages(),
                new Func2<String, String, ViewModel>() {
                    @Override
                    public ViewModel call(String titleGame, String imgGame) {
                        return new ViewModel(titleGame, imgGame);
                    }
                }
        );
    }
}
