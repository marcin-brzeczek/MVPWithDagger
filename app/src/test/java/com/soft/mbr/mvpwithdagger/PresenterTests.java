package com.soft.mbr.mvpwithdagger;

import com.soft.mbr.mvpwithdagger.login.LoginActivityMVP;
import com.soft.mbr.mvpwithdagger.login.LoginActivityPresenter;
import com.soft.mbr.mvpwithdagger.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by mbrzeczek on 30.01.2018.
 */

public class PresenterTests {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;


    @Before
    public void setup()
    {
        mockLoginModel = mock(LoginActivityMVP.Model.class);

        user = new User("Fox", "Mulder");

        when(mockLoginModel.getUser()).thenReturn(user);

        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);

        presenter.setView(mockView);
    }

    /*test ma na celu sprawdzenie jaki wpływ na widok ma user == null*/
//    @Test
//    public void noIterationWithView(){
//
//        presenter.getCurrentUser();
//
//        verifyZeroInteractions(mockView);
//    }

    /*zwerfikuj czy jest ustawiony prawidłowy użytkownik*/
    @Test
    public void loadTheUserfromTheRepositoryWhenValidUserIsPresent()
    {

        /*kiedy model pobierze użytkownika to zwróc użytkownika*/
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        /*zweryfikuj interakcje w modelu*/
        verify(mockLoginModel, times(1)).getUser();

        /*zweryfikuj interakcje w widoku*/
        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        verify(mockView, never()).showUserNotAvailable();

    }

    /*zwerifuj czy zostanie wywołany błąd jeśli user == null*/
    @Test
    public void shouldShowErrorMessageWhenUserIsNUll(){
        when(mockLoginModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        /*sprawdź model*/
        verify(mockLoginModel, times(1)).getUser();

        /*sprawdź widok*/
        verify(mockView, never()).setFirstName("Fox");
        verify(mockView, never()).setLastName("Mulder");
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldCreateErrorMsgIfFieldAreEmpty(){

        when(mockView.getFirstName()).thenReturn(""); // empty string

        presenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, (never())).getLastName();
        verify(mockView, times(1)).showError();

        /*set first name and last name empty*/
        when(mockView.getFirstName()).thenReturn("Dana"); // empty string
        when(mockView.getLastName()).thenReturn(""); // empty string

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName(); /*Wywołane dwa razy bo wcześniej i teraz*/
        verify(mockView, times(1)).getLastName(); // wywołane raz
        verify(mockView, times(2)).showError(); /*wywołane dwa razy bo wcześniej i teraz*/


    }
}
