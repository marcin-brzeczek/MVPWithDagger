package com.soft.mbr.mvpwithdagger.login;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public interface Repository {
    User getUser();

    void saveUser(User user);

}
