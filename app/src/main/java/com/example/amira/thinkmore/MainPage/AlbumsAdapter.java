package com.example.amira.thinkmore.MainPage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.amira.thinkmore.Chemistry.Chem_QuestionActivity;
import com.example.amira.thinkmore.Cities.City_questionactivity;
import com.example.amira.thinkmore.Math.QuestionActivity;
import com.example.amira.thinkmore.Myth.Myth_questionactivity;
import com.example.amira.thinkmore.R;


import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {
    private static int pos;
    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Album album = albumList.get(position);
        pos=position;
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + " songs");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                    showPopupMenu(holder.overflow,position);

       Log.e("position",String.valueOf(position));
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view ,int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
        pos=position;
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.action_play:
                    if(pos==0)
                    {
                        Toast.makeText(mContext, "Add to favourite 0", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(mContext,QuestionActivity.class);
                        mContext.startActivity(i);
                    }
                    else if(pos==1)
                    {
                        Toast.makeText(mContext, "Add to favourite 1", Toast.LENGTH_SHORT).show();
                        Intent ii=new Intent(mContext,Chem_QuestionActivity.class);
                        mContext.startActivity(ii);
                    }
                    else if(pos==2)
                    {
                        Toast.makeText(mContext, "Add to favourite 2", Toast.LENGTH_SHORT).show();
                        Intent ii=new Intent(mContext,Myth_questionactivity.class);
                        mContext.startActivity(ii);
                    }
                    else if(pos==3)
                    {
                        Toast.makeText(mContext, "Add to favourite 2", Toast.LENGTH_SHORT).show();
                        Intent i8=new Intent(mContext,City_questionactivity.class);
                        mContext.startActivity(i8);
                    }


                    return true;

                case R.id.action_about:
                    if(pos==0)
                    {
                        Toast.makeText(mContext, "Add to favourite 0", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(mContext,QuestionActivity.class);
                        mContext.startActivity(i);
                    }
                    else if(pos==1)
                    {
                        Toast.makeText(mContext, "Add to favourite 1", Toast.LENGTH_SHORT).show();
                        Intent ii=new Intent(mContext,Chem_QuestionActivity.class);
                        mContext.startActivity(ii);
                    }
                    else if(pos==2)
                    {
                        Toast.makeText(mContext, "Add to favourite 2", Toast.LENGTH_SHORT).show();
                        Intent ii=new Intent(mContext,Myth_questionactivity.class);
                        mContext.startActivity(ii);
                    }
                    else if(pos==3)
                    {
                        Toast.makeText(mContext, "Add to favourite 2", Toast.LENGTH_SHORT).show();
                        Intent i8=new Intent(mContext,City_questionactivity.class);
                        mContext.startActivity(i8);
                    };

                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}