package com.example.sandwich.model;

public class Sandwich {
    private String lettuce;
    private String tomato;
    private String mustard;
    private String sprouts;

    public Sandwich(String lettuce, String tomato, String mustard, String sprouts) {
        this.lettuce = lettuce;
        this.tomato = tomato;
        this.mustard = mustard;
        this.sprouts = sprouts;
    }

    public String getLettuce() {
        return lettuce;
    }

    public void setLettuce(String lettuce) {
        this.lettuce = lettuce;
    }

    public String getTomato() {
        return tomato;
    }

    public void setTomato(String tomato) {
        this.tomato = tomato;
    }

    public String getMustard() {
        return mustard;
    }

    public void setMustard(String mustard) {
        this.mustard = mustard;
    }

    public String getSprouts() {
        return sprouts;
    }

    public void setSprouts(String sprouts) {
        this.sprouts = sprouts;
    }
}
