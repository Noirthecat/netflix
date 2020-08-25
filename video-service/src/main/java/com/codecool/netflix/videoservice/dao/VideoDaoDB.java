package com.codecool.netflix.videoservice.dao;

import com.codecool.netflix.videoservice.model.Video;
import com.codecool.netflix.videoservice.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VideoDaoDB implements VideoDao {

    private VideoRepository videoRepository;

    @Override
    public void store(Video video) {
        videoRepository.save(video);
    }

    @Override
    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video getVideo(Long id) {
        return videoRepository.findById(id).orElse(null);
    }
}
