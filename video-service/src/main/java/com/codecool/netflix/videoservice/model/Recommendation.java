package com.codecool.netflix.videoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    private Long id;

    private int rating;

    private String comment;

    private Long videoId;
}
