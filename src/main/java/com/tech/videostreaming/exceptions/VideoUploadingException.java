package com.tech.videostreaming.exceptions;

/**
 * Exception thrown when there is an issue with uploading a video.
 */
public class VideoUploadingException extends RuntimeException {

    public VideoUploadingException(String message) {
        super(message);
    }

    public VideoUploadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
