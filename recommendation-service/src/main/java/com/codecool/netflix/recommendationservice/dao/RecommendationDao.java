package com.codecool.netflix.recommendationservice.dao;

import com.codecool.netflix.recommendationservice.model.Recommendation;

import java.util.List;

public interface RecommendationDao {

    List<Recommendation> getRecommendations(Long videoId);

    void addNewRecommendation(Long videoId, String comment);

    void updateRecommendation(Long recommendationId, String comment);

}
