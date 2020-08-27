package com.codecool.netflix.videoservice.dao;

import com.codecool.netflix.videoservice.model.Video;
import com.codecool.netflix.videoservice.repository.VideoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class VideoDaoDB implements VideoDao {

    private VideoRepository videoRepository;

    @Override
    public void store(Video video) {
        videoRepository.save(video);
        log.info("stored video: " + video);
    }

    @Override
    public List<Video> getAll() {
        log.info("get all videos");
        return videoRepository.findAll();
    }

    @Override
    public Video getVideo(Long id) {
        log.info("get video by id: " + id);
        return videoRepository.findById(id).orElse(null);
    }
}
