package com.soft.mbr.mvpwithdagger.games;



import rx.Observable;

/**
 * Created by mbrzeczek on 01.02.2018.
 */

public interface GameActivityMVP {

    interface View{
        void updateData(ViewModel viewModel);
        void showSnackbar(String s);

    }


    interface Presenter{

        void  loadData();
        void rxUnsubscribe();
        void setView(GameActivityMVP.View view);
    }

    interface Model{
        Observable<ViewModel> result();
    }
}
