package org.javeriana.codequest.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer xp;

    @Column(name = "max_xp", nullable = false)
    private Integer maxXp;

    @Column(nullable = false)
    private String rank;

    //Debe tener sus proyectos realizados, inscritos
    //Debe tener sus cursos realizados, en proceso y en WishList
    //Debe tener sus reviews realizados
    //Debe tener sus carrerPath realizados y en proceso
    //Debe tener sus posts realizados
    //Debe tener sus badges obtenidos
    //Debe tener sus powers obtenidos
    //Debe tener sus products obtenidos
    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Project> projectsDone;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Project> projectsInProgress;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Course> coursesDone;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Course> coursesInProgress;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Review> reviews;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<CareerPath> carrerPathsDone;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<CareerPath> carrerPathsInProgress;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Post> posts;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Badge> badges;

    @Column(nullable = true)
    @OneToMany(mappedBy = "userProfile")
    private List<Power> powers;

}
