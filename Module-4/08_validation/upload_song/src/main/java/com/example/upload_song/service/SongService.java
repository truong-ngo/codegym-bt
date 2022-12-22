package com.example.upload_song.service;

import com.example.upload_song.model.Song;
import com.example.upload_song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
    private final ISongRepository songRepository;

    @Autowired
    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Integer id) {
        songRepository.deleteById(id);
    }
}
