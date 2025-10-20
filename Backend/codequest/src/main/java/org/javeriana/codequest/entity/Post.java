package org.javeriana.codequest.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false) // Cambiado de "user" a "user_name"
    private String user;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private String level;

    @Column(name = "post_date", nullable = false) // Cambiado de "date" a "post_date"
    private String date;

    @Column(nullable = false, length = 4000)
    private String content;

    private String image;

    @Column(nullable = false)
    private Integer likes;

    @Column(nullable = false)
    private Boolean liked;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentModel> comments;
}
