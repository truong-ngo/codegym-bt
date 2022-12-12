package com.example.dictionary.service;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private static List<String> viet = new ArrayList<>();
    private static List<String> eng = new ArrayList<>();

    static {
        viet.add("Chuoi");
        viet.add("Tao");
        viet.add("Dua hau");
        viet.add("Xoai");
        viet.add("Cam");
        eng.add("Banana");
        eng.add("Apple");
        eng.add("Water melon");
        eng.add("Mango");
        eng.add("Orange");
    }

    public Dictionary() {
    }

    public List<String> findVni() {
        return viet;
    }

    public List<String> findEng() {
        return eng;
    }

    public int getIndex(String vni) {
        for (int i = 0; i < viet.size(); i++) {
            if (viet.get(i).equals(vni)) {
                return i;
            }
        }
        return -1;
    }
}
