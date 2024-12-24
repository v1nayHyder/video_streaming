package com.tech.videostreaming.controllers;

import com.tech.videostreaming.entities.Video;
import com.tech.videostreaming.enums.VideoStatus;
import com.tech.videostreaming.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    /**
     * Endpoint to create or update a video.
     *
     * @param video The video entity to be created or updated
     * @return The saved video entity
     */
    @PostMapping
    public ResponseEntity<Video> saveVideo(@RequestBody Video video) {
        Video savedVideo = videoService.saveVideo(video);
        return ResponseEntity.ok(savedVideo);
    }

    /**
     * Endpoint to fetch all videos uploaded by a specific user.
     *
     * @param userId The ID of the user
     * @return A list of videos uploaded by the user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Video>> getVideosByUser(@PathVariable Long userId) {
        List<Video> videos = videoService.getVideosByUser(userId);
        return ResponseEntity.ok(videos);
    }

    /**
     * Endpoint to fetch a video by its ID.
     *
     * @param videoId The ID of the video
     * @return The video entity if found
     */
    @GetMapping("/{videoId}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long videoId) {
        Optional<Video> video = videoService.getVideoById(videoId);
        return video.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to fetch videos by their status.
     *
     * @param status The status of the videos
     * @return A list of videos with the specified status
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Video>> getVideosByStatus(@PathVariable VideoStatus status) {
        List<Video> videos = videoService.getVideosByStatus(status);
        return ResponseEntity.ok(videos);
    }

    /**
     * Endpoint to delete a video by its ID.
     *
     * @param videoId The ID of the video to be deleted
     * @return A success message if deletion is successful
     */
    @DeleteMapping("/{videoId}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long videoId) {
        videoService.deleteVideo(videoId);
        return ResponseEntity.ok("Video deleted successfully");
    }
}
