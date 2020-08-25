package com.codecool.netflix.videoservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceCaller {
    public List<String> getRecommendations(Long id) {
        return new ArrayList<>();
    }

    public void addRecommendation(Long id, String recommendation) {
    }
}
