package com.codecool.netflix.recommendationservice.dao;

import com.codecool.netflix.recommendationservice.model.RecommendationList;

public interface RecommendationDao {

    RecommendationList getRecommendations(Long videoId);

    void addNewRecommendation(Long videoId, String comment);

    void updateRecommendation(Long recommendationId, String comment);

}
