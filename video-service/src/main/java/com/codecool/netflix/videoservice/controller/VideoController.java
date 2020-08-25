package com.codecool.netflix.videoservice.controller;

import com.codecool.netflix.videoservice.dao.VideoDao;
import com.codecool.netflix.videoservice.model.Video;
import com.codecool.netflix.videoservice.model.VideoWithRecommendations;
import com.codecool.netflix.videoservice.service.RecommendationServiceCaller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VideoController {

    private VideoDao videoDao;

    private RecommendationServiceCaller recommendationServiceCaller;

    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoDao.getAll();
    }

    @GetMapping("/videos/{id}")
    public VideoWithRecommendations getVideoWithRecommendations(@PathVariable Long id) {
        return new VideoWithRecommendations(
                videoDao.getVideo(id),
                recommendationServiceCaller.getRecommendations(id)
        );
    }

    @PostMapping("/videos/{id}/recommendations")
    public void addRecommendation(@PathVariable Long id, @RequestBody String recommendation) {
        recommendationServiceCaller.addRecommendation(id, recommendation);
    }

    @PutMapping("/recommendations/{recommendationId}")
    public void updateRecommendation(@PathVariable Long recommendationId, @RequestBody String comment) {
        recommendationServiceCaller.updateRecommendation(recommendationId, comment);
    }

}
