package com.codecool.netflix.recommendationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommendationList {
    private List<Recommendation> recommendations;
}
