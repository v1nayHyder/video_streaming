package com.tech.videostreaming.services;

import com.tech.videostreaming.entities.Video;
import com.tech.videostreaming.enums.VideoStatus;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing videos.
 */
public interface VideoService {

    /**
     * Create or update a video.
     *
     * @param video The video entity to be saved
     * @return The saved Video entity
     */
    Video saveVideo(Video video);

    /**
     * Get all videos uploaded by a specific user.
     *
     * @param userId The ID of the user
     * @return A list of videos uploaded by the user
     */
    List<Video> getVideosByUser(Long userId);

    /**
     * Get a specific video by its ID.
     *
     * @param videoId The ID of the video
     * @return An Optional containing the video if found, or empty if not
     */
    Optional<Video> getVideoById(Long videoId);

    /**
     * Get videos by their status.
     *
     * @param status The status of the videos (e.g., PENDING, PUBLISHED, REMOVED)
     * @return A list of videos with the specified status
     */
    List<Video> getVideosByStatus(VideoStatus status);

    /**
     * Delete a video by its ID.
     *
     * @param videoId The ID of the video to be deleted
     */
    void deleteVideo(Long videoId);
}
