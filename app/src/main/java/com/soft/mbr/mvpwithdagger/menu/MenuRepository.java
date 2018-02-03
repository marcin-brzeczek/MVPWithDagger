package com.soft.mbr.mvpwithdagger.menu;


import com.soft.mbr.mvpwithdagger.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbrzeczek on 02.02.2018.
 */

public class MenuRepository implements Repository {

    private List<ViewModel> viewModelList;
    String[] titles = new String[]{"Games", "Movies","Test1", "Test2"};
    int[] images =  new int[]{R.drawable.games,R.drawable.movies,R.drawable.noactive1,R.drawable.noactive2};


    public MenuRepository()
    {
        viewModelList = new ArrayList<>();

        for(int i=0;i < titles.length ; i++)
        viewModelList.add(new ViewModel(titles[i], images[i]));

    }


    @Override
    public List<ViewModel> getViewModelList()
    {
        return viewModelList;
    }
}

