package com.soft.mbr.mvpwithdagger.login;

/**
 * Created by mbrzeczek on 29.01.2018.
 */

public class User {

    private int id;
    private  String firstName;
    private  String lastName;


    public User(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }


}
