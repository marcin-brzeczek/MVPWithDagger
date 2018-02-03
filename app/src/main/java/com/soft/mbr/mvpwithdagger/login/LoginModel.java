package com.soft.mbr.mvpwithdagger.login;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public class LoginModel implements LoginActivityMVP.Model {


    private Repository repository;

    public LoginModel(Repository repository)
    {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName)
    {
        repository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser()
    {
        return repository.getUser();
    }
}
