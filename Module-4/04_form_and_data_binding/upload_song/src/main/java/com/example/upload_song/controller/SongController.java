package com.example.upload_song.controller;

import com.example.upload_song.model.Song;
import com.example.upload_song.model.SongForm;
import com.example.upload_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class SongController {
    @Value("${upload_song}")
    private String fileUpload;
    @Autowired
    private ISongService songService;

    @GetMapping
    public ModelAndView home() {
        List<Song> songs = songService.findAll();
        return new ModelAndView("index", "songs", songs);
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("form", "songForm", new SongForm());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SongForm songForm, RedirectAttributes redirect) {
        MultipartFile multipartFile = songForm.getAudio();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getCategory(), fileName);
        songService.save(song);
        redirect.addFlashAttribute("message", "Add successfully");
        return "redirect:/";
    }
}
