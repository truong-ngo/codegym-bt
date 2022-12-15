package com.example.email.model;

public class Setting {
    private String language;
    private int size;
    private boolean spam;
    private String signature;

    public Setting() {
    }

    public Setting(String language, int size, boolean spam, String signature) {
        this.language = language;
        this.size = size;
        this.spam = spam;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
