package com.example.smart_link_store.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.smart_link_store.entity.Tag;  // Import đúng entity Tag


@Entity
@Table(name = "links")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String url;

    private String title;

    private String description;

    private Boolean isPinned = false;    // ghim
    private Boolean isFavorite = false;  // yêu thích

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime lastAccessedAt;

    // Quan hệ nhiều-nhiều với Tags
    @ManyToMany
    @JoinTable(
            name = "link_tags",
            joinColumns = @JoinColumn(name = "link_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    // Quan hệ nhiều-nhiều với Folder
    @ManyToMany
    @JoinTable(
            name = "link_folders",
            joinColumns = @JoinColumn(name = "link_id"),
            inverseJoinColumns = @JoinColumn(name = "folder_id")
    )
    private Set<Folder> folders = new HashSet<>();
}
