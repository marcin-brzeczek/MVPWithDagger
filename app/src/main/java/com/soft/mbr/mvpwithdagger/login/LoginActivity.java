package com.soft.mbr.mvpwithdagger.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.soft.mbr.mvpwithdagger.R;
import com.soft.mbr.mvpwithdagger.root.BaseActivity;
import com.soft.mbr.mvpwithdagger.root.LoginActivityComponent;
import com.soft.mbr.mvpwithdagger.root.di.activity.HasActivitySubcomponentBuilders;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginActivityMVP.View {

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

    }
    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((LoginActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(LoginActivity.class))
                .activityModule(new LoginActivityComponent.LoginActivityModule(this))
                .build()
                .injectMembers(this);
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

    @Override
    public Context getCurrentContext()
    {
        return this;
    }
}
