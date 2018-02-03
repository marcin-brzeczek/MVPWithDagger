package com.soft.mbr.mvpwithdagger.menu;

import android.view.View;

import java.util.List;

import rx.Observable;

/**
 * Created by mbrzeczek on 02.02.2018.
 */

public interface Repository {
    List<ViewModel> getViewModelList();
}
