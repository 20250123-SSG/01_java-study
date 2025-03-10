package com.john.section04.map.dto;

public class Snack {
    private String flavor;
    private int calories;

    public Snack() {
    }

    public Snack(String flavor, int calories) {
        this.flavor = flavor;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "flavor='" + flavor + '\'' +
                ", calories=" + calories +
                '}';
    }
}
