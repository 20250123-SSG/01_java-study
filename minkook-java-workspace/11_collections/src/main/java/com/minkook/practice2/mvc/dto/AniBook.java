package com.minkook.practice2.mvc.dto;

public class AniBook extends Book{
    private int accessAge;

    public AniBook() {
    }

    public AniBook(String title, String author, String pupblisher, int accessAge) {
        super(title, author, pupblisher);
        this.accessAge = accessAge;
    }

    public int getAccessAge() {
        return accessAge;
    }

    public void setAccessAge(int accessAge) {
        this.accessAge = accessAge;
    }

    @Override
    public String toString() {
        return super.toString() + "/" + accessAge;
    }
}
