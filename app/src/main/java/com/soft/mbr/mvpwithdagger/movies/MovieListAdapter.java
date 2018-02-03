package com.soft.mbr.mvpwithdagger.movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soft.mbr.mvpwithdagger.R;

import java.util.List;

/**
 * Created by mbrzeczek on 01.02.2018.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ListItemViewHolder> {


    private List<ViewModel> list;

    public MovieListAdapter(List<ViewModel> list)
    {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);

        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position)
    {
        holder.itemName.setText(list.get(position).getName());
        holder.countryName.setText(list.get(position).getCountry());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public TextView countryName;
        public ListItemViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.tMovieName);
            countryName = (TextView) itemView.findViewById(R.id.tCountryName);
        }
    }

}
