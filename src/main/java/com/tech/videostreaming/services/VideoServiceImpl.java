package com.tech.videostreaming.services;

import com.tech.videostreaming.entities.Video;
import com.tech.videostreaming.enums.VideoStatus;
import com.tech.videostreaming.exceptions.VideoUploadingException;
import com.tech.videostreaming.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video saveVideo(Video video) {
        try {
            return videoRepository.save(video);
        } catch (Exception e) {
            throw new VideoUploadingException("Failed to save video", e);
        }
    }

    @Override
    public List<Video> getVideosByUser(Long userId) {
        return videoRepository.findByUserId(userId);
    }

    @Override
    public Optional<Video> getVideoById(Long videoId) {
        return videoRepository.findById(videoId);
    }

    @Override
    public List<Video> getVideosByStatus(VideoStatus status) {
        return videoRepository.findByStatus(status);
    }

    @Override
    public void deleteVideo(Long videoId) {
        if (videoRepository.existsById(videoId)) {
            videoRepository.deleteById(videoId);
        } else {
            throw new IllegalArgumentException("Video with ID " + videoId + " does not exist.");
        }
    }
}
