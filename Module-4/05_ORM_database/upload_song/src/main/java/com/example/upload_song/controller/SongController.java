package com.example.upload_song.controller;

import com.example.upload_song.model.Song;
import com.example.upload_song.model.SongForm;
import com.example.upload_song.repository.ISongRepository;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

@Controller
public class SongController {
    @Value("${upload_song}")
    private String fileUpload;
    @Autowired
    private ISongRepository songRepository;

    @GetMapping
    public ModelAndView home() {
        List<Song> songs = songRepository.findAll();
        return new ModelAndView("index", "songs", songs);
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView ("create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) throws IOException {
        Song song = songRepository.findById(id);
        File file = new File(fileUpload + song.getAudio());
        FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
        try (InputStream input = Files.newInputStream(file.toPath());)  {
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        SongForm songForm = new SongForm(id, song.getName(), song.getArtist(), song.getCategory(), multipartFile);
        ModelAndView modelAndView = new ModelAndView ("form");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("oldFileName", song.getAudio());
        return modelAndView;
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
        songRepository.save(song);
        redirect.addFlashAttribute("message", "Add successfully");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SongForm songForm, @RequestParam(name = "old_file_name", required = false) String oldFileName, RedirectAttributes redirect) {
        MultipartFile multipartFile = songForm.getAudio();
        File file = new File(fileUpload + oldFileName);
        file.delete();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getCategory(), fileName);
        songRepository.update(songForm.getId(), song);
        redirect.addFlashAttribute("message", "Update successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        Song song = songRepository.findById(id);
        File file = new File(fileUpload + song.getAudio());
        file.delete();
        songRepository.remove(id);
        redirect.addFlashAttribute("message", "Delete successfully");
        return "redirect:/";
    }
}
