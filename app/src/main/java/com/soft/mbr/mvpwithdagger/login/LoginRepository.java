package com.soft.mbr.mvpwithdagger.login;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public class LoginRepository implements Repository {

    private User user;

    @Override
    public User getUser()
    {

        if (user == null) {
            User user = new User("Joe", "Netguru");
            user.setId(0);
            return user;
        }
        return user;
    }

    @Override
    public void saveUser(User user)
    {
        if (user == null) {
            user = getUser();
        }
        this.user = user;
    }
}
