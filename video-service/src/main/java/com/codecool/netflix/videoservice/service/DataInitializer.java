package com.codecool.netflix.videoservice.service;

import com.codecool.netflix.videoservice.dao.VideoDao;
import com.codecool.netflix.videoservice.model.Video;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("production")
@AllArgsConstructor
public class DataInitializer {

    private VideoDao videoDao;

    @PostConstruct
    public void init() {
        videoDao.store(Video.builder()
                .name("Codecool - Microservices with Spring Cloud #3")
                .url("https://www.youtube.com/watch?v=_Op_sKBWBlk")
                .build());

        videoDao.store(Video.builder()
                .name("“180” Movie")
                .url("https://www.youtube.com/watch?v=7y2KsU_dhwI")
                .build());

        videoDao.store(Video.builder()
                .name("The Fool - Full Movie")
                .url("https://www.youtube.com/watch?v=hlCc_TA7gw8")
                .build());
    }

}
