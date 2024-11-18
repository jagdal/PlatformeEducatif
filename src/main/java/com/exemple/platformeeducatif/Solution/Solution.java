package com.exemple.platformeeducatif.Solution;

public class Solution {
    private String title;
    private String description;
    private String imagePath;

    public Solution(String title, String description, String imagePath) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

}
