package com.codecool.netflix.videoservice.dao;

import com.codecool.netflix.videoservice.model.Video;

import java.util.List;

public interface VideoDao {

    void store (Video video);

    List<Video> getAll();

    Video getVideo(Long id);

}
