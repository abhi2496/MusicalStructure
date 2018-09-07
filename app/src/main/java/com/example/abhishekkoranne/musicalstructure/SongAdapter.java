package com.example.abhishekkoranne.musicalstructure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abhishekkoranne.musicalstructure.R;
import com.example.abhishekkoranne.musicalstructure.Song;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView songName = (TextView) listItemView.findViewById(R.id.song_name);
        songName.setText(currentSong.getmSongName());

        TextView songArtist = (TextView) listItemView.findViewById(R.id.song_artist);
        songArtist.setText(currentSong.getmArtistName());

        return listItemView;

    }
}