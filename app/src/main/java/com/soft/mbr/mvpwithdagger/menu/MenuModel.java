package com.soft.mbr.mvpwithdagger.menu;


import java.util.List;

/**
 * Created by mbrzeczek on 02.02.2018.
 */

public class MenuModel implements MenuActivityMVP.Model {

    Repository repository;

    public MenuModel(Repository repository)
    {
        this.repository = repository;
    }


    @Override
    public List<ViewModel> result()
    {
        return repository.getViewModelList();
    }
}
