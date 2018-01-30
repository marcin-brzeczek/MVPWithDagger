package com.soft.mbr.mvpwithdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    @BindView(R.id.eFirstName)
    EditText eFirstName;

    @BindView(R.id.eLastName)
    EditText eLastName;

    @BindView((R.id.btnLogin))
    Button bLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
    }


    @OnClick(R.id.btnLogin)
    public void onClickBtnLogin(View view)
    {
        presenter.loginButtonClicked();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();

    }

    @Override
    public String getFirstName()
    {
        return eFirstName.getText().toString();
    }

    @Override
    public String getLastName()
    {
        return eLastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable()
    {
        Toast.makeText(this, "Error the user is not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError()
    {
        Toast.makeText(this, "First and Last name not may be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage()
    {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName)
    {
        eFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName)
    {
        eLastName.setText(lastName);
    }
}
