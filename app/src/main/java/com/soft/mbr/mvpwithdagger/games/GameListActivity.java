package com.soft.mbr.mvpwithdagger.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.soft.mbr.mvpwithdagger.R;
import com.soft.mbr.mvpwithdagger.http.TwitchAPIService;
import com.soft.mbr.mvpwithdagger.http.apimodel.game.Game;
import com.soft.mbr.mvpwithdagger.http.apimodel.game.Top;
import com.soft.mbr.mvpwithdagger.http.apimodel.game.Twitch;
import com.soft.mbr.mvpwithdagger.movies.MovieListActivity;
import com.soft.mbr.mvpwithdagger.root.BaseActivity;
import com.soft.mbr.mvpwithdagger.root.GameListActivityComponent;
import com.soft.mbr.mvpwithdagger.root.di.activity.HasActivitySubcomponentBuilders;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class GameListActivity extends BaseActivity implements  GameActivityMVP.View {

    @Inject
    GameActivityMVP.Presenter presenter;

    @Inject
    TwitchAPIService twitchAPI;

    @BindView(R.id.gridView)
    GridView gridView;

    @BindView(R.id.listRootView)
    ViewGroup rootView;

    private GameListAdapter listAdapter;
    private List<ViewModel> resultList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
        listAdapter = new GameListAdapter(this, R.layout.grid_adapter_row, resultList);
        gridView.setAdapter(listAdapter);

        testRx();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }



    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders)
    {
        ((GameListActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(GameListActivity.class))
                .activityModule(new GameListActivityComponent.GameListActivityModule(this))
                .build()
                .injectMembers(this);
    }

    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSnackbar(String s)
    {
        Snackbar.make(rootView, s, Snackbar.LENGTH_LONG).show();
    }


    /*testing rx filter and flatmap*/
    private void testRx()
    {

        /*testing */
        twitchAPI.getTopGamesObservable()
                .flatMap(new Func1<Twitch, Observable<Top>>() {
                    @Override
                    public Observable<Top> call(Twitch twitch)
                    {
                        return Observable.from(twitch.getTop());
                    }
                }).flatMap(new Func1<Top, Observable<String>>() {
            @Override
            public Observable<String> call(Top top)
            {
                return Observable.just(top.getGame().getName());
            }
        })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s)
                    {
                        return s.startsWith("H");
                    }
                })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {

            @Override
            public void onCompleted()
            {

            }

            @Override
            public void onError(Throwable e)
            {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s)
            {
                System.out.println("From rx java with filter: " + s);

            }
        });

        twitchAPI.getTopGamesObservable()
                .flatMap(new Func1<Twitch, Observable<Top>>() {
                    @Override
                    public Observable<Top> call(Twitch twitch)
                    {
                        return Observable.from(twitch.getTop());
                    }
                }).flatMap(new Func1<Top, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Top top)
            {
                return Observable.just(top.getGame().getPopularity());
            }
        })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {

            @Override
            public void onCompleted()
            {

            }

            @Override
            public void onError(Throwable e)
            {
                e.printStackTrace();
            }

            @Override
            public void onNext(Integer i)
            {
                System.out.println("From rx java: Popularity is " + i.toString());

            }
        });
    }
}