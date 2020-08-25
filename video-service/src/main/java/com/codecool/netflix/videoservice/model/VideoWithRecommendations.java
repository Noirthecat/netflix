package com.codecool.netflix.videoservice.model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VideoWithRecommendations {
    private Video video;
    private List<String> recommendations;
}
