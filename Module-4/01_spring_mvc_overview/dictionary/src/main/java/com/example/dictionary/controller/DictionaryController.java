package com.example.dictionary.controller;

import com.example.dictionary.service.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DictionaryController {
    @Autowired
    private Dictionary dictionary;

    @GetMapping("/")
    public ModelAndView toHome() {
        return new ModelAndView("index");
    }

    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam String vni) {
        ModelAndView modelAndView = new ModelAndView("index");
        int index = dictionary.getIndex(vni);
        List<String> eng = dictionary.findEng();
        String mess = null;
        if (index == -1) {
            mess = "Word not found";
        } else {
            mess = eng.get(index);
        }
        modelAndView.addObject("mess", mess);
        return modelAndView;
    }
}
