package com.example.upload_song.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class SongForm {
    private int id;
    private String name;
    private String artist;
    private List<String> category;
    private MultipartFile audio;

    public SongForm() {
    }

    public SongForm(int id, String name, String artist, List<String> category, MultipartFile audio) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.audio = audio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public MultipartFile getAudio() {
        return audio;
    }

    public void setAudio(MultipartFile audio) {
        this.audio = audio;
    }
}
