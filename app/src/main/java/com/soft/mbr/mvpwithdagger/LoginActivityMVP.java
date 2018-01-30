package com.soft.mbr.mvpwithdagger;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public interface LoginActivityMVP {

    interface  View{

        String getFirstName();
        String getLastName();

        void showUserNotAvailable();
        void showError();

        void  showUserSavedMessage();
        void setFirstName(String firstName);
        void setLastName(String lastName);

    }

    interface Presenter {

        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }

    interface  Model{

        void createUser(String firstName, String lastName);
        User getUser();
    }
}
