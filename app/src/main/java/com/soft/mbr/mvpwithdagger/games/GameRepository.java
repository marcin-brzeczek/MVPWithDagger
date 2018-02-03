package com.soft.mbr.mvpwithdagger.games;


import android.os.AsyncTask;

import com.soft.mbr.mvpwithdagger.http.TwitchAPIService;
import com.soft.mbr.mvpwithdagger.http.apimodel.game.Top;
import com.soft.mbr.mvpwithdagger.http.apimodel.game.Twitch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by mbrzeczek on 02.02.2018.
 */

public class GameRepository implements Repository {

    private TwitchAPIService twitchAPIService;
    private List<String> titleGames;
    private List<String> imagesGames;




    public GameRepository(TwitchAPIService twitchAPIService)
    {
        this.twitchAPIService = twitchAPIService;
        titleGames = new ArrayList<>();
        imagesGames = new ArrayList<>();
    }


    @Override
    public Observable<String> getTitlesGames()
    {
        return twitchAPIService.getTopGamesObservable().concatMap(new Func1<Twitch, Observable<Top>>() {
            @Override
            public Observable<Top> call(Twitch twitch)
            {
                return Observable.from(twitch.getTop());
            }
        }).concatMap(new Func1<Top, Observable<String>>() {
            @Override
            public Observable<String> call(Top top)
            {
                return Observable.just(top.getGame().getName());
            }
        }).doOnNext(new Action1<String>() {
            @Override
            public void call(String s)
            {
                titleGames.add(s);
            }
        });
    }

    @Override
    public Observable<String> getImages()
    {
        return twitchAPIService.getTopGamesObservable().concatMap(new Func1<Twitch, Observable<Top>>() {
            @Override
            public Observable<Top> call(Twitch twitch)
            {
                return Observable.from(twitch.getTop());
            }
        }).concatMap(new Func1<Top, Observable<String>>() {
            @Override
            public Observable<String> call(Top top)
            {
                return Observable.just(top.getGame().getBox().getMedium());
            }
        }).doOnNext(new Action1<String>() {
            @Override
            public void call(String s)
            {
                imagesGames.add(s);
            }
        });
    }
}
