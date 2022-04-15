package com.best2team.facebook_clone_be.model;

import com.best2team.facebook_clone_be.dto.ImageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_post_image")
public class PostImage {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long postImageId;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false, unique = true)
    private String postImageUrl;

    @Column(nullable = false)
    private String fileName;

    public PostImage(ImageDto imageDto) {
        this.postImageUrl=imageDto.getImageUrl();
        this.fileName = imageDto.getFileName();
    }
}
