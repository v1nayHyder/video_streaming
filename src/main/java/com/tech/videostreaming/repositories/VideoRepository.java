package com.tech.videostreaming.repositories;

import com.tech.videostreaming.entities.Video;
import com.tech.videostreaming.enums.VideoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByUserId(Long userId);

    List<Video> findByStatus(VideoStatus status);
}
