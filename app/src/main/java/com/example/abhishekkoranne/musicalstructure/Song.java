package com.example.abhishekkoranne.musicalstructure;

public class Song {
    private String mSongName;
    private String mSongGenre;
    private String mArtistName;

    public String getmSongName() {
        return mSongName;
    }

    public String getmSongGenre() {
        return mSongGenre;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public Song(String songName, String songGenre, String artistName) {
        mSongName = songName;
        mSongGenre = songGenre;
        mArtistName = artistName;
    }
}
