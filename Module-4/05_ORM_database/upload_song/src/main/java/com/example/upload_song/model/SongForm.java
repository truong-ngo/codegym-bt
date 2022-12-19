package com.example.upload_song.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private Integer id;
    private String name;
    private String artist;
    private String category;
    private MultipartFile audio;

    public SongForm() {
    }

    public SongForm(int id, String name, String artist, String category, MultipartFile audio) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getAudio() {
        return audio;
    }

    public void setAudio(MultipartFile audio) {
        this.audio = audio;
    }
}
