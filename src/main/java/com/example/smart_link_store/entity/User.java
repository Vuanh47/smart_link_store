package com.example.smart_link_store.entity;

import jakarta.persistence.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String profileImage; // link ảnh đại diện

    // Quan hệ 1-n với Links
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Link> links;

    // Quan hệ 1-n với Folder
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Folder> folders;
}
