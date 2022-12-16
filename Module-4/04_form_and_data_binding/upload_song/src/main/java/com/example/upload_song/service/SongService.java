package com.example.upload_song.service;

import com.example.upload_song.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongService implements ISongService {
    private final List<Song> songs = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        song.setId(songs.size());
        songs.add(song);
    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }

    @Override
    public void update(int id, Song song) {
        songs.set(id, song);
    }

    @Override
    public void remove(int id) {
        songs.remove(id);
    }
}
