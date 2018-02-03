package com.soft.mbr.mvpwithdagger.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.soft.mbr.mvpwithdagger.R;
import com.soft.mbr.mvpwithdagger.games.GameListActivity;
import com.soft.mbr.mvpwithdagger.movies.MovieListActivity;

import java.util.ArrayList;

/**
 * Created by mbrzeczek on 03.02.2018.
 */

public class MenuItemAdapter extends BaseAdapter {

    private ArrayList<ViewModel> data;
    private AppCompatActivity activity;

    public MenuItemAdapter(AppCompatActivity context, ArrayList<ViewModel> objects)
    {
        this.activity = context;
        this.data = objects;
    }


    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public ViewModel getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_flow_view, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv.setText(data.get(position).getTitle());
        Glide.with(activity).load(data.get(position).getImg()).into(viewHolder.img);

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position)
    {
        return new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v)
            {
                switch (data.get(position).getTitle()) {
                    case "Movies":

                        activity.startActivity(new Intent(activity, MovieListActivity.class));
                        break;

                    case "Games":
                        activity.startActivity(new Intent(activity, GameListActivity.class));
                        break;

                    case "Test1":
                        Toast.makeText(activity, "This is template only for test.", Toast.LENGTH_SHORT).show();
                        break;

                    case "Test2":
                        Toast.makeText(activity, "This is template only for test.", Toast.LENGTH_SHORT).show();
                        break;


                }
            }
        };
    }

    private static class ViewHolder {
        private ImageView img;
        private TextView tv;

        public ViewHolder(View v)
        {
            img = (ImageView) v.findViewById(R.id.img);
            tv = (TextView) v.findViewById(R.id.txtTitile);
        }
    }
}
