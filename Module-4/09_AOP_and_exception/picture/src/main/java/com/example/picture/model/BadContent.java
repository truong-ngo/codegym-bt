package com.example.picture.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BadContent {
    private List<String> badContents;

    public BadContent() {
        badContents = new ArrayList<>();
        badContents.add("suck");
        badContents.add("fuck");
        badContents.add("shit");
        badContents.add("pussy");
        badContents.add("nigga");
        badContents.add("whore");
        badContents.add("asshole");
        badContents.add("dick");
        badContents.add("motherfucker");
    }

    public List<String> getBadContents() {
        return badContents;
    }

    public void setBadContents(List<String> badContents) {
        this.badContents = badContents;
    }
}
