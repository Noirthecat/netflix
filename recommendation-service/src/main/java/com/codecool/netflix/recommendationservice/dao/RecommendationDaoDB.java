package com.codecool.netflix.recommendationservice.dao;

import com.codecool.netflix.recommendationservice.model.Recommendation;
import com.codecool.netflix.recommendationservice.model.RecommendationList;
import com.codecool.netflix.recommendationservice.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RecommendationDaoDB implements RecommendationDao {

    private RecommendationRepository recommendationRepository;

    @Override
    public RecommendationList getRecommendations(Long videoId) {
        log.info("get recommendations for videoId " + videoId);
        return new RecommendationList(recommendationRepository.findAllByVideoId(videoId));
    }

    @Override
    public void addNewRecommendation(Recommendation recommendation) {
        recommendationRepository.saveAndFlush(recommendation);
        log.info("added new recommendation " + recommendation);
    }

    @Override
    public void updateRecommendation(Long recommendationId, Recommendation editedRecommendation) {
        Recommendation recommendationToBeUpdated = recommendationRepository.findById(recommendationId).orElse(null);
        if (recommendationToBeUpdated != null) {
            recommendationToBeUpdated.setComment(editedRecommendation.getComment());
            recommendationToBeUpdated.setRating(editedRecommendation.getRating());

            recommendationRepository.save(recommendationToBeUpdated);

            log.info("recommendation updated: " + editedRecommendation);
        } else {
            log.info("Recommendation with id " + recommendationId + " not found!");
        }
    }
}
