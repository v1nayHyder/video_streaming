package com.tech.videostreaming.entities;

import com.tech.videostreaming.enums.VideoStatus;
import com.tech.videostreaming.enums.VideoType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "youtube_video")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private YouTubeChannel channel; // Assuming you have a YouTubeChannel entity

    @Column(nullable = false, length = 512)
    private String url;

    @Column(name = "thumbnail_url", length = 512)
    private String thumbnailUrl;

    private Integer duration; // in seconds

    @Column(name = "stream_key", length = 255)
    private String streamKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "video_type", length = 50)
    private VideoType videoType; // "Live", "Recorded", etc.

    private Integer views = 0;

    private Integer likes = 0;

    private Integer dislikes = 0;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Enumerated(EnumType.STRING)
    private VideoStatus status;  // Enum to represent video status (e.g., PENDING, PUBLISHED, REMOVED)

}
