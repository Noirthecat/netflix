package com.codecool.netflix.recommendationservice.dao;

import com.codecool.netflix.recommendationservice.model.Recommendation;
import com.codecool.netflix.recommendationservice.model.RecommendationList;

public interface RecommendationDao {

    RecommendationList getRecommendations(Long videoId);

    void addNewRecommendation(Recommendation recommendation);

    void updateRecommendation(Long recommendationId, Recommendation editedRecommendation);

}
