package com.example.recommendationSystem.controller;

import com.example.recommendationSystem.model.MovieRecommendation;
import com.example.recommendationSystem.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public List<MovieRecommendation> getRecommendations(@PathVariable int userId) {
        return recommendationService.getRecommendations(userId);

    }
}
