package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public  CustomAdapter (Context context, int resource, ArrayList<Song> objects) {

        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView txtSongTitle = rowView.findViewById(R.id.txtSongTitle);
        TextView txtSingers = rowView.findViewById(R.id.txtSingers);
        TextView txtYearRel = rowView.findViewById(R.id.txtYearReleased);
        TextView txtStars = rowView.findViewById(R.id.txtStars);



        // Obtain the Android Version information based on the position
        Song currSong = songList.get(position);

        String stars = "";
        if (currSong.getStars() == 5){
            stars = "* * * * *";
        }
        else if (currSong.getStars() == 4){
            stars = "* * * *";
        }
        else if (currSong.getStars() == 3){
            stars = "* * *";
        }
        else if (currSong.getStars() == 2){
            stars = "* *";
        }
        else if (currSong.getStars() == 1){
            stars = "*";
        }
        else {
            stars = "";
        }
        // Set values to the TextView to display the corresponding information
        txtSongTitle.setText(currSong.getTitle());
        txtSingers.setText(currSong.getSingers());
        txtYearRel.setText(currSong.getYearReleased() + "");
        txtStars.setText(stars);
        txtStars.setTypeface(null, Typeface.BOLD); // tried to bold stars

        return rowView;
    }

}
