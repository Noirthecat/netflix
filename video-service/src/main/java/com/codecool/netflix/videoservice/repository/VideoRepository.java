package com.codecool.netflix.videoservice.repository;

import com.codecool.netflix.videoservice.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
