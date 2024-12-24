package com.tech.videostreaming.exceptions;

/**
 * Exception thrown when there is an issue with creating a YouTube channel.
 */
public class YouTubeChannelCreationException extends RuntimeException {

    public YouTubeChannelCreationException(String message) {
        super(message);
    }

    public YouTubeChannelCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
