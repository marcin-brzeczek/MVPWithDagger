package com.soft.mbr.mvpwithdagger.menu;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.soft.mbr.mvpwithdagger.R;
import com.soft.mbr.mvpwithdagger.root.BaseActivity;
import com.soft.mbr.mvpwithdagger.root.MenuActivityComponent;
import com.soft.mbr.mvpwithdagger.root.di.activity.HasActivitySubcomponentBuilders;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class MenuActivity extends BaseActivity implements  MenuActivityMVP.View {


    @Inject
    MenuActivityMVP.Presenter presenter;

    @BindView(R.id.menuView)
    ViewGroup viewGroup;

    @BindView(R.id.coverflow)
    FeatureCoverFlow coverFlow;

    MenuItemAdapter menuItemAdapter;
    private List<ViewModel> resultList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders)
    {
        ((MenuActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(MenuActivity.class))
                .activityModule(new MenuActivityComponent.MenuActivityModule(this))
                .build()
                .injectMembers(this);
    }

    @Override
    public void updateData(List<ViewModel> viewModel)
    {
            resultList.addAll(viewModel);
        menuItemAdapter = new MenuItemAdapter( this , (ArrayList<ViewModel>) resultList);
        coverFlow.setAdapter(menuItemAdapter);
    }

}
