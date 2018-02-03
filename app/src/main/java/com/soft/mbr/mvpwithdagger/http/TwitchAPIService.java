package com.soft.mbr.mvpwithdagger.http;

import com.soft.mbr.mvpwithdagger.http.apimodel.game.Twitch;


import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by mbrzeczek on 31.01.2018.
 */

public interface TwitchAPIService {

    @GET("games/top")
    Call<Twitch> getTopGames();

    @GET("games/top")
    Observable<Twitch> getTopGamesObservable();
}
