package com.example.abhishekkoranne.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private SongAdapter songAdapter;
    private ArrayList<Song> songList;
    private ListView listView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initList();
        loadData();
    }

    private void initList() {
        listView = getActivity().findViewById(R.id.list);
    }

    private void loadData() {
        songList = new ArrayList<>();
        songList.add(new Song(getString(R.string.song_perfect), getString(R.string.genre_romance), getString(R.string.artist_ed_sheeran)));
        songList.add(new Song(getString(R.string.song_gerua), getString(R.string.genre_romance), getString(R.string.artist_arijit_antara)));
        songList.add(new Song(getString(R.string.song_raabta), getString(R.string.genre_romance), getString(R.string.artist_arijit)));
        songList.add(new Song(getString(R.string.song_jee_karda), getString(R.string.genre_workout), getString(R.string.artist_divya)));
        songList.add(new Song(getString(R.string.song_radioactive), getString(R.string.genre_workout), getString(R.string.artist_imagine_dragons)));
        songList.add(new Song(getString(R.string.song_numb_encore), getString(R.string.genre_workout), getString(R.string.artist_jay_z_linkin)));
        songList.add(new Song(getString(R.string.song_word_hard), getString(R.string.genre_edm), getString(R.string.artist_tiesto_kay)));
        songList.add(new Song(getString(R.string.song_under_control), getString(R.string.genre_edm), getString(R.string.artist_calvin)));
        songList.add(new Song(getString(R.string.song_jhuki_jhuki_si_nazar), getString(R.string.genre_ghazal), getString(R.string.artist_jagjit)));
        songList.add(new Song(getString(R.string.song_ahista), getString(R.string.genre_ghazal), getString(R.string.artist_pankaj)));

        songAdapter = new SongAdapter(getActivity(), songList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) parent.getItemAtPosition(position);
                Intent songNameIntent = new Intent(getActivity(), SongActivity.class);
                startActivity(songNameIntent);
            }
        });

        listView.setAdapter(songAdapter);
    }
}