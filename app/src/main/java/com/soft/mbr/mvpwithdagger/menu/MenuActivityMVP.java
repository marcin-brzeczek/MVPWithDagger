package com.soft.mbr.mvpwithdagger.menu;



import java.util.List;


/**
 * Created by mbrzeczek on 01.02.2018.
 */

public interface MenuActivityMVP {

    interface View{
        void updateData(List<ViewModel> viewModel);

    }


    interface Presenter{

        void  loadData();
        void setView(MenuActivityMVP.View view);
    }

    interface Model{
        List<ViewModel> result();
    }
}
