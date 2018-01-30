package com.soft.mbr.mvpwithdagger;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public interface LoginRepository {
    User getUser();

    void saveUser(User user);

}
