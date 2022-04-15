package com.best2team.facebook_clone_be.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_post")
public class Post {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long postId;

    @OneToOne
    @JoinColumn(name = "postImageId")
    private PostImage postImage;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "commentId")
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "listId")
    private List<Like> likeList = new ArrayList<>();

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, unique = true)
    private String username;

    public Post(String content, String username) {
        this.content = content;
        this.username = username;
    }
}