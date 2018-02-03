package com.soft.mbr.mvpwithdagger.menu;




/**
 * Created by mbrzeczek on 01.02.2018.
 */

public class MenuPresenter implements MenuActivityMVP.Presenter {

    private MenuActivityMVP.View view;
    private MenuActivityMVP.Model model;



    public MenuPresenter(MenuActivityMVP.Model model)
    {
        this.model = model;
    }


    @Override
    public void loadData()
    {
       if(view!=null){

           view.updateData(model.result());

       }
    }

    @Override
    public void setView(MenuActivityMVP.View view)
    {
        this.view = view;
    }


}
