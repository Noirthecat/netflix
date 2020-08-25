package com.codecool.netflix.videoservice.service;

import com.codecool.netflix.videoservice.model.Recommendation;
import com.codecool.netflix.videoservice.model.RecommendationList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class RecommendationServiceCaller {

    private RestTemplate restTemplate;

    public RecommendationServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${recommendation-service.url}")
    private String baseUrl;

    public List<Recommendation> getRecommendations(Long videoId) {
        log.info("get recommendations for video (id: " + videoId + ")");

        String url = baseUrl + "/videos/" + videoId + "/recommendations";
        RecommendationList body = restTemplate.getForEntity(url, RecommendationList.class).getBody();
        return body != null ? body.getRecommendations() : null;
    }

    public void addRecommendation(Long videoId, String comment) {
        log.info("add recommendation for video (id: " + videoId + "): " + comment);

        HttpEntity<String> request = new HttpEntity<>(comment);
        String url = baseUrl + "/videos/" + videoId + "/recommendations";
        restTemplate.postForObject(url, request, String.class);
    }

    public void updateRecommendation(Long recommendationId, String comment) {
        log.info("update recommendation (id: " + recommendationId + "): " + comment);

        String url = baseUrl + "/recommendations/" + recommendationId;
        HttpEntity<String> requestUpdate = new HttpEntity<>(comment);
        restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
    }

}
