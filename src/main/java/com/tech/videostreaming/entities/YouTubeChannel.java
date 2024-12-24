package com.tech.videostreaming.entities;

import com.tech.videostreaming.enums.ChannelVisibility;
import com.tech.videostreaming.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "youtube_channel")
public class YouTubeChannel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String username;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "profile_image_url", length = 512)
    private String profileImageUrl;

    @Column(name = "channel_banner_url", length = 512)
    private String channelBannerUrl;

    @Column(name = "subscribers")
    private Integer subscribers = 0;

    @Column(name = "videos_count")
    private Integer videosCount = 0;

    @Column(name = "verified")
    private Boolean verified;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel_visibility")
    private ChannelVisibility visibility;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Video> videos;

    // Convenience constructor for easier initialization
    public YouTubeChannel(String name, String username, String description, String profileImageUrl, String channelBannerUrl, ChannelVisibility visibility) {
        this.name = name;
        this.username = username;
        this.description = description;
        this.profileImageUrl = profileImageUrl;
        this.channelBannerUrl = channelBannerUrl;
        this.visibility = visibility;
    }

    // Optional getter for potentially null fields
    public Optional<String> getProfileImageUrl() {
        return Optional.ofNullable(profileImageUrl);
    }

    public Optional<String> getChannelBannerUrl() {
        return Optional.ofNullable(channelBannerUrl);
    }

    public Optional<Boolean> getVerified() {
        return Optional.ofNullable(verified);
    }

    // Additional methods can go here
}
