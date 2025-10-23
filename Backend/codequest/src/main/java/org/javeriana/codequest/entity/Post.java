package org.javeriana.codequest.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;
}
