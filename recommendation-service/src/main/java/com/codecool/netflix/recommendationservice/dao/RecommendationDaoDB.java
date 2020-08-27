package com.codecool.netflix.recommendationservice.dao;

import com.codecool.netflix.recommendationservice.model.Recommendation;
import com.codecool.netflix.recommendationservice.model.RecommendationList;
import com.codecool.netflix.recommendationservice.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RecommendationDaoDB implements RecommendationDao {

    private RecommendationRepository recommendationRepository;

    @Override
    public RecommendationList getRecommendations(Long videoId) {
         return new RecommendationList(recommendationRepository.findAllByVideoId(videoId));
    }

    @Override
    public void addNewRecommendation(Recommendation recommendation) {
        recommendationRepository.saveAndFlush(recommendation);
    }

    @Override
    public void updateRecommendation(Long recommendationId, String comment) {
        Recommendation recommendation = recommendationRepository.findById(recommendationId).orElse(null);
        if (recommendation != null) {
            recommendation.setComment(comment);
            recommendationRepository.save(recommendation);
        } else {
            log.info("Recommendation with id " + recommendationId + " not found!");
        }
    }
}
