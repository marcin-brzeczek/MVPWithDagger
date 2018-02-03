package com.soft.mbr.mvpwithdagger.games;


import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mbrzeczek on 01.02.2018.
 */

public class GamePresenter implements GameActivityMVP.Presenter {

    private GameActivityMVP.View view;
    private GameActivityMVP.Model model;
    private Subscription subscription;

    public GamePresenter(GameActivityMVP.Model model)
    {
        this.model = model;
    }


    @Override
    public void rxUnsubscribe()
    {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }

    }
    @Override
    public void loadData()
    {
        subscription = model
                .result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ViewModel>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {
                            view.showSnackbar("Error getting games. Check the internet connection.");
                        }
                    }

                    @Override
                    public void onNext(ViewModel viewModel) {
                        if (view != null) {
                            view.updateData(viewModel);
                        }
                    }
                });
    }

    @Override
    public void setView(GameActivityMVP.View view)
    {
        this.view = view;
    }


}
