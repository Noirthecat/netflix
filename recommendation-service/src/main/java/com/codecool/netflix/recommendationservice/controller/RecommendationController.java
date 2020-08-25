package com.codecool.netflix.recommendationservice.controller;

import com.codecool.netflix.recommendationservice.dao.RecommendationDao;
import com.codecool.netflix.recommendationservice.model.Recommendation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecommendationController {

    private RecommendationDao recommendationDao;

    @GetMapping("/videos/{videoId}/recommendations")
    public List<Recommendation> getRecommendations(@PathVariable Long videoId) {
        return recommendationDao.getRecommendations(videoId);
    }

    @PostMapping("/videos/{videoId}/recommendations")
    public void addRecommendation(@PathVariable Long videoId, @RequestBody String comment) {
        recommendationDao.addNewRecommendation(videoId, comment);
    }

    @PutMapping("/recommendations/{recommendationId}")
    public void updateRecommendation(@PathVariable Long recommendationId, @RequestBody String comment) {
        recommendationDao.updateRecommendation(recommendationId, comment);
    }

}
