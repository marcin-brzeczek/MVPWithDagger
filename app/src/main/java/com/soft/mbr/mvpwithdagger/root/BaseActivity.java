package com.soft.mbr.mvpwithdagger.root;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.soft.mbr.mvpwithdagger.R;
import com.soft.mbr.mvpwithdagger.root.di.activity.HasActivitySubcomponentBuilders;


/**
 * Created by mbrzeczek on 29.01.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected void setupActivityComponent() {
        injectMembers(App.get(this));
    }

    protected abstract void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders);



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id) {


            case R.id.endProgramItem:
                showEndProgramDialog();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void showEndProgramDialog()
    {
        AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder
                .setTitle(getResources().getString(R.string.exitProgram))
                .setMessage(getResources().getString(R.string.exitProgramText))
                .setPositiveButton(getResources().getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.cancel();
                                BaseActivity.this.finish();
                                moveTaskToBack(true);
                            }
                        })
                .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                }).show();
    }

}
