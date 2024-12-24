package com.tech.videostreaming.enums;

public enum ChannelVisibility {
    PUBLIC("Public Channel"),
    PRIVATE("Private Channel"),
    UNLISTED("Unlisted Channel");

    private final String description;

    ChannelVisibility(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
