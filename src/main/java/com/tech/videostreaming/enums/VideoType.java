package com.tech.videostreaming.enums;

public enum VideoType {
    VLOG("Vlog"),
    TUTORIAL("Tutorial/How-To"),
    REVIEW("Review"),
    UNBOXING("Unboxing"),
    GAMING("Gaming"),
    EDUCATIONAL("Educational"),
    MUSIC("Music"),
    CHALLENGE("Challenge"),
    HAUL("Haul"),
    INTERVIEW("Interview"),
    PODCAST("Podcast"),
    COMEDY("Comedy/Sketch"),
    ASMR("ASMR"),
    MOTIVATIONAL("Motivational/Inspiration"),
    TRAVEL("Travel");

    private final String description;

    VideoType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
