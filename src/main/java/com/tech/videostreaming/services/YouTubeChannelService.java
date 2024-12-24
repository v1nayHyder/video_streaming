package com.tech.videostreaming.services;

import com.tech.videostreaming.entities.Video;
import com.tech.videostreaming.entities.YouTubeChannel;
import com.tech.videostreaming.exceptions.YouTubeChannelCreationException;
import com.tech.videostreaming.exceptions.VideoUploadingException;
import java.util.List;
import java.util.Optional;

public interface YouTubeChannelService {

    /**
     * Create a new YouTube channel.
     *
     * @param channel The YouTubeChannel object to create
     * @return The created YouTubeChannel object
     * @throws YouTubeChannelCreationException if creation fails
     */
    YouTubeChannel createChannel(YouTubeChannel channel) throws YouTubeChannelCreationException;

    /**
     * Retrieve a YouTube channel by its ID.
     *
     * @param id The ID of the YouTube channel
     * @return An Optional containing the YouTubeChannel object, if found
     */
    Optional<YouTubeChannel> getChannelById(Long id);

    /**
     * Update an existing YouTube channel.
     *
     * @param channel The YouTubeChannel object with updated information
     * @return The updated YouTubeChannel object
     */
    YouTubeChannel updateChannel(YouTubeChannel channel);

    /**
     * Delete a YouTube channel by its ID.
     *
     * @param id The ID of the YouTube channel to delete
     */
    void deleteChannel(Long id);

    /**
     * Retrieve all YouTube channels.
     *
     * @return A list of all YouTubeChannel objects
     */
    List<YouTubeChannel> getAllChannels();

    /**
     * Upload a video to a specific YouTube channel.
     *
     * @param channelId The ID of the YouTube channel
     * @param video The video to be uploaded
     * @throws VideoUploadingException if uploading fails
     */
    void uploadVideo(Long channelId, Video video) throws VideoUploadingException;
}
