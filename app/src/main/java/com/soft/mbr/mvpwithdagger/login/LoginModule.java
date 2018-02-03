package com.soft.mbr.mvpwithdagger.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return  new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(Repository repository){
        return  new LoginModel(repository);
    }

    @Provides
    public Repository provideLoginRepository(){
        return new LoginRepository();
    }
}
