package com.tech.videostreaming.services;

import com.tech.videostreaming.entities.Video;
import com.tech.videostreaming.entities.YouTubeChannel;
import com.tech.videostreaming.exceptions.VideoUploadingException;
import com.tech.videostreaming.exceptions.YouTubeChannelCreationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YouTubeChannelServiceImpl implements YouTubeChannelService{
    @Override
    public YouTubeChannel createChannel(YouTubeChannel channel) throws YouTubeChannelCreationException {
        return null;
    }

    @Override
    public Optional<YouTubeChannel> getChannelById(Long id) {
        return Optional.empty();
    }

    @Override
    public YouTubeChannel updateChannel(YouTubeChannel channel) {
        return null;
    }

    @Override
    public void deleteChannel(Long id) {

    }

    @Override
    public List<YouTubeChannel> getAllChannels() {
        return List.of();
    }

    @Override
    public void uploadVideo(Long channelId, Video video) throws VideoUploadingException {

    }
}
