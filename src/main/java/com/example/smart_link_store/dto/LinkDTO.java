package com.example.smart_link_store.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkDTO {
    private Long id;
    private String url;
    private String title;
    private String description;
    private Boolean isPinned;
    private Boolean isFavorite;
    private LocalDateTime createdAt;
    private LocalDateTime lastAccessedAt;
    private List<String> tags;
    private List<String> folders;
}
