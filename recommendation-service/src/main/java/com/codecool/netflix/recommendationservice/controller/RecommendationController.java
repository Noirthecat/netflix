package com.codecool.netflix.recommendationservice.controller;

import com.codecool.netflix.recommendationservice.dao.RecommendationDao;
import com.codecool.netflix.recommendationservice.model.Recommendation;
import com.codecool.netflix.recommendationservice.model.RecommendationList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RecommendationController {

    private RecommendationDao recommendationDao;

    @GetMapping("/videos/{videoId}/recommendations")
    public RecommendationList getRecommendations(@PathVariable Long videoId) {
        System.out.println("get recommendations of video " + videoId);
        return recommendationDao.getRecommendations(videoId);
    }

    @PostMapping("/videos/{videoId}/recommendations")
    public Recommendation addRecommendation(@RequestBody Recommendation recommendation) {
        recommendationDao.addNewRecommendation(recommendation);
        return recommendation;
    }

    @PutMapping("/recommendations/{recommendationId}")
    public void updateRecommendation(@PathVariable Long recommendationId, @RequestBody String comment) {
        recommendationDao.updateRecommendation(recommendationId, comment);
    }

}
