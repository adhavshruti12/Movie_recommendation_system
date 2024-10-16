package com.example.recommendationSystem.service;

import com.example.recommendationSystem.model.MovieRecommendation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;





@Service
public class RecommendationService {
    // Define the logger
    private static final Logger logger = LoggerFactory.getLogger(RecommendationService.class);

    @Autowired
    private RestTemplate restTemplate;

    private final String recommendationApiUrl = "http://localhost:5000/recommend/{id}";

    public List<MovieRecommendation> getRecommendations(int userId) {
        try {
            ResponseEntity<List<MovieRecommendation>> response = restTemplate.exchange(
                    recommendationApiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<MovieRecommendation>>() {},
                    userId
            );
            return response.getBody();
        } catch (RestClientException e) {
            // Log the error
            logger.error("Error fetching recommendations for userId " + userId, e);
            return Collections.emptyList(); // Return an empty list in case of error
        }
    }
}
