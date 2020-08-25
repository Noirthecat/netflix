package com.codecool.netflix.videoservice.service;

import com.codecool.netflix.videoservice.model.Recommendation;
import com.codecool.netflix.videoservice.model.RecommendationList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class RecommendationServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation-service.url}")
    private String baseUrl;

    public List<Recommendation> getRecommendations(Long videoId) {
        log.info("get recommendations for video with id: " + videoId);

        RecommendationList body = restTemplate.getForEntity(baseUrl + "/videos/" + videoId + "/recommendations",
                RecommendationList.class).getBody();
        return body != null ? body.getRecommendations() : null;
    }

    public void addRecommendation(Long videoId, String comment) {
        log.info("add recommendation for video with id: " + videoId + ": " + comment);

        HttpEntity<String> request = new HttpEntity<>(comment);
        restTemplate.postForObject(baseUrl + "/videos/" + videoId + "/recommendations", request, String.class);
    }
}
