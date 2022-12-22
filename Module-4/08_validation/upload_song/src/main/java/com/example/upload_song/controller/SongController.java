package com.example.upload_song.controller;

import com.example.upload_song.model.Song;
import com.example.upload_song.model.SongForm;
import com.example.upload_song.repository.ISongRepository;
import com.example.upload_song.service.ISongService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;

@Controller
public class SongController {
    @Value("${upload_song}")
    private String fileUpload;

    private final ISongService songService;

    @Autowired
    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ModelAndView home() {
        Iterable<Song> songs = songService.findAll();
        return new ModelAndView("index", "songs", songs);
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView ("form");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) throws IOException {
        Song song = songService.findById(id).get();
        SongForm songForm = new SongForm(id, song.getName(), song.getArtist(), song.getCategory(), null);
        ModelAndView modelAndView = new ModelAndView ("form");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("oldFileName", song.getAudio());
        return modelAndView;
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute SongForm songForm, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "form";
        }
        String message = (songForm.getId() == null) ? "Edit successfully" : "Add successfully";
        save(songForm);
        redirect.addFlashAttribute("message", message);
        return "redirect:/";
    }

    private void save(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getAudio();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getArtist(), songForm.getCategory(), fileName);
        songService.save(song);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        Song song = songService.findById(id).get();
        File file = new File(fileUpload + song.getAudio());
        file.delete();
        songService.remove(id);
        redirect.addFlashAttribute("message", "Delete successfully");
        return "redirect:/";
    }
}
