package com.example.recommendationSystem.dto;

public class MovieRecommendation {

    private String title;
    private double rating;

    // Constructors
    public MovieRecommendation() {}

    public MovieRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
