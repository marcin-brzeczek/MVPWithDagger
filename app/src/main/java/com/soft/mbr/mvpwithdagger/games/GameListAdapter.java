package com.soft.mbr.mvpwithdagger.games;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.soft.mbr.mvpwithdagger.R;
import java.util.List;

/**
 * Created by mbrzeczek on 03.02.2018.
 */

import android.support.v7.widget.RecyclerView;


public class GameListAdapter extends ArrayAdapter<ViewModel> {

    private Context ctx;
    private int resLayout;
    private List<ViewModel> items;


    public GameListAdapter(Context ctx, int resLayout, List<ViewModel> items)
    {
        super(ctx, resLayout, items);
        this.ctx = ctx;
        this.resLayout = resLayout;
        this.items = items;
    }


    public static class ViewHolder {

        public TextView tTitleGame;
        public ImageView imgGame;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {

        final ViewHolder holder;

        if (convertView == null) {

            LayoutInflater vi = LayoutInflater.from(getContext());
            convertView = vi.inflate(resLayout, null);

            holder = new ViewHolder();
            holder.tTitleGame = (TextView) convertView.findViewById(R.id.tTitleGame);
            holder.imgGame = (ImageView) convertView.findViewById(R.id.imgGame);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ViewModel game = getItem(position);

        if (game != null) {
            holder.tTitleGame.setText(game.getTitleGame());
            Glide.with(ctx).load(game.getImgGame()).into(holder.imgGame);

        }
        return convertView;
    }
}

