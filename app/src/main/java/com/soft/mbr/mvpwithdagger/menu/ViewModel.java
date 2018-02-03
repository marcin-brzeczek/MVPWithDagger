package com.soft.mbr.mvpwithdagger.menu;

/**
 * Created by mbrzeczek on 03.02.2018.
 */

public class ViewModel {

    private String title;
    private int img;

    public ViewModel(String title, int img)
    {
        this.title = title;
        this.img = img;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getImg()
    {
        return img;
    }

    public void setImg(int img)
    {
        this.img = img;
    }





}
