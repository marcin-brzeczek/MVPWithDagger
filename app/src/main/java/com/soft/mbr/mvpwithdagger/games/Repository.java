package com.soft.mbr.mvpwithdagger.games;

import java.util.List;

import rx.Observable;

/**
 * Created by mbrzeczek on 02.02.2018.
 */

public interface Repository {


    Observable<String> getTitlesGames();
    Observable<String> getImages();
}
