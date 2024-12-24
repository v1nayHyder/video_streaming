package com.tech.videostreaming.controllers;

import com.tech.videostreaming.entities.YouTubeChannel;
import com.tech.videostreaming.exceptions.YouTubeChannelCreationException;
import com.tech.videostreaming.services.YouTubeChannelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/youtube")
@Validated
public class YouTubeChannelController {

    // Logger for logging important information
    private static final Logger logger = LoggerFactory.getLogger(YouTubeChannelController.class);

    // Injecting YouTubeChannelService using constructor-based dependency injection
    private final YouTubeChannelService youTubeChannelService;

    @Autowired
    public YouTubeChannelController(YouTubeChannelService youTubeChannelService) {
        this.youTubeChannelService = youTubeChannelService;
    }

    // Endpoint to create a new YouTube channel
    @PostMapping("/channels")
    public ResponseEntity<YouTubeChannel> createChannel(@Valid @RequestBody YouTubeChannel youTubeChannel) {
        try {
            YouTubeChannel createdChannel = youTubeChannelService.createChannel(youTubeChannel);
            logger.info("YouTube channel created successfully with ID: {}", createdChannel.getId());
            return new ResponseEntity<>(createdChannel, HttpStatus.CREATED);
        } catch (YouTubeChannelCreationException e) {
            logger.error("Failed to create YouTube channel", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to get a YouTube channel by its ID
    @GetMapping("/channels/{id}")
    public ResponseEntity<YouTubeChannel> getChannelById(@PathVariable Long id) {
        Optional<YouTubeChannel> channel = youTubeChannelService.getChannelById(id);
        return channel.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to update an existing YouTube channel
    @PutMapping("/channels/{id}")
    public ResponseEntity<YouTubeChannel> updateChannel(@PathVariable Long id, @Valid @RequestBody YouTubeChannel youTubeChannel) {
        youTubeChannel.setId(id);
        try {
            YouTubeChannel updatedChannel = youTubeChannelService.updateChannel(youTubeChannel);
            logger.info("YouTube channel updated successfully with ID: {}", updatedChannel.getId());
            return new ResponseEntity<>(updatedChannel, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to update YouTube channel", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to delete a YouTube channel by its ID
    @DeleteMapping("/channels/{id}")
    public ResponseEntity<Void> deleteChannel(@PathVariable Long id) {
        try {
            youTubeChannelService.deleteChannel(id);
            logger.info("YouTube channel deleted successfully with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Failed to delete YouTube channel", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to get all YouTube channels
    @GetMapping("/channels")
    public ResponseEntity<List<YouTubeChannel>> getAllChannels() {
        List<YouTubeChannel> channels = youTubeChannelService.getAllChannels();
        return new ResponseEntity<>(channels, HttpStatus.OK);
    }
}
