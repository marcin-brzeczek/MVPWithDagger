package com.soft.mbr.mvpwithdagger.movies;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;

import com.soft.mbr.mvpwithdagger.R;
import com.soft.mbr.mvpwithdagger.root.BaseActivity;
import com.soft.mbr.mvpwithdagger.root.MovieListActivityComponent;
import com.soft.mbr.mvpwithdagger.root.di.activity.HasActivitySubcomponentBuilders;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieListActivity extends BaseActivity  implements  MoviesActivityMVP.View{

    @Inject
    MoviesActivityMVP.Presenter presenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.listRootView)
    ViewGroup rootView;

    private MovieListAdapter listAdapter;
    private List<ViewModel> resultList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
        listAdapter =  new MovieListAdapter(resultList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders)
    {
        ((MovieListActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(MovieListActivity.class))
                .activityModule(new MovieListActivityComponent.MovieListActivityModule(this))
                .build()
                .injectMembers(this);
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
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        listAdapter.notifyItemInserted(resultList.size() - 1);
    }

    @Override
    public void showSnackbar(String s)
    {
        Snackbar.make(rootView, s, Snackbar.LENGTH_LONG).show();
    }
}
