package com.soft.mbr.mvpwithdagger.games;

/**
 * Created by mbrzeczek on 03.02.2018.
 */

public class ViewModel {

    private String titleGame;
    private String imgGame;

    public ViewModel(String titleGame, String imgGame)
    {
        this.titleGame = titleGame;
        this.imgGame = imgGame;
    }


    public String getTitleGame()
    {
        return titleGame;
    }


    public String getImgGame()
    {
        return imgGame;
    }



}
