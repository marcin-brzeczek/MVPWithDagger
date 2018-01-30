package com.soft.mbr.mvpwithdagger;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public class LoginModel implements LoginActivityMVP.Model {


    private LoginRepository repository;

    public LoginModel(LoginRepository repository)
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
