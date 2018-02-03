package com.soft.mbr.mvpwithdagger.movies;


import rx.Observable;

/**
 * Created by mbrzeczek on 01.02.2018.
 */

public interface MoviesActivityMVP {

    interface View{
        void updateData(ViewModel viewModel);
        void showSnackbar(String s);

    }


    interface Presenter{

        void  loadData();
        void rxUnsubscribe();
        void setView(MoviesActivityMVP.View view);
    }

    interface Model{
        Observable<ViewModel> result();

    }
}
