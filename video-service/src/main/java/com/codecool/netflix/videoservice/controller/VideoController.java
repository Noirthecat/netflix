package com.codecool.netflix.videoservice.controller;

import com.codecool.netflix.videoservice.dao.VideoDao;
import com.codecool.netflix.videoservice.model.Recommendation;
import com.codecool.netflix.videoservice.model.Video;
import com.codecool.netflix.videoservice.model.VideoWithRecommendations;
import com.codecool.netflix.videoservice.service.RecommendationServiceCaller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/videos")
public class VideoController {

    private VideoDao videoDao;

    private RecommendationServiceCaller recommendationServiceCaller;

    @GetMapping("")
    public List<Video> getAllVideos() {
        return videoDao.getAll();
    }

    @GetMapping("/{videoId}")
    public VideoWithRecommendations getVideoWithRecommendations(@PathVariable Long videoId) {
        return new VideoWithRecommendations(
                videoDao.getVideo(videoId),
                recommendationServiceCaller.getRecommendations(videoId)
        );
    }

    @PostMapping("/{videoId}/recommendations")
    public Recommendation addRecommendation(@PathVariable Long videoId,
                                            @RequestBody Recommendation recommendation) {
        recommendation.setVideoId(videoId);
        return recommendationServiceCaller.addRecommendation(recommendation);
    }

    @PutMapping("/{videoId}/recommendations/{recommendationId}")
    public void updateRecommendation(@PathVariable Long recommendationId,
                                     @RequestBody Recommendation editedRecommendation) {
        recommendationServiceCaller.updateRecommendation(recommendationId, editedRecommendation);
    }

}
