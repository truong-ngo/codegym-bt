package com.example.upload_song.repository;

import com.example.upload_song.model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song, Integer> {

}


